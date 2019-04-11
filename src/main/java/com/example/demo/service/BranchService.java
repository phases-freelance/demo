/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Branch;

/**
 * @author arockia
 *
 */
public interface BranchService {
	
	List<Branch> findByTotalAmount(Integer amount);
	
//	List<Branch> findRecordBetweenDates(Date startDate, Date endDate);
	
//	List<Branch> findByDate(Date date);

}
