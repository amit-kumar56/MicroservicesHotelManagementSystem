package com.rating.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rating.entities.Ratings;

@Repository
public interface RatingRepository extends JpaRepository<Ratings,String>{

	List<Ratings> findByUserId(String userId);
	List<Ratings> findByHotelId(String hotelId);
}
