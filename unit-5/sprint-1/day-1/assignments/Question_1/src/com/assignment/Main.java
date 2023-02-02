package com.assignment;

import java.util.ArrayList;

@FunctionalInterface
interface Grace{
	void grace(Employee emp);
}

class Employee{
	int empId;
	int salary;
	String name;
	String address;
	
	public Employee(int empId, int salary, String name, String address) {
		this.name = name;
		this.empId = empId;
		this.salary = salary;
		this.address = address;
	}
	
	int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "EmpId = " + empId + ", salary = " + salary + ", name = " + name + ", address = " + address;
	}
	
	
}


public class Main {

	public static void main(String args[]) {
		ArrayList<Employee> arr = new ArrayList<>();
		
		arr.add(new Employee(1, 2000, "user001", "New Delhi"));
		arr.add(new Employee(2, 5000, "user002", "New Delhi"));
		arr.add(new Employee(3, 7000, "user003", "New Delhi"));
		arr.add(new Employee(4, 4000, "user004", "New Delhi"));
		arr.add(new Employee(5, 9000, "user005", "New Delhi"));
		arr.add(new Employee(6, 10000, "user006", "New Delhi"));
		arr.add(new Employee(7, 2500, "user007", "New Delhi"));
		arr.add(new Employee(8, 2300, "user008", "New Delhi"));
		arr.add(new Employee(9, 2700, "user009", "New Delhi"));
		arr.add(new Employee(10, 8000, "user010", "New Delhi"));
		
		Grace g = (emp) -> {
			if(emp.getSalary() < 5000) {
				emp.salary += 1000;
			}
		};
		
		for(Employee emp : arr) {
			System.out.println(emp.toString());
			g.grace(emp);
		}
		
		System.out.println("\n\n");
		
		for(Employee emp : arr) {
			System.out.println(emp.toString());
		}
		
	}
}
