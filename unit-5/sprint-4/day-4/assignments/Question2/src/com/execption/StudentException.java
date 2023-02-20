package com.execption;

public class StudentException extends Exception{
	public StudentException(String message) {
		super(message);
	}

	@Override
	public String toString() {
		return getMessage();
	}
	
	
}
