package com.code.vithal.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.code.vithal.entity.Rating;
import com.code.vithal.entity.User;
import com.code.vithal.exception.ResourcenotFoundException;
import com.code.vithal.repository.UserRepository;
import com.code.vithal.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	String BASIC_URL = "http://localhost:8083/ratings/user/";

	@Autowired
	private RestTemplate restTemplate;

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

		User user = repository.findById(userId)
				.orElseThrow(() -> new ResourcenotFoundException("USER NOT FOUND BY USING THIS " + userId));

		// let's call the Rating service By using RestTemplate

		log.info("USER-->> {}", user.toString());

		// ArrayList<Rating> ratingsOfUsers =
		// restTemplate.getForObject("http://localhost:8083/ratings/user/bb0e7bd3-3072-44f9-9111-306036bd1147",
		// ArrayList.class);
		ArrayList<Rating> ratingsOfUsers = restTemplate.getForObject(BASIC_URL + user.getUserId(), ArrayList.class);

		log.info("USER-->> {}", ratingsOfUsers);
		user.setRatings(ratingsOfUsers);

		return user;
	}

	@Override
	public String deleteUserByid(String userId) {

		repository.deleteById(userId);
		return "User has been deleted this " + userId;
	}

	@Override
	public User updateUserById(User user, String userId) {

		User userid = repository.findById(userId)
				.orElseThrow(() -> new ResourcenotFoundException("this " + userId + " is not present to update"));
//userid.setUserId(user.getUserId());
		userid.setName(user.getName());
		userid.setEmail(user.getEmail());
		userid.setAbout(user.getAbout());
		userid.setRatings(user.getRatings());

		User updatedUser = repository.save(userid);
		return updatedUser;
	}

}
