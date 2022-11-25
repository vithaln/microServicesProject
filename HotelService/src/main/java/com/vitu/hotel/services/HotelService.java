package com.vitu.hotel.services;

import java.util.List;

import com.vitu.hotel.entity.Hotel;

public interface HotelService {

	Hotel create(Hotel hotel);
	List<Hotel> getHotels();
	Hotel getHotelById(String hotelId);
	void deleteHotelById(String hotelId);
	
	Hotel update(Hotel hotel,String hotelId);
}
