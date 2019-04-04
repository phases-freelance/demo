/**
 * 
 */
package com.example.demo.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.BranchRepository;
import com.example.demo.dao.ValueRepository;
import com.example.demo.entity.Branch;
import com.example.demo.entity.CostByDate;
import com.example.demo.entity.Value;
import com.example.demo.service.InputFileProcessService;

/**
 * @author arockia
 *
 */
@Service("INPUT_FILE_PROCESS")
public class InputFileProcessServiceImpl implements InputFileProcessService {

	private static final Logger LOGGER = LoggerFactory.getLogger(InputFileProcessServiceImpl.class);

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private ValueRepository valueRepository;

	@Transactional
	@Override
	public Boolean fileProcess(MultipartFile file) {
		LOGGER.debug("InputFileProcessServiceImpl -- add -- start");
		List<Branch> branchList = new ArrayList<>();
		Branch branch = null;
		try {
//			FileInputStream excelFile = new FileInputStream(new File("/home/kloudone/Downloads/random.xlsx"));
			FileInputStream excelFile = new FileInputStream(new File("/home/mds-pc/Downloads/random.xlsx"));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			Iterator<Row> iterator = datatypeSheet.iterator();
			List<String> headingList = new ArrayList<>();
			Row currentRow = iterator.next();
			headingList = readHeadingCells(currentRow);
			Integer count = 1;
			while (iterator.hasNext()) {
				if(count < 129) {
					currentRow = iterator.next();
					branch = readCells(currentRow, headingList, evaluator);
					branchList.add(branch);
					count++;
				}else {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		branchRepository.saveAll(branchList);
		LOGGER.debug("InputFileProcessServiceImpl -- add -- end");
		return true;
	}

	public List<String> readHeadingCells(Row currentRow) {
		List<String> values = new ArrayList<>();
		Iterator<Cell> cellIterator = currentRow.iterator();
		while (cellIterator.hasNext()) {
			Cell currentCell = cellIterator.next();
			values.add(currentCell.getStringCellValue());
		}
		return values;
	}

	public Branch readCells(Row currentRow, List<String> headingList, FormulaEvaluator evaluator) {
		List<Value> valueList = valueRepository.findAll();
		Branch branchObj = new Branch();
		Iterator<Cell> cellIterator = currentRow.iterator();
		Cell currentCell = cellIterator.next();
		String branchName = currentCell.getStringCellValue();
		branchObj.setBranchName(branchName);
		currentCell = cellIterator.next();
		String valueName = currentCell.getStringCellValue();
		Value valueObj = valueList.stream().filter(i -> i.getName().equals(valueName)).findAny().orElse(null);
		branchObj.setValue(valueObj);
		Set<CostByDate> costByDates = new HashSet<>();
		CostByDate costByDate = null;
		Integer count = 2;
		while (cellIterator.hasNext()) {
			currentCell = cellIterator.next();
			CellValue cellValue = evaluator.evaluate(currentCell);
			  Date date;
			  if(count == headingList.size()-1) {
				  Double val = cellValue.getNumberValue();
				  Double d = currentCell.getNumericCellValue();
				 branchObj.setTotalAmount(val.intValue());
			  }else {
				  try {
					  
					  	costByDate = new CostByDate();
						date = new SimpleDateFormat("dd-MM-yyyy").parse(headingList.get(count));
						costByDate.setDate(date);
						Double val = cellValue.getNumberValue();
						Double d = currentCell.getNumericCellValue();
						costByDate.setAmount(val.intValue());
						costByDate.setBranch(branchObj);
						costByDates.add(costByDate);
					} catch (ParseException e) {
						e.printStackTrace();
					}  
			  }
			count++;
		}
		branchObj.setCostByDate(costByDates);
		
		return branchObj;
	}

}
