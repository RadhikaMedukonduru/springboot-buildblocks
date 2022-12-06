package com.spring.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.restservices.entity.User;
import com.spring.restservices.exceptions.UserExistsException;
import com.spring.restservices.exceptions.UserNotFoundException;

@Service
public interface UserService {
	
	
	 List<User> getAllUser();
	
     User createUser(User user) throws UserExistsException;
	
	 Optional<User> getUserById(Long id) throws UserNotFoundException;
	 
	 User updateUserById(Long id,User user) throws UserNotFoundException;
	
	 void deleteById(Long id);
	
	 User getUserByName(String userName);

}
