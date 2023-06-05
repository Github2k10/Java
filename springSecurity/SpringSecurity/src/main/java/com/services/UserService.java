package com.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.module.User;

@Service
public class UserService {
	private List<User> users = new ArrayList<>();
	
	public UserService() {
		users.add(new User(1, "Alpha", "Alpha123@gmail.com", "alpha123"));
		users.add(new User(2, "Berline", "berline123@gmail.com", "berline123"));
	}
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public List<User> getAllUsers(){
		return users;
	}
	
	public User getUser(String username) {
		return users.stream().filter(u -> u.getUsername().equals(username)).findAny().orElse(null);
	}
	
	
}
