package com.dto;

import java.util.Objects;

public class StudentImp implements Student {
	private int rollNo;
	private String studentName;
	private String address;
	private int marks;
	
	public StudentImp() {}
	
	public StudentImp(int rollNo, String studentName, String address, int marks) {
		this.rollNo = rollNo;
		this.studentName = studentName;
		this.address = address;
		this.marks = marks;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(address, marks, rollNo, studentName);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentImp other = (StudentImp) obj;
		return rollNo == other.rollNo;
	}
	
	
	@Override
	public String toString() {
		return "Student RollNo = " + rollNo + ", Student Name = " + studentName + ", Address = " + address + ", Marks = " + marks;
	}
	
	
}
