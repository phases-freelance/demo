/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BranchDto;

/**
 * @author arockia
 *
 */
public interface BranchService {
	
	List<BranchDto> findByTotalAmount(Integer amount);
	
//	List<Branch> findRecordBetweenDates(Date startDate, Date endDate);
	
//	List<Branch> findByDate(Date date);

}
