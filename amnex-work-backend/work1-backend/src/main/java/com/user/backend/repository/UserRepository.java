package com.user.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	void deleteBySrNo(int srNo); // custom method
}
