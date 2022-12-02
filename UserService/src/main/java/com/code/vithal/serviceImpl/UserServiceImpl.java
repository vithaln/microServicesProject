package com.code.vithal.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.code.vithal.entity.Hotel;
import com.code.vithal.entity.Rating;
import com.code.vithal.entity.User;
import com.code.vithal.exception.ResourcenotFoundException;
import com.code.vithal.repository.UserRepository;
import com.code.vithal.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	String BASIC_URL = "http://RATING-SERVICE/ratings/user/";
	String HOTELBASIC_URL = "http://HOTEL-SERVICE/hotels/";
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
		Rating[] rating = restTemplate.getForObject(BASIC_URL + user.getUserId(), Rating[].class);

		List<Rating> ratingss = Arrays.stream(rating).toList();
		log.info("USER-->> {}", ratingss);

		// set the hotel to Rating service and return Rating..
		List<Rating> ratingList = ratingss.stream().map(ratingg -> {
			// api to call get hotel from Hotel Service
			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity(HOTELBASIC_URL + ratingg.getHotelId(),
					Hotel.class);

			log.info("Response Status {} ", forEntity.getStatusCode());
			Hotel hotel = forEntity.getBody();

			ratingg.setHotel(hotel);

			return ratingg;
		}).collect(Collectors.toList());

		user.setRatings(ratingList);
log.info("final List--> {}",ratingList);
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
