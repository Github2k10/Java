package com.dao;

import java.util.List;
import com.dto.Student;
import com.execption.StudentException;

public interface StudentDao {
	public List<Student> getAllStudent();
	public String saveStudentDetails(Student student);
	public boolean deleteStudentByRollNo(int rollNo)throws StudentException;
	public String graceStudentMarks(int rollNo, int marks)throws StudentException;
	public List<Student> getStudentsByName(String name)throws StudentException;
}
