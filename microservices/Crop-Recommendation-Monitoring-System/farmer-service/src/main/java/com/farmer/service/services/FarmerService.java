package com.farmer.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmer.service.entity.Farmer;
import com.farmer.service.repository.FarmerRepository;

@Service
public class FarmerService {
	
	@Autowired
	private FarmerRepository farmerRepository;
	
	public Farmer create(Farmer farmer) {
		return farmerRepository.save(farmer);
	}
	
	public List<Farmer> getAll() {
		return farmerRepository.findAll();
	}
	
	public Farmer getFarmerById(Long id) {
		return farmerRepository.findById(id).orElse(null);
	}
}
