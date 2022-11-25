package com.vitu.rating.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handleResourceNotFoundExcptions(ResourceNotFoundException ex){
		
		Map<String,Object> map=new HashMap<String, Object>();
		String message = ex.getMessage();
		map.put("message", message);
		map.put("Success", true);
		map.put("Status", HttpStatus.NOT_FOUND);
		map.put("Time", new Date());
		return new  ResponseEntity<Map<String,Object>>(map,HttpStatus.NOT_FOUND);
	}
}
