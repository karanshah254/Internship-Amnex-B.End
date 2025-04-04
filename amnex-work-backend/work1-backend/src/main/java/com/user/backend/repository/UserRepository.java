package com.user.backend.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.user.backend.entity.User;

import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {
	void deleteBySrNo(int srNo); // custom method
	
	Flux<User> findAllByOrderBySrNoAsc();
}
