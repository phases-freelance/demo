/**
 * 
 */
package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BranchRepository;
import com.example.demo.entity.Branch;
import com.example.demo.service.BranchService;

/**
 * @author arockia
 *
 */
@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepository branchRepository;
	
	@Override
	public List<Branch> findByTotalAmount(Integer amount) {
		List<Branch> branchList = new ArrayList<>();
		if(amount != null) {
			branchList = branchRepository.findByTotalAmount(amount);
		}
		/*List<BranchDto> branchDtos = new ArrayList<>();
		BranchDto branchDto = null;
		for (Branch branch : branchList) {
			branchDto = new BranchDto();
			branchDto.setBranchName(branch.getBranchName().trim());
			branchDto.setValue(branch.getValue().getName().trim());
			for (CostByDate costByDate : branch.getCostByDate()) {
				branchDto.setDate(new SimpleDateFormat("dd-MM-yyyy").format(costByDate.getDate()));
				branchDto.setAmount(costByDate.getAmount());
				branchDtos.add(branchDto);
			}
		}*/
		return branchList;
	}

	/*@Override
	public List<Branch> findRecordBetweenDates(Date startDate, Date endDate) {
		return null;
	}*/

	/*@Transactional
	@Override
	public List<Branch> findByDate(Date date) {
		List<Branch> branchList = new ArrayList<>();
		if(date != null) {
			branchList = branchRepository.findByCondition(date);
		}
		return branchList;
	}*/

}
