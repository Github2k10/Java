package com.assignment;

import java.util.Objects;

class EPFOAccount {
	  //write code here
	private String accountNo;
	private int balance;
	
	EPFOAccount(String accountNo, int balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "(Account number: " +  accountNo +  " Balance: " + balance + "/-)";
	}
	
}

class Employee{
	  //write code here
	private String employeeId;
	private String name;
	private int salary;
	private EPFOAccount epfoAccount;
	private Class<? extends Object> getClass;
	
	public Employee(String employeeId, String name, int salary, EPFOAccount epfoAccount) {
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.epfoAccount = epfoAccount;
	}

	@Override
	public int hashCode() {
		return epfoAccount.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		if(this.getClass != obj.getClass())
			return false;
		
		Employee other = (Employee) obj;
		return employeeId == other.employeeId && Objects.equals(epfoAccount, other.epfoAccount)
				&& Objects.equals(name, other.name) && salary == other.salary;
	}

	@Override
	public String toString() {
		return "Employee Id: " + employeeId + ", Name: " + name + ", Salary: " + salary + ", EPFO Account details: "
				+ epfoAccount;
	}
	
}

	class Main{
	  static public void main(String args[]){
	    EPFOAccount e1 = new EPFOAccount("EPFO001", 25000);
	    EPFOAccount e2 = new EPFOAccount("EPFO002", 35000);

	    Employee emp1 = new Employee ("E001", "Anuj", 45000, e1);
	    Employee emp2 = new Employee ("E002", "Jayesh", 38000, e2);
	    Employee emp3 = new Employee ("E001", "Rajesh", 35500, e2);
	    
	    System.out.println(emp1.equals(emp2));
	    System.out.println(emp2.equals(emp3));
	    System.out.println(emp3.equals(emp1));
	    System.out.println();

	    System.out.println(emp1.hashCode() == emp2.hashCode());
	    System.out.println(emp2.hashCode() == emp3.hashCode());
	    System.out.println(emp3.hashCode() == emp1.hashCode());
	    System.out.println();

	    System.out.println(emp1);
	    System.out.println(emp2);
	    System.out.println(emp3);
	  }
	}