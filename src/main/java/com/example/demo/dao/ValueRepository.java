/**
 * 
 */
package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Value;

/**
 * @author arockia
 *
 */
public interface ValueRepository extends JpaRepository<Value, Integer>{

}
