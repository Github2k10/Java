package assignment.com.Question2;

class A{

	public static void funA(){
	
		for(int i=1;i <=10; i++){
	
			System.out.println(Thread.currentThread().getName() + " is running");
	
		}
	
	}

	public void funB(){
	
		for(int i=20;i <=30; i++){
	
			System.out.println(Thread.currentThread().getName() + " is running");
	
		}
	
	}

}

public class Main {
	public static void main(String args[]) {
		Runnable t1 = A::funA;
		Thread th1 = new Thread(t1);
		Runnable t2 = new A()::funB;
		Thread th2 = new Thread(t2);
		
		th1.setName("Dhoni thread");
		th2.setName("Kohli thread");
		
		th1.start();
		th2.start();
	}
}
