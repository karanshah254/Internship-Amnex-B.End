package com.crop.monitoring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crop.monitoring.entity.CropMonitor;

@Repository
public interface CropMonitorRepository extends JpaRepository<CropMonitor, Long> {
	List<CropMonitor> findByFarmerId(Long farmerId);
    List<CropMonitor> findByCropNameIgnoreCase(String cropName);
}
