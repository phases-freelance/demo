/**
 * 
 */
package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dao.ValueRepository;
import com.example.demo.entity.Value;


/**
 * @author arockia
 *
 */
@Configuration
public class InitialSetup {

	@Autowired
	private ValueRepository valueRepository;
	
	@Bean
	public void initialRecords() {
		Long count = valueRepository.count();
		if(count == 0) {
			List<Value> valueList = new ArrayList<>();
			valueList.add(new Value("1. Sales Value"));
			valueList.add(new Value("2. CRNT Value"));
			valueList.add(new Value("3. No. of Bills"));
			valueList.add(new Value("4. Avg. Bill Value"));
			valueRepository.saveAll(valueList);
		}
	}
}
