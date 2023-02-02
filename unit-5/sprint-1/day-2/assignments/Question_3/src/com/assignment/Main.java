package com.assignment;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface PrintList {
abstract void display(List<String> city);
}

public class Main {
	
	void fun1(List<String> city) {
		for(String s : city) {
			System.out.println(s);
		}
	}

	public static void main(String[] args) {
		List<String> city = new ArrayList<>();
		
		city.add("New Delhi");
		city.add("Mumbai");
		city.add("Kolkata");
		city.add("Lucknow");
		city.add("Patna");
		
		PrintList p = new Main()::fun1;
		p.display(city);
	}

}
