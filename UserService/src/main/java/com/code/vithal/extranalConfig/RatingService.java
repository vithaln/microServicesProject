package com.code.vithal.extranalConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.code.vithal.entity.Rating;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	
	/*
	 * @GetMapping("/ratings/user/{ratingId}") Rating getRatings(@PathVariable
	 * String ratingId);
	 */
	
	//create ratings
	
	@PostMapping("/ratings")
	public Rating createRatings(Rating values);
	
	//update ratings
	
	@PutMapping("/ratings/{ratingId}")
	public Rating updateRatings(@PathVariable String ratingId,Rating rating);
	
	//delete ratings
	
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRatings(String ratingId);
}
