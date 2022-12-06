package com.spring.restservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.restservices.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findByUserName(String userName);

}
