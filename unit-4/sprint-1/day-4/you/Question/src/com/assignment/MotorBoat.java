package com.assignment;

public class MotorBoat{
  private String motorBoatNumber;
  private int capacity;
//  write parameterized constructor, getter & setter method
  
  MotorBoat(String boat){
	  motorBoatNumber = boat;
  }

 void setCapacity(int i) {
	capacity = i;
}
 int getCapacity() {
	 return capacity;
 }
 
 void reduce() {
	 capacity -= 1;
 }
 
 public String getMotorBoatNumber() {
	 return motorBoatNumber;
 }
}