/**
 * 
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.InputFileProcessService;

/**
 * @author arockia
 *
 */
@RestController
@RequestMapping("/api")
public class InputFileProcessController {

	@Autowired
	private InputFileProcessService inputFileProccessService;
	
	@PostMapping("/fileProcess")
	public Boolean fileProcess(MultipartFile file) {
		Boolean result = inputFileProccessService.fileProcess(file);
		return result;
	}
}
