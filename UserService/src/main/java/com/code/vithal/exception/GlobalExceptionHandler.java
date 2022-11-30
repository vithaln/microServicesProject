package com.code.vithal.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourcenotFoundException.class)
	public ResponseEntity<Map<String,Object>> handlerResourceNotFoundException(ResourcenotFoundException ex){
		
		Map<String,Object> map=new HashMap<>();
		String message = ex.getMessage();
		//APIResponce resonse = APIResponce.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		map.put("MEESSAGE", message);
		map.put("SUCCESS", true);
		map.put("STATUS", HttpStatus.NOT_FOUND);
		
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
	}
}
