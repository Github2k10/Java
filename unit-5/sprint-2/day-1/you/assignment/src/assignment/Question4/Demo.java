package assignment.Question4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo extends Thread{
	List<String> list;
	synchronized void addCity(List<String> list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 4 city name : ");
		list.add(sc.nextLine());
		list.add(sc.nextLine());
		list.add(sc.nextLine());
		list.add(sc.nextLine());
		
		
	}
	
	
	public static void main(String args[]) {
		List<String> list = new ArrayList<>();
		
		Demo th1 = new Demo();
		th1.start();
		th1.addCity(list);
		
		
		try {
			th1.join();
		} catch(Exception ex) {
			
		}
		
		System.out.println("\nCity Names : ");
		for(String s : list) {
			System.out.println(s);
		}
	}
}
