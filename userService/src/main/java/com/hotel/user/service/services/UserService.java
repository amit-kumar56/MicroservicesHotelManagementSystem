package com.hotel.user.service.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotel.user.service.entities.User;

@Service
public interface UserService {

	User save(User user);
	List<User>  getAllUsers();
	
	User  getUser(String userId);
	
	
}
