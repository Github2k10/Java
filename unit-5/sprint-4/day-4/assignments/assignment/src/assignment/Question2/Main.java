package assignment.Question2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	static String url = "jdbc:mysql://localhost/student";
	static String username = "root";
	static String password = "root";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection makeConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	public static void closeConnection(Connection con) throws SQLException {
		if(con != null)
		con.close();
	}
	
	public static void main(String[] args) {
		Connection con = null;
		try {
			con = makeConnection();
			System.out.println("connection stablished Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			closeConnection(con);
			System.out.println("Connection closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
