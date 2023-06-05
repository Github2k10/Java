package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.module.User;
import com.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/get")
	public List<User> getAllUser(){
		return userService.getAllUsers();
	}
	
//	@GetMapping("/{username}")
//	public User getUser(@PathVariable String username) {
//		return userService.getUser(username);
//	}
	
//	@PostMapping("/add")
//	public ResponseEntity<String> addUser(@RequestBody User user){
//		userService.addUser(user);
//		
//		return new ResponseEntity<>("User added", HttpStatus.OK);
//	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
}
