package com.spring.security.repository;

import org.springframework.stereotype.Repository;

import com.spring.security.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}

// bcrypt password encoder:
// plain text -> hash code
// hash code can be created using bcypt
// generally used to convert plain text password in hashcode so that misused is been stopped
// generated hash code is finger print to an object's state