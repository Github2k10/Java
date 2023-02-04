package com.assignment;

class ZiaConstructionsLimited{
	
  double getTotalCost(double totalArea, double labourCharges){
    //return the total bill cost up to two decimal places
	  return totalArea*labourCharges;
  }
  
  double getTotalCost(double totalArea, double labourCharges, double materialCharges){
    //return the total bill cost up to two decimal places
	  return totalArea*(labourCharges+materialCharges);
  }
}

class ZiaConstructionsLimitedTester{
  public static void main(String args[]){
    ZiaConstructionsLimited zcl = new ZiaConstructionsLimited();
    System.out.println(zcl.getTotalCost(1500, 250));
    System.out.println(zcl.getTotalCost(1500, 250, 350));
  }
}