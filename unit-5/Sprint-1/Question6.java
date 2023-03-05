package day1;

import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

class GroceryItems implements Comparable<GroceryItems>{
	private double price;
	private String name;
	private double usedFrequerncy;
	
	public GroceryItems() {}
	
	public GroceryItems(double price, String name, double usedFrequerncy) {
		this.price = price;
		this.name = name;
		this.usedFrequerncy = usedFrequerncy;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUsedFrequerncy() {
		return usedFrequerncy;
	}

	public void setUsedFrequerncy(double usedFrequerncy) {
		this.usedFrequerncy = usedFrequerncy;
	}

	@Override
	public String toString() {
		return "GroceryItems [price=" + price + ", name=" + name + ", usedFrequerncy=" + usedFrequerncy + "]";
	}

	@Override
	public int compareTo(GroceryItems o) {
		int result = Double.compare(usedFrequerncy, o.getUsedFrequerncy());
		
		if(result == 0) {
			result = Double.compare(price, o.getPrice());
			
			if(result == 0) {
				result = name.compareTo(o.getName());
			}
		}
		
		return result;
	}
}

public class Question6 {

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
        
        Comparator<GroceryItems> comparator = Comparator.comparing(GroceryItems::getPrice)
        									  .thenComparing(GroceryItems::getUsedFrequerncy)
        									  .thenComparing(GroceryItems::getName);
        
        TreeSet<GroceryItems> newOrder = new TreeSet<>(comparator);
        newOrder.addAll(naturalOrder);
        
        newOrder.forEach(s -> System.out.println(s.toString()));
	}
	

}
