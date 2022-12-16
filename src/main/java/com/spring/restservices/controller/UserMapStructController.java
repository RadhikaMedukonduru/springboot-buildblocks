package com.spring.restservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restservices.config.UserMapper;
import com.spring.restservices.entity.UserMsDTO;
import com.spring.restservices.repository.UserRepo;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {
	
	@Autowired
	private UserRepo userRepo;
	
    @Autowired
	private UserMapper mapStruct;
	
    @GetMapping("/allUsers")
	public List<UserMsDTO> getAllUsers()
	{
		return mapStruct.listUserMsDto(userRepo.findAll());
	}
}
