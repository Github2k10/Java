package com.assignment;

public class WatchPriceCalculator {
	
	float getWatchPrice(String name, int age, String gender) {
		int costPrice = 0;
		float profitPercentage = 0.0f;
		float gst = 0.0f;
		float totalCost = 0.0f;
		float discount = 0.0f;
		
		if(name == "Titan") {
			costPrice = 7999;
			profitPercentage = 12.5f;
			gst = 7.5f;
		} else {
			costPrice = 10999;
			profitPercentage = 13.5f;
			gst = 12.5f;
		}
		
		totalCost = costPrice + (costPrice * (profitPercentage + gst)/100);
		
		if(age > 60 && gender == "female") {
			discount += (float)(totalCost * 0.05);
		} else if(age > 60) {
			discount += (float)(totalCost * 0.03);
		} else if(gender == "female") {
			discount += (float)(totalCost * 0.02);
		}
		
		
		return totalCost -= discount;
	}
		
	
	
	
}

class WatchPriceTester{
  public static void main(String args[]){
    WatchPriceCalculator wcOne = new WatchPriceCalculator();
    
    //for watch type = Titan, gender = "female", age = 25
    System.out.println(wcOne.getWatchPrice("Titan", 25, "female"));
    
    //for watch type = Rolex, gender = "male", age = 61
    System.out.println(wcOne.getWatchPrice("Rolex", 61, "male"));
    
    //for watch type = Rolex, gender = "female", age = 61
    System.out.println(wcOne.getWatchPrice("Rolex", 61, "female"));
    
    //for watch type = Rolex, gender = "female", age = 61
    System.out.println(wcOne.getWatchPrice("Titan", 25, "male"));
  }
}