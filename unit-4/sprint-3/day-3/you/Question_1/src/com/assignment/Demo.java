package com.assignment;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Objects;
import java.util.Scanner;

class TaxPayer{
  private String PAN;
  private long adhaarNumber;
  private String name;
  
	public TaxPayer(String pAN, long adhaarNumber, String name) {
		PAN = pAN;
		this.adhaarNumber = adhaarNumber;
		this.name = name;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public long getAdhaarNumber() {
		return adhaarNumber;
	}

	public void setAdhaarNumber(long adhaarNumber) {
		this.adhaarNumber = adhaarNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(PAN, adhaarNumber, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxPayer other = (TaxPayer) obj;
		return Objects.equals(PAN, other.PAN) && adhaarNumber == other.adhaarNumber && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "TaxPayer [PAN=" + PAN + ", adhaarNumber=" + adhaarNumber + ", name=" + name + "]";
	}

	
}

class Demo{
  
  static boolean checkPAN(String PAN) {
    //write code to validate the PAN number using regular expression
	  
	  Pattern p;
	  Matcher m;
	  
	  p = Pattern.compile("[A-Z]{5}\\d{4}[A-Z]{1}");
	  m = p.matcher(PAN);
	  
	  return m.matches();
	  
  }

  static boolean checkAdhaar(long adhaarNumber) {
    //write code to validate the adhaarNumber number using regular expression
	  
	  Pattern p;
	  Matcher m;
	  
	  String num = adhaarNumber + "";
	  
	  p = Pattern.compile("[0-9]{12}");
	  m = p.matcher(num);
	  
	  return m.matches();
  }


  static boolean addTaxPayer(TaxPayer tpArr[], TaxPayer newTP, int c) {
    //Write code to add newTP to tpArr if taxpayers with newTP's PAN and adhaar is not here
	  boolean flag = true;
	  
	  for(int i= 0; i < c; i++) {
		  if(tpArr[i].equals(newTP)) {
			  flag = false;
		  }
	  }
	  
	  if(flag) {
		  tpArr[c] = newTP;
		  return true;
	  } else {
		  return false;
	  }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Create an array of objects
    TaxPayer tpArr[] = new TaxPayer[5];
    int totalTaxPayers = 0;

    while(true) {
      System.out.print("Please enter name, PAN and adhaar Number ");
      String name = sc.next();
      String panNumber = sc.next();
      long adhaarNumber = sc.nextLong();
      if(checkPAN(panNumber) && checkAdhaar(adhaarNumber)) {
        //you are here means PAN and adhaar are in correct format
        if(addTaxPayer(tpArr, new TaxPayer(panNumber, adhaarNumber, name), totalTaxPayers)) {
          //you are here means tax payer has added to the array
          System.out.println("Yahoo! Tax payer added\n");
          if(++totalTaxPayers == tpArr.length)
            //the array is full so better to break the loop
            break;
        }else {
          System.out.println("Tax Payer with this PAN & adhaar already exists\n");
        }
      }else {
        System.out.println("Enter correct PAN & adhaar number\n");
      }
    }

    System.out.println("Details of tax payers are as follow-");
    for(TaxPayer tp: tpArr)
      System.out.println(tp);
    sc.close();
  }
}
