package com.assignment.Question1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

class Student{
	private String name;
	private int roll;
	private String address;
	public Student(String name, int roll, String address) {
		super();
		this.name = name;
		this.roll = roll;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}

public class SupplierExample {

	public static void main(String[] args) {
		int i = 0;
		
		List<Student> list = new ArrayList<>();
		list.add(new Student("Ankit", 1, "Delhi"));
		list.add(new Student("Rahul", 2, "Mumbai"));
		list.add(new Student("Ajay", 3, "Punjab"));
		list.add(new Student("Harsh", 4, "Delhi"));
		list.add(new Student("Ravi", 5, "Delhi"));
		
		Supplier<Student> getName = () -> list.get(i);
		
			System.out.println(getName.get().getName());
	}

}
