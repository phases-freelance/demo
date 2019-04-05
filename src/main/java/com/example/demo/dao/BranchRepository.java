/**
 * 
 */
package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Branch;

/**
 * @author arockia
 *
 */
public interface BranchRepository extends JpaRepository<Branch, Integer>{
	
	List<Branch> findByTotalAmount(Integer amount);
	
//	@Query(value = "select * from branch where id IN(select tb1.branch_id from )", nativeQuery=true)
//	List<Branch> findByCostByDateDate(Date date);
	
	@Query(value ="select * from branch INNER JOIN tbl_branch_cost_by_date ON tbl_branch_cost_by_date.branch_id = branch.id where tbl_branch_cost_by_date.cost_by_date_id IN (select id from cost_by_date where date = ?1)", nativeQuery=true)
	List<Branch> findByCondition(Date date);
	
	@Query(value = "select id, branchName, totalAmount, value from branch", nativeQuery = true)
	List<Branch> findAllInBranch();

}
