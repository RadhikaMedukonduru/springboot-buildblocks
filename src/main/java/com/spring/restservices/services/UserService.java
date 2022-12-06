package com.spring.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.restservices.entity.User;

@Service
public interface UserService {
	
	
	 List<User> getAllUser();
	
     User createUser(User user);
	
	 Optional<User> getUserById(Long id);
	 
	 User updateUserById(Long id,User user);
	
	 void deleteById(Long id);
	
	 User getUserByName(String userName);

}
