package com.crop.suggestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CropSuggestionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CropSuggestionServiceApplication.class, args);
	}

}
