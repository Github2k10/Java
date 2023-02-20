package assignment.Question3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	static final String url = "jdbc:mysql://localhost/student";
	static final String username = "root";
	static final String password = "root";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection makeConnection() throws SQLException {
		return DriverManager.getConnection(url,username,password);
	}
	
	public static void closeConneciton(Connection con) throws SQLException {
		con.close();
	}
	
	public static boolean createTable(String str) throws SQLException{
		Connection con = makeConnection();
		Statement st = con.createStatement();
		try {
			st.executeUpdate(str);
			System.out.println("Table Created Successfully");
		} catch (SQLException e) {
			return false;
		}
		closeConneciton(con);
		return true;
	}
	
	public static void addProduct() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con = makeConnection();
		
		String st = "insert into product values (?, ?, ?, ?);";
		
		PreparedStatement pst = con.prepareStatement(st);
		
		System.out.print("Enter Product Details:\nProduct id: ");
		int pid = sc.nextInt();
		System.out.print("Product Name: ");
		String pname = sc.next();
		System.out.print("Quantity: ");
		int quantity = sc.nextInt();
		System.out.println("Price: ");
		int price = sc.nextInt();
		
		pst.setInt(1, pid);
		pst.setString(2, pname);
		pst.setInt(3, quantity);
		pst.setInt(4, price);
		
		int res = pst.executeUpdate();
		
		if(res > 0) {
			System.out.println("Product Added successfully");
		} else {
			System.out.println("somthing went worng");
		}
		
		closeConneciton(con);
		sc.close();
	}
	
	public static void addProductwihout() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con = makeConnection();
		
		String st = "insert into product values (?, ?, null, null);";
		
		PreparedStatement pst = con.prepareStatement(st);
		
		System.out.print("Enter Product Details:\nProduct id: ");
		int pid = sc.nextInt();
		System.out.print("Product Name: ");
		String pname = sc.next();
		
		pst.setInt(1, pid);
		pst.setString(2, pname);
		
		int res = pst.executeUpdate();
		
		if(res > 0) {
			System.out.println("Product Added successfully");
		} else {
			System.out.println("somthing went worng");
		}
		
		closeConneciton(con);
		sc.close();
	}
	
	public static void updateProduct() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con = makeConnection();
		
		System.out.print("Enter Product Details:\nProduct id: ");
		int pid = sc.nextInt();
		System.out.print("Product new quantity: ");
		Double quantity = sc.nextDouble();
		System.out.print("Product new price: ");
		String price = sc.next();
		
		String st = "update product set quantity = ?, price = ? where pid = ?;";
		PreparedStatement pst = con.prepareStatement(st);
		
		pst.setDouble(1, quantity);
		pst.setString(2, price);
		pst.setInt(3, pid);
		
		int res = pst.executeUpdate();
		
		if(res > 0) {
			System.out.println("Product updated successfully");
		} else {
			System.out.println("somthing went worng");
		}
		
		closeConneciton(con);
		sc.close();
	}
	
	
	public static void deleteProduct() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con = makeConnection();
		
		String st = "DELETE FROM product WHERE quantity < 2";
		Statement pst = con.createStatement();
		
		int res = pst.executeUpdate(st);
		
		if(res > 0) {
			System.out.println("Product " + res + "  deleted successfully");
		} else {
			System.out.println("There is no product whose quantity is less than 2");
		}
		
		closeConneciton(con);
		sc.close();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Create Table
		String create = "create table product(pid int primary key, pname varchar(25) not null, quantity int, price int);";
		try {
			createTable(create);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		while(true){
			System.out.println("Select option: ");
			System.out.println("1. Add product details ");
			System.out.println("2. Add product details without quantity and price ");
			System.out.println("3. Update price and product of any product ");
			System.out.println("4. delete all the Products whose quantity is less than 2");
			System.out.println("99. Exit");
			boolean flag = false;
			
			int n = sc.nextInt();
			
			switch(n) {
			case 1 : try {
						addProduct();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					 break;
			
			case 2 : try {
					addProductwihout();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 		break;
			 		
			case 3 : try {
					updateProduct();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 		break;
			 		
			case 4 : try {
					deleteProduct();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			 		break;
			 		
			case 99 : flag = true;
			 		break;
			 
			default : System.out.println("Invalid input!!!");
			}
			
			if(flag) break;
		};
		
		System.out.println("Thank you!!!");
		sc.close();
	}

}
