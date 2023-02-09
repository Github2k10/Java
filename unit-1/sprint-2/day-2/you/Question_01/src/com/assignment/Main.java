package com.assignment;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum1 = 0;
		int sum2 = 0;
		
		System.out.print("Enter Size of matrix: ");
		int n = sc.nextInt();
		
		System.out.println("Enter elements of matrix: ");
		int arr[][] = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			sum1 += arr[i][i];
			sum2 += arr[i][n-i-1];
//			System.out.println(arr[i][i] + " " + arr[i][n-1-i]);
		}
		System.out.print("The difference of sum of diagonal is ");
		if(sum1 - sum2 > 0) {
			System.out.println(sum1 - sum2);
		} else {
			System.out.println(sum2 - sum1);
		}
	}

}
