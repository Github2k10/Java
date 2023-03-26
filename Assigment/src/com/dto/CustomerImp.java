package com.dto;

public class CustomerImp implements Customer{
	private int customerid;
	private String customerName;
	private String address;
	private int roomNumber;
	
	public CustomerImp() {}
	
	public CustomerImp(int customerid, String customerName, String address) {
		super();
		this.customerid = customerid;
		this.customerName = customerName;
		this.address = address;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	@Override
	public String toString() {
		return "Customer id = " + customerid + ", Customer Name = " + customerName + ", Address = " + address
				+ ", Room Number = " + roomNumber;
	}
	
	
}
