package assignment.com.Question1;

class Salman implements Runnable{
	@Override
	public void run() {
		int sum = 0;
		
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		
		System.out.println("Sum of first 10 no. = " + sum);
	}
}

class Hritik implements Runnable{
	@Override
	public void run() {
		int sum = 1;
		
		for(int i = 1; i <= 10; i++) {
			sum *= i;
		}
		
		System.out.println("Multiply of first 10 no. = " + sum);
	}
}

public class Akshay implements Runnable{ 
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++)
			System.out.println("Akshy " + i);
	}
	
	public static void main(String args[]) {
		Salman t1 = new Salman();
		Thread th1 = new Thread(t1);
		Hritik t2 = new Hritik();
		Thread th2 = new Thread(t2);
		Akshay t3  = new Akshay();
		Thread th3 = new Thread(t3);
		
		
		th1.start();
		th2.start();
		th3.start();
	}
}