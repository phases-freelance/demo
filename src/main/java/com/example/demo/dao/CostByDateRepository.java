/**
 * 
 */
package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.CostByDate;

/**
 * @author arockia
 *
 */
public interface CostByDateRepository extends JpaRepository<CostByDate, Integer>{

	
	List<CostByDate> findByDate(Date date);
	
	@Query(value = "select * from cost_by_date where date >= :fromDate AND date <= :toDate", nativeQuery = true)
	List<CostByDate> findBetweenTwoDates(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
}
