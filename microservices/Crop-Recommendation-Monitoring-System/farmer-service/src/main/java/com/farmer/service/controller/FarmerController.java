package com.farmer.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmer.service.entity.Farmer;
import com.farmer.service.services.FarmerService;

@RestController
@RequestMapping("/farmer")
// @CrossOrigin(origins = "*")
public class FarmerController {
	@Autowired
	private FarmerService farmerService;
	
	@GetMapping
	public List<Farmer> getAllFarmers() {
		return farmerService.getAll();
	}
	
	@PostMapping
	public Farmer createFarmer(@RequestBody Farmer farmer) {
		return farmerService.create(farmer);
	}
	
	@GetMapping("/{id}")
	public Farmer getFarmerById(@PathVariable Long id) {
		return farmerService.getFarmerById(id);
	}
}
