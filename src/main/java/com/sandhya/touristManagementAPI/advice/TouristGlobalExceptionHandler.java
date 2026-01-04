package com.sandhya.touristManagementAPI.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sandhya.touristManagementAPI.Exception.TouristNotFoundException;

@RestControllerAdvice
public class TouristGlobalExceptionHandler {
	
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetail> handleTouristException(TouristNotFoundException t){
		ErrorDetail error = new ErrorDetail(HttpStatus.NOT_FOUND.value(),t.getMessage(),LocalDateTime.now().toString());
		return new ResponseEntity<ErrorDetail>(error,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> handleException(Exception e){
		ErrorDetail error = new ErrorDetail(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(),LocalDateTime.now().toString());
		return new ResponseEntity<ErrorDetail>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
