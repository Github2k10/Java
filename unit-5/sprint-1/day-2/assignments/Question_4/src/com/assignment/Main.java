package com.assignment;

import java.util.ArrayList;
import java.util.List;

class Student{
	String name;
	int roll;
	int marks;
	
	public Student(int roll, int marks, String name) {
		this.name = name;
		this.roll = roll;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Name = " + name + ", roll = " + roll + ", marks = " + marks;
	}
	
	
}

@FunctionalInterface
interface Intr {	
	public List<Student> findStudent(List<Student> stu);
}

public class Main {
	
	List<Student> fun1(List<Student> stu){
		stu.removeIf(s -> s.marks < 500);
		
		return stu;
	}

	public static void main(String[] args) {
		List<Student> s = new ArrayList<>();
		
		s.add(new Student(1, 600, "Ram"));
		s.add(new Student(2, 700, "Ram"));
		s.add(new Student(3, 650, "Ram"));
		s.add(new Student(4, 570, "Ram"));
		s.add(new Student(5, 400, "Ram"));
		s.add(new Student(6, 350, "Ram"));
		s.add(new Student(7, 780, "Ram"));
		s.add(new Student(8, 480, "Ram"));
		s.add(new Student(9, 550, "Ram"));
		s.add(new Student(10, 600, "Ram"));
		
		Intr i = new Main()::fun1;
		
		List<Student> st = i.findStudent(s);
		
		for(Student stu : st) {
			System.out.println(stu.toString());
		}
	}

}
