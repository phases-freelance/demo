/**
 * 
 */
package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Branch;

/**
 * @author arockia
 *
 */
public interface BranchRepository extends JpaRepository<Branch, Integer>{

}
