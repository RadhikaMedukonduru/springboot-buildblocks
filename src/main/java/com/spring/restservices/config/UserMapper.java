package com.spring.restservices.config;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.spring.restservices.entity.User;
import com.spring.restservices.entity.UserMsDTO;

@Mapper(componentModel="Spring")
public interface UserMapper {
	
	UserMapper instance = Mappers.getMapper(UserMapper.class);
	
	//user to UserMsDTO
	@Mapping(source="email", target="emailAddress")
	UserMsDTO userMsDTO(User user);
	
	// List<User> to List<UserMsDTO>
	List<UserMsDTO> listUserMsDto(List<User> user);
}
