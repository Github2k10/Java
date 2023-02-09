package com.assignment;

public class SimpleInterest {

	double principleAmount;
	double timePeriod;
	double interestRate;
	
	void setValues(double pa, double tp, double ir){
	    //write code to assign value here
		principleAmount = pa;
		timePeriod = tp;
		interestRate = ir;
	}
	
	double getInterestAmount(){
	    //write code to computer and return the interest amount rounded to two decimal places
		double value = (principleAmount * timePeriod * interestRate)/100;
		return (Math.round(value * 100))/100.0;
	}
}

class SimpleInterestTester{
    public static void main(String args[]){
        SimpleInterest siOne = new SimpleInterest();
        SimpleInterest siTwo = new SimpleInterest();
        siOne.setValues(1005, 2, 7.5);
        siTwo.setValues(1235.50, 2.5, 8.25);
        
        System.out.println(siOne.getInterestAmount());
        System.out.println(siTwo.getInterestAmount());
    }
}