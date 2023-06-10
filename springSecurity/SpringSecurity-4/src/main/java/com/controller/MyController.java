package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.module.Employee;
import com.service.EmployeeService;

@RestController
public class MyController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/hello")
	public String getHello() {
		return "Hello";
	}
	
	@GetMapping("/welcome")
	public String getWelcome() {
		return "Welcome";
	}
	
	@GetMapping("/welcome/{username}")
	public Employee getWelcome(@PathVariable String username) {
		return employeeService.findByUserName(username);
	}
	
	@PostMapping("/register")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		Employee employee2 = employeeService.saveEmployee(employee);
		
		return new ResponseEntity<>(employee2, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/admin")
	public String getAdmin() {
		return "Admin";
	}
}
