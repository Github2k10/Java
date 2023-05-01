package com.assignment;

class JoyInfocom{
	int callServices = 300;
	int smsServices = 50;
	int dataServices = 125;
	
	  double getBillAmount(boolean usingCallService, boolean usingDataService, boolean usingSMSService){
	    //write code to return bill amount up to two decimal places
		  double totalCost = 0;
		  
		  if(usingCallService) {
			  totalCost += callServices;
		  }
		  
		  if(usingSMSService) {
			  totalCost += smsServices;
		  }
		  
		  if(usingDataService) {
			  totalCost += dataServices;
		  }
		  
		  return totalCost;
	  }
	}

	class JoyInfocomTester{
	  public static void main(String args[]){
	    JoyInfocom joy = new JoyInfocom();
	    System.out.println(joy.getBillAmount(true, true, false));
	    System.out.println(joy.getBillAmount(true, false, false));
	    System.out.println(joy.getBillAmount(true, true, true));
	  }
	}
