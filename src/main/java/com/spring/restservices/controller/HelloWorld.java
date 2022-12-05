package com.spring.restservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restservices.entity.UserDetails;

@RestController
public class HelloWorld {
	
	//@RequestMapping(method=RequestMethod.GET,path="/hello")
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello World";
		
	}
	
	@GetMapping("/userDetails")
	public UserDetails userInfo()
	{
		return new UserDetails("Radhika","Medukonduru","Tiruvuru");
	}

}
