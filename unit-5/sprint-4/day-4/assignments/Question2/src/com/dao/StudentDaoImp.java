package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dto.Student;
import com.dto.StudentImp;
import com.execption.StudentException;


public class StudentDaoImp implements StudentDao {
	private List<Student> getAlList(ResultSet resultSet){
		List<Student> list = new ArrayList<>();
		try {
			while(resultSet.next()) {
				Student stdStudent = new StudentImp();
				
				stdStudent.setRollNo(resultSet.getInt("rollNo"));
				stdStudent.setStudentName(resultSet.getString("studentName"));
				stdStudent.setAddress(resultSet.getString("address"));
				stdStudent.setMarks(resultSet.getInt("marks"));
				list.add(stdStudent);
			}
		} catch (SQLException e) {
			System.out.println("Student not found");
		}
		
		return list;
	}
	
	private boolean isResultSetEmpty(ResultSet resultSet) throws SQLException {
		return (!resultSet.isBeforeFirst() && resultSet.getRow() == 0) ?  true : false;
	}

	@Override
	public List<Student> getAllStudent() {
		Connection con = null;
		List<Student> list = null;
		try {
			con = ConnectToDataBase.connectToDataBase();
			String queryString = "Select * from student;";
			
			PreparedStatement pst = con.prepareStatement(queryString);
			
			ResultSet resultSet = pst.executeQuery();
			
			if(isResultSetEmpty(resultSet)) {
				throw new StudentException("Something went wrong");
			}
			
			list = getAlList(resultSet);
		} catch (SQLException | StudentException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectToDataBase.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public String saveStudentDetails(Student student) {
		Connection connection = null;
		
		
		try {
			connection = ConnectToDataBase.connectToDataBase();
			String queryString = "INSERT INTO student VALUES (?, ?, ?, ?);";
			
			PreparedStatement pst = connection.prepareStatement(queryString);
			
			pst.setInt(1, student.getRollNo());
			pst.setString(2, student.getStudentName());
			pst.setString(3, student.getAddress());
			pst.setInt(4, student.getMarks());
			
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "Error";
		} finally {
			try {
				ConnectToDataBase.closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Student Added Successfully";
	}

	@Override
	public boolean deleteStudentByRollNo(int rollNo) throws StudentException {
		Connection connection = null;
		
		try {
			String queryString = "DELETE FROM student where rollNo = ?";
			
			
			connection = ConnectToDataBase.connectToDataBase();
			
			PreparedStatement pst = connection.prepareStatement(queryString);
			pst.setInt(1, rollNo);
			
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public String graceStudentMarks(int rollNo, int marks) throws StudentException {
		Connection con = null;             
		
		try {
			
			con = ConnectToDataBase.connectToDataBase();
			
			String queryString = "UPDATE student SET marks = (marks + ?) where rollNo = ?";
			
			//get object of prepared statement 
			PreparedStatement pst = con.prepareStatement(queryString);
			
			//stuff the data in the query
			pst.setInt(1, marks);
			pst.setInt(2, rollNo);
			
			// execute query
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new StudentException("facing some issue");
		} finally {
			try {
				ConnectToDataBase.closeConnection(con);
			} catch (SQLException e) {
				throw new StudentException("Something went wrong");
			}
		}
		return "student data updated successfully";
	}

	@Override
	public List<Student> getStudentsByName(String name) throws StudentException {
		Connection connection = null;
		List<Student> list = null;
		
		try {
			connection =  ConnectToDataBase.connectToDataBase();
			
			String queryString = "Select * from student where studentName = ?;";
			
			PreparedStatement pst = connection.prepareStatement(queryString);
			pst.setString(1, name);
			
			ResultSet resultSet = pst.executeQuery();
			
			if(isResultSetEmpty(resultSet)) {
				throw new StudentException("Data not foun in the database");
			}
			
			list = getAlList(resultSet);
		} catch (SQLException e) {
			throw new StudentException("something went wrong");
		} finally {
			try {
				ConnectToDataBase.closeConnection(connection);
			} catch (SQLException e) {
				throw new StudentException("Somthing went wrong");
			}
		}
		return list;
	}

}
