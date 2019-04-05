/**
 * 
 */
package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.dto.BranchDto;

/**
 * @author arockia
 *
 */
public interface CostByDateService {
	
	List<BranchDto> findByDate(Date date);
	
	List<BranchDto> findBetweenDates(Date fromDate, Date toDate);

}
