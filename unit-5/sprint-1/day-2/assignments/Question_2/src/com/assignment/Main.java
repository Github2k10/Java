package com.assignment;

class Student{
	int roll;
	int standered;
	String name;
	int marks;
	
	public Student(int roll, int standered, int marks, String name) {
		this.name = name;
		this.roll = roll;
		this.standered = standered;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Name = " + name + ", standered = " + standered + "th, Roll = " + roll + ", marks = " + marks;
	}
}

@FunctionalInterface
interface Demo{
public void printDetail(Student student);
}

public class Main {
	Main(){}
	
	public static void fun1(Student student) {
		System.out.println(student.toString());
	}
	
	public void fun2(Student student) {
		System.out.println(student.toString());
	}
	
	Main(Student student){
		System.out.println(student.toString());
	}
	
	public static void main(String[] args) {
		Demo d1 = Main::fun1;
		Demo d2 = new Main()::fun2;
		Demo d3 = Main::new;
		
		System.out.println("using static method");
		d1.printDetail(new Student(1, 10, 75, "Ajay"));
		
		System.out.println("\nusing non-static method");
		d2.printDetail(new Student(2, 11, 65, "Rahul"));
		
		System.out.println("\nusing constructor");
		d3.printDetail(new Student(3, 10, 80, "Rohan"));
	}

}
