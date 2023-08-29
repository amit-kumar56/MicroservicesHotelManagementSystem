package com.hotel.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,String>{

}
