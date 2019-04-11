/**
 * 
 */
package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.dto.BranchDto;
import com.example.demo.entity.Branch;

/**
 * @author arockia
 *
 */
public interface CostByDateService {
	
	List<BranchDto> findByDate(Date date);
	
	List<BranchDto> findBetweenDates(Date fromDate, Date toDate);

	List<Branch> findAll();
}
