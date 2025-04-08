package com.crop.monitoring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crop.monitoring.entity.CropMonitor;
import com.crop.monitoring.repository.CropMonitorRepository;

@Service
public class CropMonitorService {
	@Autowired
	private CropMonitorRepository cropMonitorRepository;
	
	public CropMonitor save(CropMonitor monitor) {
        return cropMonitorRepository.save(monitor);
    }

    public List<CropMonitor> getAll() {
        return cropMonitorRepository.findAll();
    }

    public List<CropMonitor> getByFarmerId(Long farmerId) {
        return cropMonitorRepository.findByFarmerId(farmerId);
    }

    public List<CropMonitor> getByCropName(String cropName) {
        return cropMonitorRepository.findByCropNameIgnoreCase(cropName);
    }
}
