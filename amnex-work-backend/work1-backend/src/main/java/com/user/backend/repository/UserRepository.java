package com.user.backend.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

import com.user.backend.entity.User;

import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends R2dbcRepository<User, Long> {
	void deleteBySrNo(int srNo); // custom method
	
	Flux<User> findAllByOrderBySrNoAsc();
}
