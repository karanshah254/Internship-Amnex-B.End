package com.crop.monitoring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crop.monitoring.entity.CropMonitor;
import com.crop.monitoring.service.CropMonitorService;

@RestController
@RequestMapping("/monitor")
public class CropMonitorController {
	@Autowired
	private CropMonitorService cropMonitorService;
	
	@PostMapping
    public CropMonitor addMonitoring(@RequestBody CropMonitor monitor) {
        return cropMonitorService.save(monitor);
    }

    @GetMapping
    public List<CropMonitor> getAllMonitoring() {
        return cropMonitorService.getAll();
    }

    @GetMapping("/farmer/{farmerId}")
    public List<CropMonitor> getByFarmer(@PathVariable Long farmerId) {
        return cropMonitorService.getByFarmerId(farmerId);
    }

    @GetMapping("/crop/{cropName}")
    public List<CropMonitor> getByCrop(@PathVariable String cropName) {
        return cropMonitorService.getByCropName(cropName);
    }
}
