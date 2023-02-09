package com.assignment;

class P{
	P(){
		System.out.println("P");
	}
	
	P(int i){
		System.out.println("R");
	}
}

class Q extends P{
	Q(){
		System.out.println("Q");
	}
	
	Q(int i){
		System.out.println("S");
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q q1 = new Q();
		Q q2 = new Q(10);
		
	}

}
