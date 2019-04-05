/**
 * 
 */
package com.example.demo.dto;

import java.util.Date;

/**
 * @author arockia
 *
 */
public class BranchDto {
	
	private String branchName;
	
	private String value;
	
	private Date date;
	
	private Integer amount;

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
