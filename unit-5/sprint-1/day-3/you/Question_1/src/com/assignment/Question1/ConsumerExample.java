package com.assignment.Question1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class ConsumerExample {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("Ankit", 1, "Delhi"));
		list.add(new Student("Rahul", 2, "Mumbai"));
		list.add(new Student("Ajay", 3, "Punjab"));
		list.add(new Student("Harsh", 4, "Delhi"));
		list.add(new Student("Ravi", 5, "Delhi"));
		
		Consumer<Student> getDetails = s -> {
			System.out.println("Name : " + s.getName() + ", Roll No. = " + s.getRoll() + ", Address = " + s.getAddress());
		};
		
		for(Student s : list) {
			getDetails.accept(s);
		}
	}

}
