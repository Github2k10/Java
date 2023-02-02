package com.assignment.Question2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Product {
	private int productId;
	private String productName;
	private int price;
	private int quantity;
	
	public Product(int productId, String productName, int price, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}


class Demo{
	public static void main(String[] args) {
		List<Product> list1 = new ArrayList<>();
		
		list1.add(new Product(1, "Headphone", 999, 12));
		list1.add(new Product(2, "Mobil", 19999, 5));
		list1.add(new Product(3, "laptop", 59999, 7));
		list1.add(new Product(4, "Moter Bike", 199999, 15));
		list1.add(new Product(5, "Phone Cover", 299, 17));
		

		List<Product> list2 = new ArrayList<>(list1);
		
		list2.removeIf(l -> l.getQuantity() < 10);
		
		Collections.sort(list2, new Comparator<Product>() {
			public int compare(Product p1, Product p2) {
				return p1.getPrice() - p2.getPrice();
			}
		});
		
		for(Product l : list2) {
			System.out.println(l.getProductName() + " " + l.getPrice());
		}
		
	}
}