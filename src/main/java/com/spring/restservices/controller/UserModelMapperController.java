package com.spring.restservices.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.restservices.entity.User;
import com.spring.restservices.exceptions.UserNotFoundException;
import com.spring.restservices.model.UserMmDTO;
import com.spring.restservices.services.UserService;

import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/modelMapper/users")
public class UserModelMapperController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/getUserById/{id}")
	public UserMmDTO getUserById(@PathVariable("id") @Min(1) Long  id)
	{
		try {
			 Optional<User> userById = userService.getUserById(id);
			 
			 if(!userById.isPresent())
			 {
				 throw new UserNotFoundException("User not found");
			 }
			 
			 User user = userById.get();
			 
			 UserMmDTO userDto = mapper.map(user, UserMmDTO.class);
			 
			 return userDto;
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
	}

}
