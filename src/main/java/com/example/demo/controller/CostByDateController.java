/**
 * 
 */
package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CostByDate;
import com.example.demo.service.CostByDateService;

/**
 * @author arockia
 *
 */
@RestController
@RequestMapping("/api")
public class CostByDateController {
	
	@Autowired
	private CostByDateService costByDateService;
	
	@GetMapping(value = "/findByDate/{date}")
	public List<CostByDate> findByDate(@PathVariable("date") String date) {
		Date date1;
		List<CostByDate> costByDateList = new ArrayList<>();
		try {
			date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			costByDateList = costByDateService.findByDate(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return costByDateList;
	}
	
	@GetMapping(value = "/findBetweenDates/{fromDate}/{toDate}")
	public List<CostByDate> findBetweenDates(@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate) {
		Date fdate;
		Date tdate;
		List<CostByDate> costByDateList = new ArrayList<>();
		try {
			fdate = new SimpleDateFormat("dd-MM-yyyy").parse(fromDate);
			tdate = new SimpleDateFormat("dd-MM-yyyy").parse(toDate);
			costByDateList = costByDateService.findBetweenDates(fdate, tdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return costByDateList;
	}
	
	

}
