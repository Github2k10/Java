package com.Question5;

import java.time.LocalDate;
import java.time.Month;

@FunctionalInterface
public interface StudentService{
		public void printStudentDetails(Student student);
}



class Student {
	private String name;
	private int roll;
	private String address;
	private LocalDate dateOfBirth;
	
	public Student(String name, int roll, String address, LocalDate dateOfBirth) {
		this.name = name;
		this.roll = roll;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Student name=" + name + ", roll=" + roll + ", address=" + address + ", dateOfBirth=" + dateOfBirth
;
	}
	
	
	
}

class Main{
	public Main() {};
	public Main(Student student) {
		System.out.println(student.toString());
	}

	public static void printDetails(Student student) {
		System.out.println(student.toString());
		
	}
	
	public void print(Student student) {
		System.out.println(student.toString());
	}
	
	
	public static void main(String args[]) {
		
		
		
		//Static Method Reference
		System.out.println("A static mathod reference is used to refer to a static method of a class.\nThe sysntax for a static method reference is ClassName::methodName.");
		StudentService obj1 = Main::printDetails;
		obj1.printStudentDetails(new Student("tom", 1, "New Delhi", LocalDate.of(2003, Month.MAY, 16)));
		System.out.println();
		
		
		//Non-Static method Reference
		System.out.println("A Non-static method reference is used to refer to an instance method of an object.\nThe Syntax for a non-static method referece is object::mehtodName;");
		StudentService obj2 = new Main()::print;
		obj2.printStudentDetails(new Student("tom", 1, "New Delhi", LocalDate.of(2003, Month.MAY, 16)));
		System.out.println();
		
		//Constructor Method Reference
		System.out.println("A constructor method referece is used to refer to a constructor of a class.\nThe syntax for a constructor method referece is ClassName::new");
		StudentService obj3 = Main::new;
		obj3.printStudentDetails(new Student("tom", 1, "New Delhi", LocalDate.of(2003, Month.MAY, 16)));
	}

	
}


