package com.vitu.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitu.hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
