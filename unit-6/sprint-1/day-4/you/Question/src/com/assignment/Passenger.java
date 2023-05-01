package com.assignment;

public class Passenger {
	  private String passengerId;
	  private String name;
	  private SpeedBoat speedBoat;
	  private MotorBoat motorBoat;
	  private static int passengerCounter = 0;

	  public Passenger(String user) {
	    //code to generate passenger is PS001 and onwards...
	    //use passengerCounter for the same
	    //write code to set name
		  passengerCounter++;
		  name = user;
		  
		  passengerId = "PS100" + passengerCounter;
	  }
	  
	  String getName() {
		  return name;
	  }

	  String getPassengerId() {
		  return passengerId;
	  }
	  
	  public MotorBoat getMotorBoat() {
		  return motorBoat;
	  }
	  
	  public SpeedBoat getSpeedBoat() {
		  return speedBoat;
	  }
	  
	  void setMotorBoat(MotorBoat boat) {
		  motorBoat = boat;
	  }
	  
	  void setSpeedBoat(SpeedBoat boat) {
		  speedBoat = boat;
	  }

//	  getter and setter method
	}
