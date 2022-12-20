package com.spring.restservices.controller;

import java.util.Optional;

import javax.validation.constraints.Min;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.spring.restservices.entity.User;
import com.spring.restservices.entity.UserDtoV1;
import com.spring.restservices.entity.UserDtoV2;
import com.spring.restservices.exceptions.UserNotFoundException;
import com.spring.restservices.services.UserService;


@RestController
@RequestMapping("/version/mime/users")
public class MediaTypeVersioningConroller {
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private ModelMapper mapper;
	
	//Media Type based Versioning - V1
		@GetMapping(value="/{id}", produces="application/vnd.versions.app-v1+json")
		public UserDtoV1 getUserById(@PathVariable("id") @Min(1) Long  id)
		{
			try {
				 Optional<User> userById = userService.getUserById(id);
				 
				 if(!userById.isPresent())
				 {
					 throw new UserNotFoundException("User not found");
				 }
				 
				 User user = userById.get();
				 
				 UserDtoV1 userDto = mapper.map(user, UserDtoV1.class);
				 
				 return userDto;
			} catch (UserNotFoundException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
			}
		}
			
			
			@GetMapping(value="/{id}",produces="application/vnd.versions.app-v2+json")
			public UserDtoV2 getUserById2(@PathVariable("id") @Min(1) Long  id)
			{
				try {
					 Optional<User> userById = userService.getUserById(id);
					 
					 if(!userById.isPresent())
					 {
						 throw new UserNotFoundException("User not found");
					 }
					 
					 User user = userById.get();
					 
					 UserDtoV2 userDto = mapper.map(user, UserDtoV2.class);
					 
					 return userDto;
				} catch (UserNotFoundException e) {
					throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
				}
		}

}
