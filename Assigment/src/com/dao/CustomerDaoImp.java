package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.dto.Customer;
import com.exception.RoomException;

public class CustomerDaoImp implements CustomerDao{

	@Override
	public String addCustomerToRoom(Customer customer, int roomNumber) {
		Connection connection = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "insert into customer values (?, ?, ?, ?);";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, customer.getCustomerid());
			statement.setString(2, customer.getCustomerName());
			statement.setString(3, customer.getAddress());
			statement.setInt(4, roomNumber);
			
			statement.executeUpdate();
			
			return "Customer added to Room";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return "Operation faild!!!!";
	}

	@Override
	public String removeCustomerFromRoom(Customer customer, int roomNumber) {
		Connection connection = null;
		
		try {
			connection = ConnectToDatabase.makeConnection();
			
			String query = "";
			
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, customer.getCustomerid());
			
			statement.executeUpdate();
			
			return "Customer added to Room";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectToDatabase.closeConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Customer> getCustomerFromParticularRoom(int roomNumber) throws RoomException {
		// TODO Auto-generated method stub
		return null;
	}

}
