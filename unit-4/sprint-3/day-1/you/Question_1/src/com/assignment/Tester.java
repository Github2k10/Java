package com.assignment;

abstract class Science{
	  private static int counter;
	  private String registrationNumber;
	  private float physicsTheoryMarks;
	  private float physicsPracticalMarks;
	  private float chemistryTheoryMarks;
	  private float chemistryPracticalMarks;

	  static{
	    counter = 0;
	  }


	  public Science(String registrationPrefix, float physicsTheoryMarks, float physicsPracticalMarks, float chemistryTheoryMarks, float chemistryPracticalMarks){
		counter++;
		this.registrationNumber = registrationNumber + counter;
		this.physicsTheoryMarks = physicsTheoryMarks;
		this.physicsPracticalMarks = physicsPracticalMarks;
		this.chemistryTheoryMarks = chemistryTheoryMarks;
		this.chemistryPracticalMarks = chemistryPracticalMarks;
	}


	public static int getCounter() {
		return counter;
	}


	public static void setCounter(int counter) {
		Science.counter = counter;
	}


	public String getRegistrationNumber() {
		return registrationNumber;
	}


	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}


	public float getPhysicsTheoryMarks() {
		return physicsTheoryMarks;
	}


	public void setPhysicsTheoryMarks(float physicsTheoryMarks) {
		this.physicsTheoryMarks = physicsTheoryMarks;
	}


	public float getPhysicsPracticalMarks() {
		return physicsPracticalMarks;
	}


	public void setPhysicsPracticalMarks(float physicsPracticalMarks) {
		this.physicsPracticalMarks = physicsPracticalMarks;
	}


	public float getChemistryTheoryMarks() {
		return chemistryTheoryMarks;
	}


	public void setChemistryTheoryMarks(float chemistryTheoryMarks) {
		this.chemistryTheoryMarks = chemistryTheoryMarks;
	}


	public float getChemistryPracticalMarks() {
		return chemistryPracticalMarks;
	}


	public void setChemistryPracticalMarks(float chemistryPracticalMarks) {
		this.chemistryPracticalMarks = chemistryPracticalMarks;
	}


	abstract public double getPercentage();
}

class ScienceMathsStudent extends Science{
	  final static String MATHS_PREFIX = "SM";
	  private float mathsMarks;



	  public ScienceMathsStudent(float mathsMarks, float physicsTheoryMarks, float physicsPracticalMarks, float chemistryTheoryMarks, float chemistryPracticalMarks){
		super(MATHS_PREFIX, physicsTheoryMarks, physicsPracticalMarks, chemistryTheoryMarks, chemistryPracticalMarks);
		this.mathsMarks = mathsMarks;
	}



	  public float getMathsMarks() {
		return mathsMarks;
	}



	public void setMathsMarks(float mathsMarks) {
		this.mathsMarks = mathsMarks;
	}



	public static String getMathsPrefix() {
		return MATHS_PREFIX;
	}



	@Override
	  public double getPercentage(){
	    //write code here to return percentage up to two decimal places
		float sum = getPhysicsTheoryMarks() + getPhysicsPracticalMarks() + getChemistryTheoryMarks() + getChemistryPracticalMarks() + mathsMarks;
		double res = Math.round(sum*100/3);
		return res/100;
	  }
}

class ScienceBioStudent extends Science{
	  final static String BIO_PREFIX = "SB";
	  private float bioTheoryMarks;
	  private float bioPracticalMarks;


	  public ScienceBioStudent(float bioTheoryMarks, float bioPracticalMarks, float physicsTheoryMarks, float physicsPracticalMarks, float chemistryTheoryMarks, float chemistryPracticalMarks){
		super(BIO_PREFIX, physicsTheoryMarks, physicsPracticalMarks, chemistryTheoryMarks, chemistryPracticalMarks);
		this.bioPracticalMarks = bioPracticalMarks;
		this.bioTheoryMarks = bioTheoryMarks;
	}


	@Override
	  public double getPercentage(){
	    //write code here to return percentage up to two decimal places
		float sum = getPhysicsTheoryMarks() + getPhysicsPracticalMarks() + getChemistryTheoryMarks() + getChemistryPracticalMarks() + bioTheoryMarks + bioPracticalMarks;
		double res = Math.round(sum*100/3);
		return res/100;
	  }
}
	

class Tester{
	  public static void main(String args[]){
	    Science sc = null;
	    sc = new ScienceMathsStudent(78, 55, 24, 58, 23);
	    System.out.println("The total marks of student whose registration number " + sc.getRegistrationNumber() + " is " + sc.getPercentage());
	    sc = new ScienceBioStudent(52, 23, 55, 24, 58, 23);
	    System.out.println("The total marks of student whose registration number " + sc.getRegistrationNumber() + " is " + sc.getPercentage());
	    sc = new ScienceBioStudent(49, 22, 54, 23, 59, 54);
	    System.out.println("The total marks of student whose registration number " + sc.getRegistrationNumber() + " is " + sc.getPercentage());
	    sc = new ScienceMathsStudent(83, 52, 23, 55, 26);
	    System.out.println("The total marks of student whose registration number " + sc.getRegistrationNumber() + " is " + sc.getPercentage());
	  }
}


