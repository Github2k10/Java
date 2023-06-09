package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.module.Employee;

@RestController
public class MyController {
	@GetMapping("/hello")
	public String getHello() {
		return "Hello";
	}
	
	@GetMapping("/welcome")
	public String getWelcome() {
		return "Welcome";
	}
	
	@PostMapping("/register")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee employee2 = null;
		
		return new ResponseEntity<>(employee2, HttpStatus.ACCEPTED);
	}
}
