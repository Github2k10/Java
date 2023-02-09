package com.assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Entry{
	String particular;
	double amount;
	LocalDate date;
	char category;
	
	public Entry(String particular, double amount, LocalDate date, char category) {
		this.particular = particular;
		this.amount = amount;
		this.date = date;
		this.category = category;
	}
	
	public String getParticular() {
		return particular;
	}
	public void setParticular(String particular) {
		this.particular = particular;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public char getCategory() {
		return category;
	}
	public void setCategory(char category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if(category == 'E') {
			return "Entry [date = " + date + ", amount = -" + amount + ", particular = " + particular
					+ "]";
		} else 
		return "Entry [date=" + date + ", amount=" + amount + ", particular=" + particular
				+ "]";
	}	
}


class SortByDate implements Comparator<Entry>{

	@Override
	public int compare(Entry a, Entry b) {
		// TODO Auto-generated method stub
		return a.getDate().compareTo(b.getDate());
	}
	
}


class SortByAmount implements Comparator<Entry> {

	@Override
	public int compare(Entry o1, Entry o2) {
		// TODO Auto-generated method stub
		if(o1.getAmount() > o2.getAmount()) {
			return 1;
		} else if(o1.getAmount() < o2.getAmount()) {
			return -1;
		} else {
			return 0;
		}
	}
	
}


class Ledger{
	List<Entry> expenses;
	List<Entry> income;
	
	
	public Ledger() {
		this.expenses = new ArrayList<Entry>();
		this.income = new ArrayList<Entry>();
	}
	
	void addExpense(Entry expeEntry) {
		if(expeEntry != null)
			expenses.add(expeEntry);
	}
	
	void addIncome(Entry incomeEntry) {
		if(incomeEntry != null)
			income.add(incomeEntry);
	}
	
	double getTotalExpenses() {
		double total = 0.0;
		
//		for(int i = 0; i < expenses.size(); i++) {
//			total += expenses.get(i).amount;
//		}
		
		for(Entry entry: expenses) {
			total += entry.getAmount();
		}
		
		return total;
	}
	
	double getTotalIncome() {
		double total = 0;
		
//		for(int i= 0; i < income.size(); i++) {
//			total += income.get(i).amount;
//		}
		
		for(Entry entry: income) {
			total += entry.getAmount();
		}
		
		return total;
	}
	
	 String getRemarkOnFinHealth() {
		 String remark;
		 
		 double total = (getTotalExpenses()/getTotalIncome())*100.0;
		 
		 if(total <= 70) {
			 remark = "Your financial health is good";
		 } else if( total <= getTotalIncome()) {
			 remark = "You need to increase the saving";
		 } else {
			 remark = "You need to manage expenses well also try to increase income";
		 }
		 
		 return remark;
	 }
	 
	 List<Entry> getHighestLowestExpenseIncomeEntries(){
		 List<Entry> arr = new ArrayList<Entry>();
		 
		 arr.add(Collections.max(expenses, new SortByAmount()));
		 arr.add(Collections.min(expenses, new SortByAmount()));
		 
		 arr.add(Collections.max(income, new SortByAmount()));
		 arr.add(Collections.min(income, new SortByAmount()));
		 
//		 double min = Double.MAX_VALUE;
//		 double max = Double.MIN_VALUE;
//		 
//		 for(int i = 0; i < expenses.size(); i++) {
//			 if(max < expenses.get(i).amount) {
//				 max = expenses.get(i).amount;
//				 arr.add(0, expenses.get(i));
//			 }
//			 
//			 if(min > expenses.get(i).amount) {
//				 min = expenses.get(i).amount;
//				 arr.add(1, expenses.get(i));
//			 }
//		 }
		 
//		 min = Double.MAX_VALUE;
//		 max = Double.MIN_VALUE;
//		 
//		 for(int i = 0; i < income.size(); i++) {
//			 if(max < income.get(i).amount) {
//				 max = income.get(i).amount;
//				 arr.add(2, income.get(i));
//			 }
//			 
//			 if(min > income.get(i).amount) {
//				 min = income.get(i).amount;
//				 arr.add(3, income.get(i));
//			 }
//		 }
		 
		 return arr;
	 }
	 
	 List<Entry> getIncomeByDateRange(LocalDate startDate, LocalDate endDate){
		 Collections.sort(income, new SortByDate());
		 List<Entry> incomeList = new ArrayList<>();
		 
		 for(Entry entry: income) {
			 LocalDate incomeDate = entry.getDate();
			 boolean isInRange = incomeDate.isAfter(startDate.minusDays(1)) && incomeDate.isBefore(endDate.plusDays(1));
			 
			 if(isInRange) {	
				 incomeList.add(entry);
			 }
		 }
		 
		 return incomeList;
	 }
	 
	 void deleteExpensesExcludingAmountRange(double from, double to) {
		 for(int i = 0; i < expenses.size(); i++) {
			 if(expenses.get(i).getAmount() < from || expenses.get(i).getAmount() > to) {
				 int index = i;
				 expenses.remove(i);
				 i = index - 1;
			 }
		 }
	 }

	@Override
	public String toString() {
		List<Entry> list = new ArrayList<>();
		
		list.addAll(expenses);
		list.addAll(income);
		
		Collections.sort(list, new SortByDate());
		
		StringBuilder sb = new StringBuilder();
		
		for(Entry entry : list) {
			sb.append(entry + "\n");
		}
		
		sb.append("Grand Total \t\t" + (getTotalIncome() - getTotalExpenses()));
		
		return sb.toString();
	}
	 
	 
}

//Do not touch this class
public class MainLedger {
  public static void main(String[] args) {
    //Entries of expenses
    Entry expenseOne = new Entry("Grocery", 4000, LocalDate.parse("2022-12-01"), 'E');
    Entry expenseTwo = new Entry("Clothing", 4500, LocalDate.parse("2022-12-04"), 'E');
    Entry expenseThree = new Entry("Installment", 4000, LocalDate.parse("2022-12-10"), 'E');
    Entry expenseFour = new Entry("Education", 6500, LocalDate.parse("2022-12-12"), 'E');
    Entry expenseFive = new Entry("Fuel", 2000, LocalDate.parse("2022-12-13"), 'E');
    Entry expenseSix = new Entry("Bills", 8000, LocalDate.parse("2022-12-15"), 'E');
    Entry expenseSeven = new Entry("serventSalary", 7500, LocalDate.parse("2022-12-20"), 'E');
    Entry expenseEight = new Entry("Recharges", 1000, LocalDate.parse("2022-12-22"), 'E');
    Entry expenseNine = new Entry("Furniture", 8000, LocalDate.parse("2022-12-25"), 'E');
    Entry expenseTen = new Entry("Repairing", 2000, LocalDate.parse("2022-12-27"), 'E');

    //Create object of Ledger
    Ledger ledger = new Ledger();
    //add all expenses Entries
    ledger.addExpense(expenseOne);
    ledger.addExpense(expenseTwo);
    ledger.addExpense(expenseThree);
    ledger.addExpense(expenseFour);
    ledger.addExpense(expenseFive);
    ledger.addExpense(expenseSix);
    ledger.addExpense(expenseSeven);
    ledger.addExpense(expenseEight);
    ledger.addExpense(expenseNine);
    ledger.addExpense(expenseTen);
    
    //Entries of income
    Entry incomeOne = new Entry("Salary", 52000, LocalDate.parse("2022-12-01"), 'I');
    Entry incomeTwo = new Entry("Rent", 7000, LocalDate.parse("2022-12-05"), 'I');
    Entry incomeThree = new Entry("Interest", 2000, LocalDate.parse("2022-12-25"), 'I');
    Entry incomeFour = new Entry("gift", 3000, LocalDate.parse("2022-12-27"), 'I');
    Entry incomeFive = new Entry("Bonus", 15000, LocalDate.parse("2022-12-30"), 'I');
    
    //add all income Entries
    ledger.addIncome(incomeOne);
    ledger.addIncome(incomeTwo);
    ledger.addIncome(incomeThree);
    ledger.addIncome(incomeFour);
    ledger.addIncome(incomeFive);
    
    double totalIncome = ledger.getTotalIncome();
    double totalExpense = ledger.getTotalExpenses();
    System.out.println("Total Income: " + totalIncome);
    System.out.println("Total Expenses: " + totalExpense);
    
    System.out.println();
    
    System.out.println(ledger.getRemarkOnFinHealth());
    
    System.out.println();
    
    System.out.println(ledger);
    
    System.out.println();
    
    List<Entry> list = ledger.getHighestLowestExpenseIncomeEntries();
    System.out.println("The Highest expense entry is " + list.get(0));
    System.out.println("The Lowest expense entry is " + list.get(1));
    System.out.println("The Highest income entry is " + list.get(2));
    System.out.println("The Lowest income entry is " + list.get(3));
    
    System.out.println();
    
    list = ledger.getIncomeByDateRange(LocalDate.parse("2022-12-01"), LocalDate.parse("2022-12-15"));
    for(Entry entry: list) {
      System.out.println(entry.getDate() + "\t\t-" + entry.getAmount() + "\t\t" + entry.getParticular());
    }
    
    ledger.deleteExpensesExcludingAmountRange(4500, 7500);
    System.out.println("The updated total expense is " + ledger.getTotalExpenses());
  }
}