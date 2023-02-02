package com.assignment.Question1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class PredicateExample {

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Predicate<Integer> evenNumber = n -> n % 2 == 0;
		
		for(Integer i : arr) {
			System.out.println(evenNumber.test(i));
		}

	}

}
