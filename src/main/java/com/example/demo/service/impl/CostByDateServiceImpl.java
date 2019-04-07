/**
 * 
 */
package com.example.demo.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CostByDateRepository;
import com.example.demo.dto.BranchDto;
import com.example.demo.entity.CostByDate;
import com.example.demo.service.CostByDateService;

/**
 * @author arockia
 *
 */
@Service
public class CostByDateServiceImpl implements CostByDateService {

	@Autowired
	private CostByDateRepository costByDateRepository;

	@Override
	public List<BranchDto> findByDate(Date date) {
		List<CostByDate> costByDateList = costByDateRepository.findByDate(date);
		List<BranchDto> branchDtos = convertToBranchDtos(costByDateList);
		return branchDtos;
	}

	@Override
	public List<BranchDto> findBetweenDates(Date fromDate, Date toDate) {
		List<CostByDate> costByDateList = costByDateRepository.findBetweenTwoDates(fromDate, toDate);
		List<BranchDto> branchDtos = convertToBranchDtos(costByDateList);
		return branchDtos;
	}
	
	public List<BranchDto> convertToBranchDtos(List<CostByDate> costByDateList){
		List<BranchDto> branchDtos = new ArrayList<>();
		BranchDto branchDto = null;
		for (CostByDate costByDate : costByDateList) {
			branchDto = new BranchDto();
			branchDto.setBranchName(costByDate.getBranch().getBranchName().trim());
			branchDto.setValue(costByDate.getBranch().getValue().getName().trim());
			branchDto.setDate(new SimpleDateFormat("dd-MM-yyyy").format(costByDate.getDate()));
			branchDto.setAmount(costByDate.getAmount());
			branchDtos.add(branchDto);
		}
		return branchDtos;
	}

	@Override
	public List<BranchDto> findAll() {
		List<BranchDto> branchDtoList = new ArrayList<>();
		costByDateRepository.findAll().stream().forEach(costByDate -> {
			BranchDto branchDto = new BranchDto();
			branchDto.setBranchName(costByDate.getBranch().getBranchName().trim());
			branchDto.setValue(costByDate.getBranch().getValue().getName().trim());
			branchDto.setDate(new SimpleDateFormat("dd-MM-yyyy").format(costByDate.getDate()));
			branchDto.setAmount(costByDate.getAmount());
			branchDtoList.add(branchDto);
		});
		return branchDtoList;
	}
}
