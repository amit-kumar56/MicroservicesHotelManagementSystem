package com.hotel.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	
	public ResourceNotFoundException() {
		super("resourcee not found exception");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
