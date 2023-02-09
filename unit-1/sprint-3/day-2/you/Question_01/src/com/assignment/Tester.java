package com.assignment;

interface Taxation{
	  //write code here
	public double calculateTax();
	}

	class SalariedPeople implements Taxation{
	  //write code here
		int annualSession;
		
		public SalariedPeople(int annualSession) {
		this.annualSession = annualSession;
	}

		@Override
		public double calculateTax() {
			double grandTotal = 0.0;
			
			if(annualSession <= 250000) {
				grandTotal = 0.0;
			} else if(annualSession > 250000 && annualSession <= 500000) {
				annualSession -= 250000;
				grandTotal = annualSession*0.1;
			} else if(annualSession > 500000 && annualSession <= 1000000) {
				annualSession -= 500000;
				grandTotal += 25000.0;
				grandTotal += annualSession*0.2;
			} else if(annualSession > 1000000 && annualSession <= 10000000) {
				annualSession -= 1000000.0;
				grandTotal += 125000.0;
				grandTotal += annualSession*0.3;
			} else {
				grandTotal = 750000.0;
			}
			
			return grandTotal;
		}
}

class BusinessPeople implements Taxation{
	  //write code here
		int total_Sale;
		int total_Purchase;
		int operating_Cost;
		int Total;
		
		
		
		public BusinessPeople(int total_Sale, int total_Purchase, int operating_Cost) {
			super();
			this.total_Sale = total_Sale;
			this.total_Purchase = total_Purchase;
			this.operating_Cost = operating_Cost;
			
			Total = total_Sale - (total_Purchase + operating_Cost);
		}



		@Override
		public double calculateTax() {
			double grandTotal = 0.0;
			
			if(Total <= 500000) {
				grandTotal = 0.0;
			} else if(Total > 500000 && Total <= 1500000) {
				Total -= 500000;
				grandTotal = Total*0.1;
			} else if(Total > 1500000 && Total <= 5000000) {
				Total -= 1500000;
				grandTotal += 100000.0;
				grandTotal += Total*0.22;
			} else if(Total > 5000000 && Total <= 50000000) {
				Total -= 5000000.0;
				grandTotal += 770000.0;
				grandTotal += Total*0.32;
			} else {
				grandTotal = 1250000.0;
			}
			
			return grandTotal;
		}
}

class Tester{
	  public static void main(String args[]) {
	    Taxation taxation = null;
	    taxation = new SalariedPeople(1500000);
	    System.out.println("The total tax for this salaries person is " + taxation.calculateTax());
	    taxation = new BusinessPeople(27500000, 17500000, 5100000);
	    System.out.println("The total tax for this business person is " + taxation.calculateTax());
	  }
}


