package com.code.vithal.extranalConfig;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.code.vithal.entity.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

	@GetMapping(value = "/hotels/{hotelId}")
	Hotel getHotels(@PathVariable String hotelId);
}
