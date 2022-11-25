package com.vitu.rating.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitu.rating.entity.Rating;
import com.vitu.rating.exception.ResourceNotFoundException;
import com.vitu.rating.repository.RatingRepo;
import com.vitu.rating.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepo ratingRepo;
	
	
	public Rating createRatings(Rating rating) {
		
		return ratingRepo.save(rating);
	}

	public List<Rating> getAllRatings() {
	
		return ratingRepo.findAll();
	}

	public Rating getRatingByRatingId(String ratingId) {
		
		 Rating rating = ratingRepo.findById(ratingId).orElseThrow(()-> new ResourceNotFoundException("RATING NOT FOUND"));

		 return rating;
	}

	public List<Rating> getByUserId(String userId) {
	List<Rating> ratings = ratingRepo.findByUserId(userId);
		return ratings;
	}

	public List<Rating> getByHotelId(String hotelId) {
		List<Rating> ratingsByHotel = ratingRepo.findByHotelId(hotelId);
		return ratingsByHotel;
	}

}
