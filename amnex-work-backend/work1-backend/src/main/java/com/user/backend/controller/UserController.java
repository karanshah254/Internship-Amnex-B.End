package com.user.backend.controller;

import java.util.List;

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
	public List<User> getUsers() {
		return userService.getAllUsers();
	}

	// create new user
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody List<User> users) {
		if (users.size() == 1) {
			// If only one user is sent, add a single user
			User savedUser = userService.addUser(users.get(0));
			return ResponseEntity.ok(savedUser);
		} else {
			// If multiple users are sent, add them all
			List<User> savedUsers = userService.addUsers(users);
			return ResponseEntity.ok(savedUsers);
		}
	}

	@PutMapping("{srNo}")
	public ResponseEntity<User> updateUser(@PathVariable int srNo, @RequestBody User updatedUser) {
		User user = userService.updatedUser(srNo, updatedUser);
		return (user != null) ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("{srNo}")
	public void deleteUser(@PathVariable int srNo) {
		userService.deleteUser(srNo);
	}

	@GetMapping("/{srNo}")
	public ResponseEntity<User> getUserBySrNo(@PathVariable int srNo) {
		return userRepository.findAll().stream()
				.filter(user -> user.getSrNo() == srNo)
				.findFirst()
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}
