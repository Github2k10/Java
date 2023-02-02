package com.assignment;

import java.util.ArrayList;
import java.util.Collections;



public class Main {
	public static void main(String args[]) {
		ArrayList<String> arr = new ArrayList<>();
		
		arr.add("New Delhi");
		arr.add("Mumbai");
		arr.add("Bangalore");
		arr.add("Rajasthan");
		arr.add("Utter Pradash");
		arr.add("Kerla");
		arr.add("Tamil Nadu");
		arr.add("Madhya Pradash");
		arr.add("Bihar");
		arr.add("Punjab");
		
		Collections.sort(arr, (a1, a2) -> a1.compareTo(a2) > 0 ? +1 : -1);
		
		System.out.println(arr);
	}
}
