package com.Question4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String state;
	private String city;
	private String pincode;
	
	public Address(String state, String city, String pincode) {
		this.state = state;
		this.city = city;
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	
}


class Student implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int roll;
	private String name;
	private int marks;
	transient private String password;
	private Address address;
	
	public Student(int roll, String name, int marks, String password, Address address) {
		this.roll = roll;
		this.name = name;
		this.marks = marks;
		this.password = password;
		this.address = address;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [roll=" + roll + ", name=" + name + ", marks=" + marks + ", password=" + password + ", address="
				+ address + "]";
	}
	
	
}

public class Demo1 {

	public static void main(String[] args) throws IOException {
		List<Student> list = new ArrayList<>();
		
		list.add(new Student(1, "Berline", 550, "abc123", new Address("West Delhi", "Delhi", "110040")));
		list.add(new Student(2, "Tokayo", 450, "abc123", new Address("North Delhi", "Delhi", "110086")));
		list.add(new Student(3, "Bobin", 650, "abc123", new Address("sount Delhi", "Delhi", "110055")));
		list.add(new Student(4, "Harsh", 520, "abc123", new Address("East Delhi", "Delhi", "110075")));
		list.add(new Student(5, "Alpha", 480, "abc123", new Address("West Delhi", "Delhi", "110059")));
		
		File f = new File("studentdata.txt");
		
		if(f.createNewFile()) {
			System.out.println("File created successfully");
		} else {
			System.out.println("File is already present");
		}
		
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(list);
		
		oos.close();
		System.out.println("object is serailized");
	}

}
