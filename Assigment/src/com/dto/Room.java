package com.dto;

public interface Room {
	public int getRoomNumber();

	public void setRoomNumber(int roomNumber);

	public String getRoomType();

	public void setRoomType(String roomType);

	public double getPricePerNight();

	public void setPricePerNight(double pricePerNight);

	public int getMaxPerson();

	public void setMaxPerson(int maxPerson);

	public boolean isEmpty();

	public void setEmpty(boolean empty);
}

