package com.vitu.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitu.rating.entity.Rating;
import com.vitu.rating.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingControler {

	@Autowired
	private RatingService ratingService;
	
	//create ratings..
	@PostMapping
	public ResponseEntity<Rating> createRatings(@RequestBody Rating rating){
		Rating createRatings = ratingService.createRatings(rating);
		
	return new ResponseEntity<Rating>(createRatings,HttpStatus.CREATED);
	}
	
	//get all ratings
	@GetMapping
	public ResponseEntity<List<Rating>> gateRatings( ){
 List<Rating> allRatings = ratingService.getAllRatings();
		
	return new ResponseEntity<List<Rating>>(allRatings,HttpStatus.OK);
	}
	
//get ratings by rating Id
	@GetMapping("rate/{ratingId}")
	public ResponseEntity<Rating> gateRatings(@PathVariable String ratingId){
Rating ratingByRatingId = ratingService.getRatingByRatingId(ratingId);
		
	return new ResponseEntity<Rating>(ratingByRatingId,HttpStatus.OK);
	}
	
	//get ratings by UserID	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
		List<Rating> byUserId = ratingService.getByUserId(userId);
		return new ResponseEntity<List<Rating>>(byUserId,HttpStatus.OK);
	}
	
	//get ratings by hotel Id	
		@GetMapping("/hotel/{hotelId}")
		public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
			List<Rating> byHotelId = ratingService.getByHotelId(hotelId);
			return new ResponseEntity<List<Rating>>(byHotelId,HttpStatus.OK);
		}
}
