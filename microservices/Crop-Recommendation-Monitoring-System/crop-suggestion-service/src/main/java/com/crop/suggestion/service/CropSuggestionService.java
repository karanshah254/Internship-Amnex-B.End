package com.crop.suggestion.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crop.suggestion.model.Farmer;

@Service
public class CropSuggestionService {
	private final RestTemplate restTemplate = new RestTemplate();
	
	public List<String> recommendCrops(Long farmerId) {
        // Call Farmer Service
        String farmerServiceUrl = "http://localhost:8081/farmer/" + farmerId;
        Farmer farmer = restTemplate.getForObject(farmerServiceUrl, Farmer.class);

        if (farmer == null) {
            return Collections.singletonList("No data found for the given farmer");
        }

        String soil = farmer.getSoilType().toLowerCase();
        String season = farmer.getSeason().toLowerCase();

        // Recommendation Logic
        if (soil.contains("black") && season.equals("kharif")) {
            return Arrays.asList("Cotton", "Soybean", "Sorghum");
        } else if (soil.contains("loamy") && season.equals("rabi")) {
            return Arrays.asList("Wheat", "Mustard", "Barley");
        } else if (soil.contains("red") && season.equals("summer")) {
            return Arrays.asList("Millet", "Sunflower");
        } else {
            return Arrays.asList("Maize", "Pulses");
        }
    }
}
