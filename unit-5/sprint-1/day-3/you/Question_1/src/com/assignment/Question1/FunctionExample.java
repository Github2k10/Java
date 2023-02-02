package com.assignment.Question1;

import java.util.function.Function;
import java.lang.StringBuilder;

public class FunctionExample {

	public static void main(String[] args) {
		Integer num = 1234567890;
		
		Function<Integer, StringBuilder> intToStirng = n -> {
			int count = 0;
			int b = String.valueOf(n).length();
			n = Integer.parseInt(String.valueOf(new StringBuilder(String.valueOf(n)).reverse()));
			StringBuilder str = new StringBuilder();
			
			while(count < b) {
				Integer a = n % 10;
				n = n/10;
				
				switch(a) {
					case 0 : str.append("zero ");
					break;
					
					case 1 : str.append("one ");
					break;
					
					case 2 : str.append("two ");
					break;
					
					case 3 : str.append("three ");
					break;
					
					case 4 : str.append("four ");
					break;
					
					case 5 : str.append("five ");
					break;
					
					case 6 : str.append("six ");
					break;
					
					case 7 : str.append("seven ");
					break;
					
					case 8 : str.append("eight ");
					break;
					
					case 9 : str.append("nine ");
					break;
				}
				count++;
			}
			
			return str;
		};
		
		System.out.println(intToStirng.apply(num));

	}

}
