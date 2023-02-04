package com.assignment;

public class Toy {
	final String toyNumber;
	String toyName;
	Double price;
	String category;
	
	public Toy(String toyNumber, String toyName, Double price, String category) {
		this.toyNumber = toyNumber;
		this.toyName = toyName;
		this.price = price;
		this.category = category;
	}

	public String getToyName() {
		return toyName;
	}

	public void setToyName(String toyName) {
		this.toyName = toyName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getToyNumber() {
		return toyNumber;
	}

	@Override
	public String toString() {
		return "Toy [toyNumber=" + toyNumber + ", toyName=" + toyName + ", price=" + price + ", category=" + category
				+ "]";
	}
	
	
	
}
