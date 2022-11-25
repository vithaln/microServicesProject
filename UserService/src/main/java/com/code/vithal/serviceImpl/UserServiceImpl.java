package com.code.vithal.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.vithal.entity.User;
import com.code.vithal.exception.ResourcenotFoundException;
import com.code.vithal.repository.UserRepository;
import com.code.vithal.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
	
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		User savedUser = repository.save(user);
		return savedUser;
	}

	public List<User> getAllUsers() {
List<User> allUsers = repository.findAll();
		return allUsers;
	}

	public User getUserById(String userId) {
		
		User getById = repository.findById(userId).orElseThrow(()-> new ResourcenotFoundException("USER NOT FOUND BY USING THIS "+userId));
		return getById;
	}

	@Override
	public String deleteUserByid(String userId) {

repository.deleteById(userId);
		return "User has been deleted this "+userId;
	}

	@Override
	public User updateUserById(User user, String userId) {

User userid = repository.findById(userId).orElseThrow(()-> new ResourcenotFoundException("this "+userId+" is not present to update"));
//userid.setUserId(user.getUserId());
userid.setName(user.getName());
userid.setEmail(user.getEmail());
userid.setAbout(user.getAbout());
userid.setRatings(user.getRatings());

User updatedUser = repository.save(userid);
return updatedUser;
	}

}
