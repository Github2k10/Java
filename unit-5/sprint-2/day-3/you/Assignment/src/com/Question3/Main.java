package com.Question3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		File f = new File("abc.txt");
		
		if(f.createNewFile()) {
			System.out.println("File created successfully");
		} else {
			System.out.println("File is already present");
		}
		
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(f);
		System.out.println("Enter Employee Name: ");
		String str = sc.nextLine();
		pw.println("Employee Name: " + str);
		
		System.out.println("Enter Address: ");
		str = sc.nextLine();
		pw.println("Address: " + str);
		
		sc.close();
		pw.close();
		
		System.out.println("Details Added");
	}

}
