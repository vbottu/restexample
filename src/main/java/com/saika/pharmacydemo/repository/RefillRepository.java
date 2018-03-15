/**
 * 
 */
package com.saika.pharmacydemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.saika.pharmacydemo.model.Refill;

/**
 * @author vinodbottu
 *
 */
@Service
public interface RefillRepository extends JpaRepository<Refill, String> {
	public Refill findOne(String id);

	public List<Refill> findByUserId(String userId);
}
