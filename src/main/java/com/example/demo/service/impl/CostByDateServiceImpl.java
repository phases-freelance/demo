/**
 * 
 */
package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CostByDateRepository;
import com.example.demo.entity.CostByDate;
import com.example.demo.service.CostByDateService;

/**
 * @author arockia
 *
 */
@Service
public class CostByDateServiceImpl implements CostByDateService{

	@Autowired
	private CostByDateRepository costByDateRepository;
	
	@Override
	public List<CostByDate> findByDate(Date date) {
		List<CostByDate> costByDateList = costByDateRepository.findByDate(date);
		return costByDateList;
	}

	@Override
	public List<CostByDate> findBetweenDates(Date fromDate, Date toDate) {
		List<CostByDate> costByDateList = costByDateRepository.findBetweenTwoDates(fromDate, toDate);
		return costByDateList;
	}

}
