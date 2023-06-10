package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.module.Employee;
import com.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}
	
	public Employee findByUserName(String username) {
		Employee employee = repository.findByUsername(username);
		
		return employee;
	}
}
