package com.Question2;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File f = new File("students.txt");
		
		if(f.createNewFile()) {
			System.out.println("File created successfully");
		} else {
			System.out.println("File is already present");
		}
	}

}
