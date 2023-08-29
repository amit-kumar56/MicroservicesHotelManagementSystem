	package com.hotel.user.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hotel.user.service.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFounndException(ResourceNotFoundException ex){
		String msg=ex.getMessage();
		ApiResponse res=new ApiResponse(msg,true,HttpStatus.NOT_FOUND);
		return new ResponseEntity<ApiResponse>(res,HttpStatus.NOT_FOUND);
	}

	
}
