/**
 * 
 */
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BranchDto;
import com.example.demo.service.BranchService;

/**
 * @author arockia
 *
 */
@RestController
@RequestMapping("/api")
public class BranchController {

	@Autowired
	private BranchService branchService;

	@GetMapping(value = "/findByTotalAmount/{amount}")
	public List<BranchDto> findByTotalAmount(@PathVariable("amount") Integer amount) {
		List<BranchDto> branchDtos = branchService.findByTotalAmount(amount);
		return branchDtos;
	}

//	@PostMapping(value = "/findByDate")
//	public List<Branch> findByTotalDate(@RequestParam("date") Date date){
//		List<Branch> branchList = branchService.findByDate(date);
//		return branchList;
//	}

	/*@PostMapping(value = "/findByDate")
	public List<Branch> findByTotalDate(@RequestParam("date") String date) {
		Date date1;
		List<Branch> branchList = new ArrayList<>();
		try {
			date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			branchList = branchService.findByDate(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return branchList;
	}*/

}
