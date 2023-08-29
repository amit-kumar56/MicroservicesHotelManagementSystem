package com.rating.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ratings")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ratings {

	@Id
	private String ratingiId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	public Ratings(String ratingiId, String userId, String hotelId, int rating, String feedback) {
		super();
		this.ratingiId = ratingiId;
		this.userId = userId;
		this.hotelId = hotelId;
		this.rating = rating;
		this.feedback = feedback;
	}
	public Ratings() {
		super();
		//// TODO Auto-generated constructor stub
	}
	public String getRatingiId() {
		return ratingiId;
	}
	public void setRatingiId(String ratingiId) {
		this.ratingiId = ratingiId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getHotelId() {
		return hotelId;
	}
	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}
