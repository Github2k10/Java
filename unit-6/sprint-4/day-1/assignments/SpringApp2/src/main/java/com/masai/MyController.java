package com.masai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String getString() {
		return "Welcome, Dev";
	}
	
	@RequestMapping("/student")
	@ResponseBody
	public Student getStudent() {
		Student student = new Student(1, "Alpha", 50);
		
		return student;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<Student> getList(){
		List<Student> list = new ArrayList<>();
		
		list.add(new Student(1, "Alpha", 75));
		list.add(new Student(2, "Bravo", 75));
		list.add(new Student(3, "Chalie", 75));
		list.add(new Student(4, "Devid", 75));
		list.add(new Student(5, "Ron", 75));
		list.add(new Student(6, "Ron", 75));
		list.add(new Student(7, "Ron", 75));
		
		return list;
	}
	
	@RequestMapping("/map")
	@ResponseBody
	public Map<Student, String> getMap(){
		Map<Student, String> map = new HashMap<>();
		
		
		map.put(new Student(1, "Alpha", 75), "Delhi");
		map.put(new Student(2, "Bravo", 75), "Delhi");
		map.put(new Student(3, "Chalie", 75), "Delhi");
		map.put(new Student(4, "Devid", 75), "Delhi");
		map.put(new Student(5, "Ron", 75), "Delhi");
		
		return map;
	}
	
	
	@RequestMapping("/set")
	@ResponseBody
	public Set<Student> getSet(){
		Set<Student> set = new TreeSet();
		
		set.add(new Student(1, "Alpha", 75));
		set.add(new Student(2, "Bravo", 82));
		set.add(new Student(3, "Chalie", 74));
		set.add(new Student(4, "Devid", 65));
		set.add(new Student(5, "Ron", 78));
		
		return set;
	}
}
