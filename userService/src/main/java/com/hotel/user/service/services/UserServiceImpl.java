package com.hotel.user.service.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotel.user.service.entities.Hotel;
import com.hotel.user.service.entities.Ratings;
import com.hotel.user.service.entities.User;
import com.hotel.user.service.feignclient.HotelService;
import com.hotel.user.service.repositories.UserRepository;


@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	@Override
	public User save(User user) {
		String id=UUID.randomUUID().toString();
		user.setId(id);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override	
	public User getUser(String id) {
		 User user=userRepository.getById(id);
		 
		 //using restTemplate..............
		 //String url="http://localhost:8083/rating/user/"+id;
		 String url="http://RATING-SERVICE/rating/user/"+id;
		 ArrayList<Ratings> r=restTemplate.getForObject(url, ArrayList.class);
		 
		 //using Fiegn client
		 Hotel hotel= hotelService.getHotel("ee122732-5e64-4540-8032-26a5d4391d48");
		 
		//List<Ratings>obj=Arrays.stream(hotel).toList();
		System.out.println(hotel);
		 /*
		 //List<Ratings> obj1= Arrays.asList(obj);
		 List<Ratings> newRate=obj.stream().map(rating->{
			 ArrayList<Hotel> hotel = restTemplate.getForObject(hotelUrl+rating.getHotelId(), ArrayList.class);
			 Hotel htl=hotel.get(0);
			 rating.setHotel(htl);
			// newRate.add(rating);
			 System.out.print(rating);
			 return rating;
		 }).collect(Collectors.toList());
		/* for(Ratings rate:object)
		 {
			 //Ratings rate=obj.get(i);
			 System.out.println("....................................................."+rate);
			 ArrayList<Hotel> hotel = restTemplate.getForObject(hotelUrl+rate.getHotelId(), ArrayList.class);
			 Hotel htl=hotel.get(0);
			 rate.setHotel(htl);
			 newRate.add(rate);
		 }*/
		user.setRatings(r);
		return user;
		//return userRepository.findById(id);//orElseThrow(()->	new ResourceNotFound("user not found of this id in this server"));
	}

}
