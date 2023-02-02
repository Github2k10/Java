package assignment.com.Question4;

public class Demo extends Thread{
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running Thread");
	}
	
	public static void main(String args[]) {
		Demo th1 = new Demo();
		Demo th2 = new Demo();
		Demo th3 = new Demo();
		
		th1.start();
		th2.start();
		th3.start();
	}
}
