package com.code.vithal.extranalConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.code.vithal.entity.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	
	@GetMapping("/ratings/user/{ratingId}")
	Rating getRatings(@PathVariable String ratingId);
}
