package com.tiosso.rest.microservices.restfulwebservices.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tiosso.rest.microservices.restfulwebservices.services.exceptions.BadRequestException;
import com.tiosso.rest.microservices.restfulwebservices.services.exceptions.ConflictException;
import com.tiosso.rest.microservices.restfulwebservices.services.exceptions.ObjectNotFoundException;

// ControllerAdvice replica o metodo para todos os controladores rest
@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
	
	// Lidando com todos os tipos de Exceções "Exception.class
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(
				System.currentTimeMillis(), 
				status.value(), 
				"Not Found", 
				e.getMessage(), 
				request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<StandardError> badRequest(BadRequestException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(
				System.currentTimeMillis(), 
				status.value(), 
				"Bad Rquest", 
				e.getMessage(), 
				request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ConflictException.class)
	public ResponseEntity<StandardError> conflict(ConflictException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.CONFLICT;
		StandardError err = new StandardError(
				System.currentTimeMillis(), 
				status.value(), 
				"Conflict", 
				e.getMessage(), 
				request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> hadleAllExceptions(Exception e, HttpServletRequest request){
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError err = new StandardError(
				System.currentTimeMillis(), 
				status.value(), 
				"Internal Server Error", 
				e.getMessage(), 
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
