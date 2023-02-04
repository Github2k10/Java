package com.assignment;

public class BoatTicketIssue {
	  static boolean issueTicket(Passenger passenger, SpeedBoat speedBoat) {
	    //write code to allot speed boat to passenger it has vacant seat
	    //reduce total capacity of the boat by 1 after allocation
	    //if boat allocation it successful then return true; false otherwise
		  
		  passenger.setSpeedBoat(speedBoat);
		  
		  int capacity = speedBoat.getCapcity();
		  
		  if(capacity > 0) {
			  speedBoat.reduce();
			  return true;
		  } else {
			  return false;
		  }
	  }

	static boolean issueTicket(Passenger passenger, MotorBoat motorBoat) {
	    //write code to allot motor boat to passenger it has vacant seat
	    //reduce total capacity of the boat by 1 after allocation
	    //if boat allocation it successful then return true; false otherwise
		
		passenger.setMotorBoat(motorBoat);
		
		int capacity = motorBoat.getCapacity();
		
		if(capacity > 0) {
			motorBoat.reduce();
			return true;
		} else {
			return false;
		}
	  }
}
