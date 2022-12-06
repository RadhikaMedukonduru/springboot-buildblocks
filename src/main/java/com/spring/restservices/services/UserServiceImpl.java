package com.spring.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.restservices.entity.User;
import com.spring.restservices.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo repo;

	@Override
	public List<User> getAllUser() {
		return repo.findAll();
	}

	@Override
	public User createUser(User user) {
		return repo.save(user);
	}

	@Override
	public Optional<User> getUserById(Long id) {
		 Optional<User> userById = repo.findById(id);
		 return userById;
	}
	
	@Override
	public User updateUserById(Long id,User user) {
		user.setId(id);
		return repo.save(user);
	}


	@Override
	public void deleteById(Long id) {
		
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);;
		}
		
	}

	@Override
	public User getUserByName(String userName) {
		return repo.findByUserName(userName);
	}



}
