/**
 * 
 */
package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author arockia
 *
 */
public interface InputFileProcessService {
	
	Boolean fileProcess(MultipartFile file);

}
