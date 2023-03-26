package com.ui;

import java.util.Scanner;

public class MainUI {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choise = 0;
		
		do {
			System.out.println("1. Add Employee\n"
					+ "2. Add Department\n"
					+ "3. Show list of Employee details who work in the selected department\n"
					+ "4. Delete Department\n"
					+ "5. Department details of those employees who live in selected state");
			
			System.out.print("Enter Section: ");
			choise = Integer.parseInt(scanner.nextLine());
			
			switch(choise) {
				case 1:
					break;
					
				case 2:
					break;
					
				case 3:
					break;
					
				case 4:
					break;
					
				case 5:
					
					break;
				
				case 0: break;
				
				default:
					System.out.println("Invaild Selection!!!!\nChoise with given options");
			}
			
		} while (choise != 0);
		
		System.out.println("Thank you for visiting");
		scanner.close();
	}

}
