package com.rating.services;

import java.util.List;

import com.rating.entities.Ratings;

public interface RatingService {

	Ratings createRating(Ratings rating);
	
	//get all rating given by specific user
	List<Ratings> getRatingByUserId(String userId);
	List<Ratings> getRatingsByHotelId(String hotelId);
	
	List<Ratings> getAllRatings();
}
