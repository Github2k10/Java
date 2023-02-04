package com.assignment;

public class SpeedBoat {

private String speedBoatNumber;
  private int capacity;
//	  write parameterized constructor, getter & setter method
  
  public SpeedBoat(String boat) {
	  speedBoatNumber = boat;
	}

public void setCapacity(int i) {
	capacity = i;	
}

int getCapcity() {
	return capacity;
}

void reduce() {
	capacity -= 1;
}

String getSpeedBoatNumber() {
	return speedBoatNumber;
}
}
