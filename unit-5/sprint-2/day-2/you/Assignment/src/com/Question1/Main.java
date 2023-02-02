package com.Question1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyCallable implements Callable<Object>{
	int num;
	
	public MyCallable(int num) {
		this.num = num;
	}
	
	@Override
	public Object call() {
		return num % 2 == 0 ? "Even Number" : "Odd Number";
	}
}

public class Main {

	public static void main(String[] args) {
		MyCallable[] task = {
			new MyCallable(1),	
			new MyCallable(2),	
			new MyCallable(3),	
			new MyCallable(4),	
			new MyCallable(5),	
			new MyCallable(6),	
		};
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		for(MyCallable t : task) {
			Future<Object> f = service.submit(t);
			try {
				System.out.println(f.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		service.shutdown();
		

	}

}
