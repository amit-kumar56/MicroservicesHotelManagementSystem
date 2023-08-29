package com.hotel.user.service.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.hotel.user.service.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User,String>{

	//User findById(String id);
}
