package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	Employee findByUsername(String username);
}
