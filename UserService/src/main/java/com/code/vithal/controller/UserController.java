package com.code.vithal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.vithal.entity.User;
import com.code.vithal.services.UserService;

import ch.qos.logback.classic.Logger;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		
		User saveUser = service.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
		
	}
	
	int retryCount=1;
	@GetMapping("{userId}")
	//@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
	//@Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRating", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUserById(@PathVariable String userId){
		
		log.info("USER CONTROLLER GETUSERBYID METHOD IS CALLED..");
		log.info("RETRY COUNT IS: {} ",retryCount);
		retryCount++;
		
		User userById = service.getUserById(userId);
		
		return ResponseEntity.ok(userById);
	}
	
	//creating fallback method for circuit breaker
	
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
		
		log.info("FallBack method is excuted because of some service are down : ",ex.getMessage());
		User user = User.builder().email("dummy123@gmail.com").name("Dummy")
				.userId("123").about("this is dummy user because of some services are down so dummy user data is diplayed...").build();
		return ResponseEntity.ok(user);
	}
	@GetMapping
	public ResponseEntity<List<User>> getAllusers(){
		List<User> allUsers = service.getAllUsers();
		
		return ResponseEntity.ok(allUsers);
	}
	
	@DeleteMapping("{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable String userId){
		 String deleteUserByid = service.deleteUserByid(userId);
		
		return ResponseEntity.ok(deleteUserByid);
	}
	
	@PutMapping("{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable String userId){
		
		User updateUserById = service.updateUserById(user, userId);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateUserById);
		
	}
	
}
