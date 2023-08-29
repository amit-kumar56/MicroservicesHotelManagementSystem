package com.hotel.user.service.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.user.service.entities.User;
import com.hotel.user.service.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		return new ResponseEntity<User>(userService.save(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")	
	//@CircuitBreaker(name="CircuitBreakerService",fallbackMethod="ratingHotelFallBack")
	@Retry(name="ratingHotelService", fallbackMethod="ratingHotelFallBack")
	public ResponseEntity<User> getUserById(@PathVariable String id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
	}
	
	
	public ResponseEntity<User> ratingHotelFallBack(String id,Exception ex){
		User user=new User();
		user.setAbout("sds");
		user.setEmail("x@gmail.com");
		user.setId("asdfsefewef");
		user.setName("hello");
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping
	@RateLimiter(name="rateLimiterUserService",fallbackMethod="defaultUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users=userService.getAllUsers();
		return  ResponseEntity.status(HttpStatus.OK).body(users);	
	}
	
	public ResponseEntity<List<User>> defaultUsers(){
		List<User> l=new ArrayList<>();
		User user=new User();
		user.setAbout("sds");
		user.setEmail("x@gmail.com");
		user.setId("asdfsefewef");
		user.setName("hello");
		l.add(user);
		
		return  ResponseEntity.status(HttpStatus.OK).body(l);	
	}
	
}
