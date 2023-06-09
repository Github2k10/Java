package com.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.config.MySecurityUser;
import com.module.Employee;
import com.repository.EmployeeRepository;

public class MyUserDetailsServie implements UserDetailsService{
	
	private EmployeeRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = repository.findByUsername(username);
		
		if(employee != null) return new MySecurityUser(employee);
		else throw new UsernameNotFoundException("Employee Not found");
	}

}
