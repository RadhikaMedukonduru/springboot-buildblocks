package com.spring.restservices.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.restservices.entity.CustomErrorDetails;

import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
		CustomErrorDetails errorDetails = new CustomErrorDetails(new Date(), "Please enter Valid details", ex.getMessage());

		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		CustomErrorDetails errorDetails = new CustomErrorDetails(new Date(), "Please select correct Request Type", ex.getMessage());

		return new ResponseEntity<>(errorDetails,HttpStatus.METHOD_NOT_ALLOWED);
	
	}

	
	@ExceptionHandler(UserNameNotFoundException.class)
	public final ResponseEntity<Object> handleUserNameNotFoundException(UserNameNotFoundException ex,WebRequest request)
	{
		CustomErrorDetails errorDetails = new CustomErrorDetails(new Date(), ex.getMessage(),request.getDescription(false));

		return new ResponseEntity<Object>(errorDetails,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintVoilation(ConstraintViolationException ex,WebRequest request)
	{
		CustomErrorDetails errorDetails = new CustomErrorDetails(new Date(), ex.getMessage(),request.getDescription(false));

		return new ResponseEntity<Object>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}

}
