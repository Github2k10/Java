package assignment.Question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		/*
		 * Q1/- What is the requirement of Java Database communication?
		 *  Answer :- In order to communicate with a database using Java, you need several things:
		 * 
		 * A JDBC driver: JDBC stands for "Java Database Connectivity" and is a standard
		 * API that provides a way for Java programs to access databases. To use JDBC,
		 * you need a JDBC driver for the particular database you are using. The JDBC
		 * driver is a library that contains the classes and methods necessary to
		 * interact with the database.
		 * 
		 * Connection details: You need to know the URL, username, and password for the
		 * database we want to connect to. The URL is a string that identifies the database server
		 * and database name.
		 *
		 * Q2/- What is JDBC, Write a note on JDBC driver software.
		 * Answer :- JDBC(Java Database Connectivity) is a java API that allows java programs to
		 * interact with databases using SQL. JDBC provides a standerd set of interfaces
		 * that allow programmers to write database-independent code that can be used to access a
		 * wide variety of database.
		 * 
		 * JDBC consists of two main components the JDBC API and the JDBC driver software.
		 * 
		 * The JDBC is a set of interfaces and classes that define how java programs can interact with
		 * databases. The API provides a standered way to perform common database operations such as
		 * connecting to a database, executing SQL queried, and retrieving results.
		 * 
		 * 
		 * Q4/- Write down the responsibilities of the Jdbc Client.
		 *  Answer :- The client is responsible for performing the following tasks:
		 *  
		 *  1. Loading the JDBC driver: The client must load the appropriate JDBC driver for the database 
		 *     it wants to connect to. This is typically done using the Class.forName() method.
		 *  2. Establishing a database connection: The client must establish a connection to the database
		 *     using the approprite connection parameters such as database URL, username, and password.
		 *  3. Executing SQL statements. The client must execute SQL statement usch as SELECT, INSERT,
		 *     INSERT, UPDATE, AND DELETE, on the database using the appriate JDBC API methods.
		 *  4. Retrieving query results: The client must retrieve query results and process them
		 *     appropriately. For example, it may display the results in a user inferface, save then to a 
		 *     file, or precess them further using java code.
		 *  5. Handling database exceptions.
		 *  6. Closing databases resources.
		 * 
		 */
		
		
		 //Q3/- Write a Jdbc application to establish the connection with the Mysql database.
		 
		Connection con = null;
		String url = "jdbc:mysql://localhost/student";
		String username = "root";
		String password = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
			
			System.out.println("Connection Stablised Successfully!");
		}catch(ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}finally {
			if(con != null) {
				try {
					con.close();
					System.out.println("connection closed successfully");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
