/**
 * 
 */
package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.entity.CostByDate;

/**
 * @author arockia
 *
 */
public interface CostByDateService {
	
	List<CostByDate> findByDate(Date date);
	
	List<CostByDate> findBetweenDates(Date fromDate, Date toDate);

}
