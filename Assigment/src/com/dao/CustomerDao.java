package com.dao;

import java.util.List;

import com.dto.Customer;
import com.exception.RoomException;

public interface CustomerDao {
	public String addCustomerToRoom(Customer customer, int roomNumber);
	public String removeCustomerFromRoom(Customer customer, int roomNumber);
	public List<Customer> getCustomerFromParticularRoom(int roomNumber) throws RoomException;
}
