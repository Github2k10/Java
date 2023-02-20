package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Utility class to make connection and close connection with the database
 * @author Ankit
 *
 */

public class ConnectToDataBase {
	static final String url = "jdbc:mysql://localhost/db1";
	static final String username = "root";
	static final String password = "root";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection connectToDataBase() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void closeConnection(Connection con) throws SQLException {
		if(con != null) {
			con.close();
		}
	}
}
