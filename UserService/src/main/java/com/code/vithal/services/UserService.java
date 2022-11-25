package com.code.vithal.services;

import java.util.List;

import com.code.vithal.entity.User;

public interface UserService {
	
	User saveUser(User user);
	
	List<User> getAllUsers();
	
	User getUserById(String userId);
	
	String deleteUserByid(String userId);
	
	User updateUserById(User user, String userId);

}
