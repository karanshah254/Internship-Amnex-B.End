package com.user.backend.service;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.backend.entity.User;
import com.user.backend.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public Flux<User> getAllUsers() {
		return userRepository.findAll().delayElements(Duration.ofSeconds(1));
	}

	public Mono<User> addUser(User user) {
		return userRepository.count()
				.map(Long::intValue) // Convert Long to int safely
				.flatMap(count -> {
					user.setSrNo(count + 1);
					return userRepository.save(user);
				});
	}

	public Flux<User> addUsers(Flux<User> users) {
		return userRepository.count()
				.map(Long::intValue) // Convert Long to int safely
				.flatMapMany(count -> users
						.zipWith(Flux.range(count + 1, Integer.MAX_VALUE), (user, index) -> {
							user.setSrNo(index);
							return user;
						})
						.flatMap(userRepository::save));
	}

	public Mono<User> updatedUser(int srNo, User updatedUser) {
		return userRepository.findAll()
				.filter(user -> user.getSrNo() == srNo)
				.next()
				.flatMap(existingUser -> {
					existingUser.setName(updatedUser.getName());
					existingUser.setGender(updatedUser.getGender());
					existingUser.setDob(updatedUser.getDob());
					existingUser.setPincode(updatedUser.getPincode());
					return userRepository.save(existingUser);
				});
	}

	@Transactional
	public Mono<Void> deleteUser(int srno) {
		return userRepository.findAll()
				.filter(user -> user.getSrNo() == srno)
				.next()
				.flatMap(user -> userRepository.delete(user));
	}

	public Mono<Void> resetSrNumber() {
		return userRepository.findAll()
				.index()
				.flatMap(tuple -> {
					User user = tuple.getT2();
					user.setSrNo(tuple.getT1().intValue() + 1);
					return userRepository.save(user);
				})
				.then();
	}
}
