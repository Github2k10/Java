package com.UIMain;

import java.util.List;
import java.util.Scanner;

import com.dao.StudentDao;
import com.dao.StudentDaoImp;
import com.dto.Student;
import com.dto.StudentImp;
import com.execption.StudentException;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentDao studentDao = new StudentDaoImp();
		Student stdStudent = null;
		boolean flag = false;
		
		do {
			stdStudent = new StudentImp();
			System.out.println("1. Add student\n2. delete student\n3. give grase marks\n4. get all student list\n5. exit");
			System.out.println("Enter your choise: ");
			int key = Integer.parseInt(scanner.nextLine());
			
			switch (key) {
			case 1: System.out.println("+----------------------------------------------------------+");
					System.out.print("Enter rollNO: ");
					stdStudent.setRollNo(Integer.parseInt(scanner.nextLine()));
					
					System.out.print("Enter name: ");
					stdStudent.setStudentName(scanner.nextLine());
					
					System.out.print("Enter address: ");
					stdStudent.setAddress(scanner.nextLine());
					
					System.out.print("Enter marks: ");
					stdStudent.setMarks(Integer.parseInt(scanner.nextLine()));
					
					System.out.println(studentDao.saveStudentDetails(stdStudent));
					System.out.println("+----------------------------------------------------------+");
					break;
					
			case 2 : try {
					System.out.print("Enter student rollNo: ");
					Boolean check =  studentDao.deleteStudentByRollNo(Integer.parseInt(scanner.nextLine()));
					
					if(check) {
						System.out.println("Student deleted successfully");
					} else {
						System.out.println("facing some issue");
					}
					} catch (StudentException e) {
						e.printStackTrace();
					}
					break;
				
			case 3 : System.out.println("+----------------------------------------------------------+");
					 System.out.print("Enter student rollNo: ");
			 			Integer nInteger = Integer.parseInt(scanner.nextLine()); 
			 		 System.out.print("Enter marks to be grace: ");
			 		   Integer mInteger = Integer.parseInt(scanner.nextLine());
			 		   
					try {
						System.out.println(studentDao.graceStudentMarks(nInteger, mInteger));
					} catch (StudentException e) {
						e.printStackTrace();
					}
					System.out.println("+----------------------------------------------------------+");
					break;
			
			case 4 : List<Student> list = studentDao.getAllStudent();
					 System.out.println("=-------------------------------------------------------------------------------------=");
					 list.forEach(System.out::println);
					 System.out.println("=-------------------------------------------------------------------------------------=");
					 break;
			
			case 5 :  flag = true;
				     break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + key);
			}
			
			if(flag) break;
		} while(true);
		
		System.out.print("Thank you");
		scanner.close();
		System.exit(0);
	}

	

}
