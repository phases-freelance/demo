/**
 * 
 */
package com.example.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author arockia
 *
 */
@Entity
public class Branch {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String branchName;
	
	@ManyToOne
	@JoinColumn(name = "value_id")
	private Value value;
	
	private Integer totalAmount;
	
	@JsonIgnoreProperties("branch")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "branch")
	private Set<CostByDate> costByDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Set<CostByDate> getCostByDate() {
		return costByDate;
	}

	public void setCostByDate(Set<CostByDate> costByDate) {
		this.costByDate = costByDate;
	}
	
}
