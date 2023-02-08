package com.Question4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Demo2 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File f = new File("studentdata.txt");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<Student> list = (List<Student>)ois.readObject();
		list.forEach(System.out::println);
		
		ois.close();
	}

}
