package com.Question1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Product {
	private int prod_Id;
	private String prod_name;
	private int prod_price;
	private int prod_quantity;
	
	
	public Product(int prod_Id, String prod_name, int prod_price, int prod_quantity) {
		this.prod_Id = prod_Id;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_quantity = prod_quantity;
	}
	public int getProd_Id() {
		return prod_Id;
	}
	public void setProd_Id(int prod_Id) {
		this.prod_Id = prod_Id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public int getProd_price() {
		return prod_price;
	}
	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	public int getProd_quantity() {
		return prod_quantity;
	}
	public void setProd_quantity(int prod_quantity) {
		this.prod_quantity = prod_quantity;
	}
	@Override
	public String toString() {
		return "Product Id = " + prod_Id + ", Product Name = " + prod_name + ", Product Price = " + prod_price
				+ ", Product Quantity = " + prod_quantity;
	}
	
	
	
}


class Main{
	public static void main(String args[]) {
		//What do you mean by Functional programming and Functional interface?
		System.out.println("Functional Programming : It is a paradigm that emphasizes immutability and \n the goal is  to write or create programs that are simple, predictable, and easy to understand and maintain.\n\n");
		System.out.println("Functional Interface : An interface that has only one abstract method.\nThe idea behind functional interface is to allow the creation of anonyous inner class or implement this interface.\n @FunctionalInterface annotatioin, which is used to indicate that an infterface is a funtioal interface.\n\n");
		
		List<Product> list = new ArrayList<>();
		
		list.add(new Product(1, "Phone", 19999, 3));
		list.add(new Product(2, "Book",  399, 5));
		list.add(new Product(3, "Fan",   999, 7));
		list.add(new Product(4, "Laptop", 49999, 2));
		list.add(new Product(5, "Cover", 299, 4));
		list.add(new Product(6, "Pen",   99, 6));
		list.add(new Product(7, "Shoes", 999, 1));
		list.add(new Product(8, "Table", 999, 8));
		
		Predicate<Product> p = n -> n.getProd_quantity() < 5;
		Consumer<Product>  c = n -> System.out.println(n.toString());
		Supplier<Product>  s = () -> new Product(1, "Phone", 19999, 3);
		Function<String, Product> f = n -> {
			String[] prodDetail = n.split(",");
			
			return new Product(Integer.parseInt(prodDetail[0]), prodDetail[1], Integer.parseInt(prodDetail[2]), Integer.parseInt(prodDetail[3]));
		};
		
		System.out.println("Original LIst: ");
		for(Product prod : list) {
			c.accept(prod);
		}
		System.out.println();
		
		System.out.println("After using Predicate function:");
		list.removeIf(p);
		for(Product prod : list) {
			c.accept(prod);
		}
		System.out.println();
		
		System.out.println("After using Supplier function");
		list.add(s.get());
		for(Product prod : list) {
			c.accept(prod);
		}
		System.out.println();
		
		System.out.println("After using Function :");
		list.add(f.apply("9,chair,500,5"));
		for(Product prod : list) {
			c.accept(prod);
		}
	
	}
}
