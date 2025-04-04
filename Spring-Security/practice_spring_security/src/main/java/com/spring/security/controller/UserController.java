package com.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.model.Users;
import com.spring.security.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/register") // create a register user for authentication
	public Users register(@RequestBody Users user) {
		return service.register(user);
	}

	@PostMapping("/login") // create a login user for authentication
	public String login(@RequestBody Users user) {
		return service.verify(user);
	}
}
