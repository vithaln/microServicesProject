package com.vitu.hotel.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleResourceNotFoundException(ResourceNotFoundException ex){
		
		Map<String,Object> map=new HashMap<>();
		String message = ex.getMessage();
		map.put("message", message);
		map.put("success", false);
		map.put("status", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
		
	}
}
