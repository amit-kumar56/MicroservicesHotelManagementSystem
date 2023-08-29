package com.hotel.user.service.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.hotel.user.service.entities.Ratings;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {
  
	//POST
	@PostMapping("/ratings")
	public Ratings saveRatings(Ratings rating);
	
	//PUT
	@PutMapping("/ratings/{ratingId}")
	public Ratings updateRating(@PathVariable("ratingId") String ratingId,Ratings rating);
	
	//DELETE
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRating(@PathVariable("ratingId") String ratingId);
}
