package com.dto;

public class RoomImp implements Room{
	private int roomNumber;
	private String roomType;
	private double pricePerNight;
	private int maxPerson;
	private boolean empty;
	
	public RoomImp() {}

	public RoomImp(int roomNumber, String roomType, double pricePerNight, int maxPerson) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.pricePerNight = pricePerNight;
		this.maxPerson = maxPerson;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public int getMaxPerson() {
		return maxPerson;
	}

	public void setMaxPerson(int maxPerson) {
		this.maxPerson = maxPerson;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	@Override
	public String toString() {
		return "Room Number = " + roomNumber + ", Room Type = " + roomType + ", Price Per Night = " + pricePerNight
				+ ", Max Person = " + maxPerson + ", Empty = " + (empty ? "Yes" : "No");
	}
	
	
}
