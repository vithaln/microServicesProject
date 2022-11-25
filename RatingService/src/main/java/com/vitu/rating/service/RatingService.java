package com.vitu.rating.service;

import java.util.List;

import com.vitu.rating.entity.Rating;

public interface RatingService {

	//create ratings
	Rating createRatings(Rating rating);
	
	//get All ratings
	List<Rating> getAllRatings();
	
	//get Rating by RtaingId
	Rating getRatingByRatingId(String ratingId);
	
	//get ratings by User
	List<Rating> getByUserId(String userId);
	
	//get ratings by hotel
	List<Rating> getByHotelId(String hotelId);
	
	
}
