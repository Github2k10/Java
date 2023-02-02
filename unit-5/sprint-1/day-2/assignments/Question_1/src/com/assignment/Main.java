package com.assignment;

@FunctionalInterface
interface Demo{
	public int convetStringToNumber(String s);
}

public class Main {

	public int fun1(String s) {
		return Integer.parseInt(s);
	}
	
	public static void main(String[] args) {
		Demo d = new Main()::fun1;
		
		System.out.println(d.convetStringToNumber("34"));
		
		System.out.println(d.convetStringToNumber("75"));

		System.out.println(d.convetStringToNumber("92"));
	}

}
