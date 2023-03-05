package day1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question3 {
	public static void main(String args[]) {
		List<String> list = Arrays.asList("Alpha", "Bravo", "Charli", "Berlin", "Tom", "Tokyo", "Ben", "Justin", "Stefin", "Oscar");
		
		List<String> list2 = list.stream().filter( s -> s.length() % 2 == 0).map( s -> s.toUpperCase()).collect(Collectors.toList());
		
		list.forEach(s -> System.out.print(s + "  "));
		System.out.println();
		list2.forEach(s -> System.out.print(s + " "));
	}
}
