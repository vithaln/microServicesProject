package com.code.vithal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.code.vithal.payload.APIResponce;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourcenotFoundException.class)
	public ResponseEntity<APIResponce> handlerResourceNotFoundException(ResourcenotFoundException ex){
		
		String message = ex.getMessage();
		APIResponce resonse = APIResponce.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		
		
		return new ResponseEntity<APIResponce>(resonse,HttpStatus.NOT_FOUND);
	}
}
