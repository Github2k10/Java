package com.masai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/studentApp")
public class MyController {
	private static Map<Integer, Student> map = new HashMap<>();
	
	@GetMapping("/hello")
	public String getString(){
		return "hello";
	}
	
	@PostMapping("/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.add("message", "Student added");
		
		map.put(student.getRoll(), student);
		return new ResponseEntity<>(student.toString(), headers, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getStudent")
	public List<Student> getStudents(){
//		list.add(new Student(1, "Alpha", 85));
		return new ArrayList<>(map.values());
	}
	
	@PutMapping("/updateSutdent/{id}")
	public String updateStudent(@RequestBody Student student, @PathVariable("id") Integer id) {
		
		Student exStudent = map.get(id);
		exStudent.setName(student.getName());
		exStudent.setMarks(student.getMarks());
		
		return exStudent.toString();
	}
	
	@DeleteMapping("/deleteStudent")
	public String deletStudent(@RequestBody Student student) {
		map.remove(student.getRoll());
		
		return student.toString();
	}
	
	
	@GetMapping("/getStudentById/{roll}")
	public Student getStudentById(@PathVariable("roll") Integer roll) throws Exception {
		Student student = map.get(roll);
		
		if(student == null) throw new Exception("Student Not Found");
		
		return student;
	}
}
