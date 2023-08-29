package com.hotel.services;

import java.util.List;

import com.hotel.entities.Hotel;

public interface HotelService {

	Hotel createHotel(Hotel hotel);
	
	Hotel getHotel(String hotelId);
	
	List<Hotel>getAllHotel();
}
