package com.Question3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class Main{
	public static void main(String args[]) {
		List<String> list = Arrays.asList("Alpha", "Bravo", "Charli", "Berlin", "Tom", "Tokyo", "Ben", "Justin", "Stefin", "Oscar");
		
		List<String> filter = list.stream()
				.filter(s -> s.length() % 2 ==0)
				.collect(Collectors.toList());
		
		List<String> upper = filter.stream()
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		
		List<String> sort = upper.stream().sorted((a, b) -> b.compareTo(a))
				.collect(Collectors.toList());
		
		System.out.println("Original List : " + list);
		System.out.println("Updated List : " + sort);
		
	}
}



