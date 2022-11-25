package com.code.vithal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		
		User saveUser = service.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
		
	}
	
	@GetMapping("{userId}")
	public ResponseEntity<User> getUserById(@PathVariable String userId){
		User userById = service.getUserById(userId);
		
		return ResponseEntity.ok(userById);
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
