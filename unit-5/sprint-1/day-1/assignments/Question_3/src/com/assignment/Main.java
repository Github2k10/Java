package com.assignment;

import java.util.ArrayList;
import java.util.Collections;

class Product{
	int productId;
	int price;
	int quantity;
	String productName;
	
	public Product(int productId, int price, int quantity, String productName) {
		this.price = price;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
	}

	int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return "ProductId = " + productId + ", price = " + price + ", quantity = " + quantity + ", productName = "
				+ productName;
	}
	
	
}

public class Main {
	public static void main(String args[]) {
		ArrayList<Product> arr = new ArrayList<>();
		
		arr.add(new Product(1, 100, 2, "pro1"));
		arr.add(new Product(2, 400, 4, "pro2"));
		arr.add(new Product(3, 300, 1, "pro3"));
		arr.add(new Product(4, 800, 3, "pro4"));
		arr.add(new Product(5, 500, 2, "pro5"));
		
		for(Product p : arr) {
			System.out.println(p.toString());
		}
		
		System.out.println("\n\n");
		
		Collections.sort(arr, (p1, p2) -> p1.getPrice() > p2.getPrice() ? -1 : +1);
		
		for(Product p : arr) {
			System.out.println(p.toString());
		}
	}
}
