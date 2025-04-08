package com.crop.suggestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crop.suggestion.service.CropSuggestionService;

@RestController
@RequestMapping("/crop")
public class CropSuggestionController {
	@Autowired
	private CropSuggestionService cropSuggestionService;
	
	@GetMapping("/recommend")
	public List<String> recommendCrops(@RequestParam Long farmerId) {
		return cropSuggestionService.recommendCrops(farmerId);
	}
	
}
