package com.masai;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<String> myHandler(Exception e){
		
		System.out.println(e.getMessage());
		
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
