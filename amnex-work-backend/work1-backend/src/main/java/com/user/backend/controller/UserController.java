package com.user.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.backend.entity.User;
import com.user.backend.repository.UserRepository;
import com.user.backend.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")	
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	// get list of all users
	@GetMapping
	public Flux<User> getUsers() {
		return userService.getAllUsers();
	}

	// create new user
	@PostMapping
	public Flux<User> createUser(@RequestBody Flux<User> users) {
		return userService.addUsers(users);
	}

	@PutMapping("{srNo}")
	public Mono<ResponseEntity<User>> updateUser(@PathVariable int srNo, @RequestBody User updatedUser) {
		return userService.updatedUser(srNo, updatedUser)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@DeleteMapping("{srNo}")
	public Mono<Void> deleteUser(@PathVariable int srNo) {
		return userService.deleteUser(srNo);
	}

	@GetMapping("/{srNo}")
	public Mono<ResponseEntity<User>> getUserBySrNo(@PathVariable int srNo) {
		return userRepository.findAll()
                .filter(user -> user.getSrNo() == srNo)
                .next()
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
	}
}
