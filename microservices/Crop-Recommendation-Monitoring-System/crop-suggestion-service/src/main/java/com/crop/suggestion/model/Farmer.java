package com.crop.suggestion.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Farmer {
	private Long id;
	private String name;
	private String location;
	private String soilType;
	private String season;
}
