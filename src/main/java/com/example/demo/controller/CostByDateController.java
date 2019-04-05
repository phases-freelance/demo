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

import com.example.demo.dto.BranchDto;
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
	public List<BranchDto> findByDate(@PathVariable("date") String date) {
		Date date1;
		List<BranchDto> branchDtos = new ArrayList<>();
		try {
			date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			branchDtos = costByDateService.findByDate(date1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return branchDtos;
	}
	
	@GetMapping(value = "/findBetweenDates/{fromDate}/{toDate}")
	public List<BranchDto> findBetweenDates(@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate) {
		Date fdate;
		Date tdate;
		List<BranchDto> branchDtos = new ArrayList<>();
		try {
			fdate = new SimpleDateFormat("dd-MM-yyyy").parse(fromDate);
			tdate = new SimpleDateFormat("dd-MM-yyyy").parse(toDate);
			branchDtos = costByDateService.findBetweenDates(fdate, tdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return branchDtos;
	}
	
	

}
