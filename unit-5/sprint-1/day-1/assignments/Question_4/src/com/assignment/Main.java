package com.assignment;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
interface MapStudents{
	public Map<String, Students> sortMapUsingStudentName(Map<String, Students> originalMap);
}


class Students{
	int roll;
	int marks;
	String name;
	String email;
	
	public Students(int roll, int marks, String name, String email) {
		this.name= name;
		this.roll = roll;
		this.marks = marks;
		this.email = email;
	}
	
	String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Name = " + name + ", Roll = " + roll + ", Marks = " + marks + ", Email = " + email;
	}
}

public class Main {
	public static void main(String args[]) {
		HashMap<String, Students> map = new HashMap<>();
		
		map.put("Maharastra", new Students(1, 68, "Pankaj", "abc@gamail.com"));
		map.put("New Delhi", new Students(2, 78, "Rajesh", "abc@gamail.com"));
		map.put("Bangalore", new Students(3, 75, "Rohan", "abc@gamail.com"));
		map.put("Odisha", new Students(4, 72, "Dhruv", "abc@gamail.com"));
		map.put("Punjab", new Students(5, 78, "Harsh", "abc@gamail.com"));
		map.put("Haryana", new Students(6, 70, "Ajay", "abc@gamail.com"));
		map.put("Utter Pradesh", new Students(7, 80, "Ram", "abc@gamail.com"));
		map.put("Chennai", new Students(8, 81, "Shayam", "abc@gamail.com"));
		map.put("Kerla", new Students(9, 65, "Rakesh", "abc@gamail.com"));
		map.put("Bihar", new Students(10, 74, "Ramesh", "abc@gamail.com"));
		
		for(Map.Entry<String, Students> s : map.entrySet()) {
			System.out.println(s.getKey() + " : " + s.getValue().toString());
		}
		
		System.out.println("\n\n");
		
		MapStudents std = (originalMap) -> {
			
			
			
			return originalMap;
		};
		
	}
}
