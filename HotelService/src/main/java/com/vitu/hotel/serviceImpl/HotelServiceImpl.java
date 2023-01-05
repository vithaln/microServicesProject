package com.vitu.hotel.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitu.hotel.entity.Hotel;
import com.vitu.hotel.exception.ResourceNotFoundException;
import com.vitu.hotel.repository.HotelRepository;
import com.vitu.hotel.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository repo;
	
	public Hotel create(Hotel hotel) {
	
		String uuid = UUID.randomUUID().toString();
		hotel.setId(uuid);
		//System.out.println(savedHotel);
		return repo.save(hotel);
	}

	public List<Hotel> getHotels() {
	List<Hotel> allHotels = repo.findAll();
		return allHotels;
	}

	
	public Hotel getHotelById(String hotelId) {

return repo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("HOTEL NOT FOUND BY USING THIS ID "+hotelId));
		

	}

	public void deleteHotelById(String hotelId) {
		//Hotel hotels = repo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("HOTEL NOT FOUND TO DELTE BY USING THIS ID IS "+hotelId));

		Hotel hotel = repo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("HOTEL NOT FOUND TO DELTE BY USING THIS ID IS "+hotelId));
		repo.delete(hotel);

	
	}

	@Override
	public Hotel update(Hotel hotel, String hotelId) {

		Hotel hotels = repo.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("HOTEL NOT FOUND TO DELTE BY USING THIS ID IS "+hotelId));
		
		hotels.setName(hotel.getName());
		hotels.setAbout(hotel.getAbout());
		hotels.setLocation(hotel.getLocation());
		repo.save(hotels);
		return hotels;
	}

}
