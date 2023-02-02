package com.Question2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.Question1.Product;

public class Student {
	private String name;
	private int roll;
	private int marks;
	private String address;
	
	public Student(String name, int roll, int marks, String address) {
		super();
		this.name = name;
		this.roll = roll;
		this.marks = marks;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student name = " + name + ", roll = " + roll + ", marks = " + marks + ", address = " + address;
	}
	
	
}


class Employee{
	private String name;
	private int empId;
	private int salary;
	private String address;
	
	public Employee() {}
	
	public Employee(String name, int empId, int salary, String address) {
		super();
		this.name = name;
		this.empId = empId;
		this.salary = salary;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = (int) salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee name = " + name + ", empId = " + empId + ", salary = " + salary + ", address = " + address;
	}
	
	
}



class Main{
	public static void main(String args[]) {
		List<Student> list1 = new ArrayList<>();
		
		list1.add(new Student("Alpha", 1, 600, "Delhi"));
		list1.add(new Student("Beta", 2, 400, "Mumbai"));
		list1.add(new Student("Charli", 3, 700, "Kolkata"));
		list1.add(new Student("Brovo", 4, 400, "Maharasta"));
		list1.add(new Student("Tom", 5, 500, "Banglore"));
		list1.add(new Student("Berlin", 6, 800, "Chennai"));
		
		Consumer<Product>  c = n -> System.out.println(n.toString());
		Stream<Student> l1 = list1.stream();
		
		List<Object> list2 = l1.map(s -> {
			if(s.getMarks() > 500) {
				 return new Employee(s.getName(), s.getRoll(), s.getMarks()*10000, s.getAddress());
			}
			return "";
		}).collect(Collectors.toList());
		
		Collections.sort(list2, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return (int) (o1.getSalary() - o2.getSalary());
			}
			
		});
		
		
		list2.stream().forEach(s -> System.out.println(s.toString()));
	}
}












