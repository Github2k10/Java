package com.Question5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		File f = new File("abc.txt");
		f.createNewFile();
		
		PrintWriter pw = new PrintWriter(f);
		pw.println("7011842201");
		pw.println("7428562513");
		pw.println("6854793254");
		pw.println("9874521686");
		pw.println("1247853695");
		pw.println("2458796584");
		pw.println("7485961023");
		pw.println("8521479630");
		pw.println("5874563210");
		pw.println("1478523690");

		pw.close();
		
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		File f2 = new File("xyz.txt");
		f.createNewFile();
		pw = new PrintWriter(f2);
		
		
		System.out.println("File abc.txt Reading: ");
		while(br.ready()) {
			String str = br.readLine();
			char ch = str.charAt(0);
			if(ch == '6' || ch == '7' || ch == '8' || ch == '9') {
				pw.println(str);
			}
			
			System.out.println(str);
		}
		
		pw.close();
		br.close();
		
		System.out.println();
		fr = new FileReader("xyz.txt");
		br = new BufferedReader(fr);

		System.out.println("File xyz.txt Reading: ");
		while(br.ready()) {
			System.out.println(br.readLine());
		}
		
		br.close();
		System.out.println("\nAll files are closed");
	}

}
