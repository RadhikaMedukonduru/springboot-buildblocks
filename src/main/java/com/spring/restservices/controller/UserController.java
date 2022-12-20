package com.spring.restservices.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.common.net.MediaType;
import com.spring.restservices.entity.User;
import com.spring.restservices.exceptions.UserExistsException;
import com.spring.restservices.exceptions.UserNameNotFoundException;
import com.spring.restservices.exceptions.UserNotFoundException;
import com.spring.restservices.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="User Management Restful service", value="UserController", description="controller for user management service")
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers()
	{
		return userService.getAllUser();
		
	}
	
	
    @ApiOperation(value="used to create a new user")
	@PostMapping(value="/createUser")   // can use produces to display is swagger
	public ResponseEntity<Void> createUser(@ApiParam("User info for creating a new user")@Valid @RequestBody User  user,UriComponentsBuilder builder)
	{
		try {
		     userService.createUser(user);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(builder.path("/user/getUserById/{id}").buildAndExpand(user.getId()).toUri());
			return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		} catch (UserExistsException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
    @ApiOperation(value="used to reterive a user based on userId")
	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable("id") @Min(1) Long  id)
	{
		try {
			 Optional<User> userById = userService.getUserById(id);
			 User user = userById.get();
			 return user;
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
	}
	
	@PutMapping("/updateUser/{id}")
	public User createUser(@PathVariable("id") Long id,@RequestBody User  user)
	{
		try {
			return userService.updateUserById(id, user);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		}
		
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUserById(@PathVariable("id") Long  id)
	{
		 userService.deleteById(id);
		
	}
	
	
	@GetMapping("/getUserByName/{userName}")
	public User getUserByName(@PathVariable("userName") String  userName) throws UserNameNotFoundException
	{
		 User userByName = userService.getUserByName(userName);
		 
		 if(userByName == null)
		 {
			 throw new UserNameNotFoundException("User name:" + userName + " not exists");
		 }
		return userByName;
		
	}
	

}
