/**
 * 
 */
package com.saika.pharmacydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.saika.pharmacydemo.model.Pharmacy;

/**
 * @author vinodbottu
 *
 */
@Service
public interface PharmacyRepository extends JpaRepository<Pharmacy, String> {
public Pharmacy findOne(String id);
public Pharmacy findByName(String name);
}
