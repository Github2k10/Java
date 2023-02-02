package assignment.Question2;

class Even implements Runnable{
	@Override
	public void run() {
		
		System.out.println("Even Numbers between 1 to 20 : ");
		for(int i = 1; i <= 30; i++)
			if(i % 2 == 0)
				System.out.print(i + " ");
		
		System.out.println();
	}
}


class Odd implements Runnable{
	@Override
	public void run() {
		
		
		System.out.println("Odd Numbers between 1 to 20 : ");
		for(int i = 1; i <= 30; i++)
			if(i % 2 == 1)
				System.out.print(i + " ");
		
		System.out.println();
	}
	
}

public class Main {
	
	public static void main(String[] args) {
		Even t1 = new Even();
		Odd t2 = new Odd();
		
		Thread e1 = new Thread(t1);
		Thread o1 = new Thread(t2);
		
		e1.start();
		try {
			e1.join();
		}catch(Exception ex) {
			
		}
		
		o1.start();
		try {
			o1.join();
		}catch(Exception ex) {
			
		}
		
		
		System.out.println("Main");
	}

}
