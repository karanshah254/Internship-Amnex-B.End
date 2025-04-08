package com.farmer.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmer.service.entity.Farmer;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {
	
}
