package day1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Student {
	private int roll;
	private String name;
	private int marks;

	public Student() {
	}

	public Student(int roll, String name, int marks) {
		this.roll = roll;
		this.name = name;
		this.marks = marks;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", marks=" + marks + "]";
	}

}

class Employee {
	private int id;
	private String name;
	private int salary;

	public Employee() {
	}

	public Employee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
}

public class Question2 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();

		list.add(new Student(1, "abc", 500));
		list.add(new Student(2, "qwe", 580));
		list.add(new Student(3, "cfg", 620));
		list.add(new Student(4, "ohn", 400));
		list.add(new Student(5, "tgb", 450));
		list.add(new Student(6, "abc", 400));
		list.add(new Student(7, "qwe", 530));
		list.add(new Student(8, "cfg", 700));
		list.add(new Student(9, "ohn", 550));
		list.add(new Student(10, "tgb", 450));

		list.stream().filter(s -> s.getMarks() > 500).map(s -> {
			Employee employee = new Employee();

			employee.setId(s.getRoll());
			employee.setName(s.getName());
			employee.setSalary(s.getMarks() * 1000);

			return employee;
		}).sorted((s1, s2) -> s1.getSalary() > s2.getSalary() ? -1 : 1).collect(Collectors.toList())
		  .forEach(System.out::println);

	}

}
