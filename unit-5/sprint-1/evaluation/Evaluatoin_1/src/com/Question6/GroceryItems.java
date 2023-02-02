package com.Question6;


import java.util.Comparator;
import java.util.TreeSet;

public class GroceryItems implements Comparable<GroceryItems> {
    private double price;
    private String name;
    private double usedFrequency;
    
    public GroceryItems(double price, String name, double usedFrequency) {
        this.price = price;
        this.name = name;
        this.usedFrequency = usedFrequency;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getName() {
        return name;
    }
    
    public double getUsedFrequency() {
        return usedFrequency;
    }
    
    
    
    
    @Override
	public String toString() {
		return "GroceryItems [price=" + price + ", name=" + name + ", usedFrequency=" + usedFrequency + "]";
	}

	@Override
    public int compareTo(GroceryItems o) {
        int result = Double.compare(o.usedFrequency, usedFrequency);
        if (result == 0) {
            result = Double.compare(o.price, price);
            if (result == 0) {
                result = name.compareTo(o.name);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        TreeSet<GroceryItems> naturalOrder = new TreeSet<>();
        naturalOrder.add(new GroceryItems(10.0, "Apple", 1.0));
        naturalOrder.add(new GroceryItems(15.0, "Banana", 5.0));
        naturalOrder.add(new GroceryItems(5.0, "Carrot", 7.0));
        naturalOrder.add(new GroceryItems(12.0, "Donut", 2.0));
        naturalOrder.add(new GroceryItems(7.0, "Egg", 3.0));
        
        for(GroceryItems s : naturalOrder) {
        	System.out.println(s.toString());
        }
        
        System.out.println();
        
        TreeSet<GroceryItems> customOrder = new TreeSet<>(
            Comparator.comparing(GroceryItems::getPrice)
                      .thenComparing(GroceryItems::getUsedFrequency)
                      .thenComparing(GroceryItems::getName));
        customOrder.addAll(naturalOrder);
        
        for(GroceryItems s : customOrder) {
        	System.out.println(s.toString());
        }
    }
}
