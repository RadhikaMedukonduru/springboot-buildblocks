package com.spring.restservices.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.spring.restservices.entity.User;
import com.spring.restservices.exceptions.UserNotFoundException;
import com.spring.restservices.services.UserService;

@RestController
@RequestMapping(value ="/jacksonfilter/users")
@Validated
public class UserMappingJacksonController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUserById/{id}")
	public MappingJacksonValue getUserById(@PathVariable("id") @Min(1) Long  id)
	{
		try {
			 Optional<User> userById = userService.getUserById(id);
			 User user =userById.get();
			 
			 Set<String> fields = new HashSet<>();
			 fields.add("firstName");
			 fields.add("lastName");
			 
			 
			 FilterProvider filterProvider = new SimpleFilterProvider()     //provides only firstName and lastName
			                .addFilter("userFilter",SimpleBeanPropertyFilter.filterOutAllExcept(fields));
			 
			 MappingJacksonValue mapper = new MappingJacksonValue(user);
			 mapper.setFilters(filterProvider);
			 
			 return mapper;
			 
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
	}
		//Dynamic filter with RequestParam
		
		@GetMapping("params/{id}")
		public MappingJacksonValue getUserByIdDynamic(@PathVariable("id") @Min(1) Long  id,@RequestParam Set<String> fields)
		{
			try {
				 Optional<User> userById = userService.getUserById(id);
				 User user =userById.get();
				 
				 FilterProvider filterProvider = new SimpleFilterProvider()     //provides only firstName and lastName
				                .addFilter("userFilter",SimpleBeanPropertyFilter.filterOutAllExcept(fields));
				 
				 MappingJacksonValue mapper = new MappingJacksonValue(user);
				 mapper.setFilters(filterProvider);
				 
				 return mapper;
				 
			} catch (UserNotFoundException e) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
			}
			
		
	}

}
