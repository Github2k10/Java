package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectToDatabase {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection makeConnection() throws SQLException {
		ResourceBundle bundle = ResourceBundle.getBundle("dbdetails");
		
		return DriverManager.getConnection(bundle.getString("url"), bundle.getString("username"), bundle.getString("password"));
	}
	
	public static void closeConnection(Connection connection) throws SQLException {
		if(connection != null) {
			connection.close();
		}
	}
}
