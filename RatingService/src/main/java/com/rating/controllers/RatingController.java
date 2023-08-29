package com.rating.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.entities.Ratings;
import com.rating.services.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	private ResponseEntity<Ratings> createRatings(@RequestBody Ratings ratings)
	{
		return ResponseEntity.ok(ratingService.createRating(ratings));
	}
	
	@GetMapping("/user/{userId}")
	private ResponseEntity<List<Ratings>> getRaitingsByUserId(@PathVariable String userId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
	}
	
	@GetMapping("/hotel/{hotelId}")
	private ResponseEntity<List<Ratings>> getRaitingsByHotelId(@PathVariable String hotelId)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingsByHotelId(hotelId));
	}
	@GetMapping
	private ResponseEntity<List<Ratings>> getAllRaitings()
	{
		return ResponseEntity.status(HttpStatus.OK).body(ratingService.getAllRatings());
	}
}
