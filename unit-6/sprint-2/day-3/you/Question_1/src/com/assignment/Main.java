package com.assignment;

class FeeExpenses{
	 //write code here
	private double tuitionFee;
	private double serviceTax;
	
	public FeeExpenses(double d, double e) {
		super();
		this.tuitionFee = d;
		this.serviceTax = e;
	}

	public double getTotalFee() {
		return tuitionFee + tuitionFee * serviceTax/100.0;
	}
	
	public double priceCost() {
		return tuitionFee;
	}
	
}

class FeeWithCess extends FeeExpenses{
	  //write code here
	private double cess;

	public FeeWithCess(double d, double e, double cess) {
		super(d, e);
		this.cess = cess;
	}
	
	@Override
	public double getTotalFee() {
		return super.getTotalFee() + (priceCost() * cess)/100.0;
		
	}
}

	class Main{
	  public static void main(String args[]){
	    FeeExpenses fe = new FeeExpenses(45000.0, 10.0);
	    System.out.println("Total fee is " + fe.getTotalFee());
	    FeeWithCess fc = new FeeWithCess(50000.0, 11.5, 2.5);
	    System.out.println("Total fee is " + fc.getTotalFee());
	  }
	}

