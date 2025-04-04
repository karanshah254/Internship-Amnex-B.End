package com.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
	@GetMapping("/")
	public String greet() {
		return "Hello from spring security app";
	}
}


//on web browser
//localhost:8080/ -> go to login where username is "user" and password is obtained at console window in IDE
//localhost:8080/logout -> ask user to logout and keeps the app secure