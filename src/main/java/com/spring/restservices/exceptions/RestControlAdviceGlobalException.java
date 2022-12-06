package com.spring.restservices.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.restservices.entity.CustomErrorDetails;

//@RestControllerAdvice
public class RestControlAdviceGlobalException {
	
	
	@ExceptionHandler(UserNameNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CustomErrorDetails handleUserNameNotFoundException(UserNameNotFoundException ex)
	{
		return new CustomErrorDetails(new Date(), "User name not exists", ex.getMessage());
	}

}
