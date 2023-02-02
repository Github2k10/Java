package assignment.com.Question5;

public class Demo implements Runnable{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running Thread");
	}
	
	public static void main(String args[]) {
		Demo t1 = new Demo();
		Demo t2 = new Demo();
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		
		th1.start();
		th2.start();
	}
}
