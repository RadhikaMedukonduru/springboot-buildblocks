package com.spring.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spring.restservices.entity.User;
import com.spring.restservices.exceptions.UserExistsException;
import com.spring.restservices.exceptions.UserNotFoundException;
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
	public User createUser(User user) throws UserExistsException {
		
		User userByName = repo.findByUserName(user.getUserName());
		if(userByName != null)
		{
			throw new UserExistsException("User already exists with name:"+user.getUserName()+" Please provid anothe name");
		}
		return repo.save(user);
	}

	@Override
	public Optional<User> getUserById(Long id) throws UserNotFoundException  {
		 Optional<User> userById = repo.findById(id);
		if(!userById.isPresent())
		{
			throw new UserNotFoundException("User with id:"+id+" is not present in data base");
		}
	
		 return userById;
	}
	
	@Override
	public User updateUserById(Long id,User user) throws UserNotFoundException {
		
		 Optional<User> userById = repo.findById(id);
			if(!userById.isPresent())
			{
				throw new UserNotFoundException("User with id:"+id+" is not present in data base to update, please provide valid id");
			}
		user.setId(id);
		return repo.save(user);
	}


	@Override
	public void deleteById(Long id) {
		 Optional<User> userById = repo.findById(id);
			if(!userById.isPresent())
			{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User with id:"+id+" is not present in data base to delete");
			}
		
			repo.deleteById(id);;
		
	}

	@Override
	public User getUserByName(String userName) {
		return repo.findByUserName(userName);
	}



}
