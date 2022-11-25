package com.vitu.hotel.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitu.hotel.entity.Hotel;
import com.vitu.hotel.serviceImpl.HotelServiceImpl;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	
	@Autowired
	private HotelServiceImpl hotelServiceImpl;
	
	@PostMapping("/save")
	public ResponseEntity<Hotel> createHote(@RequestBody Hotel hotel){
		
		Hotel create = hotelServiceImpl.create(hotel);
		return new ResponseEntity<Hotel>(create,HttpStatus.CREATED);
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
 Hotel hotelById = hotelServiceImpl.getHotelById(hotelId);
		return new ResponseEntity<Hotel>(hotelById,HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<Hotel>> getAllHotels(){
List<Hotel> hotels = hotelServiceImpl.getHotels();
		return new ResponseEntity<List<Hotel>>(hotels,HttpStatus.OK);
	}
	
	@DeleteMapping("/{hotelId}")
	public ResponseEntity<String> deleteHotelById(@PathVariable String hotelId){
      hotelServiceImpl.deleteHotelById(hotelId);
		return new ResponseEntity<String>("Hote has been delted Vithal!!",HttpStatus.OK);
	}
	@PutMapping("/update/{hotelId}")
	public ResponseEntity<Hotel> updateHotels(@RequestBody Hotel hotel, @PathVariable String hotelId){
		Hotel updateHotel = hotelServiceImpl.update(hotel, hotelId);	
		
		return new ResponseEntity<Hotel>(updateHotel,HttpStatus.OK);
	}
}
