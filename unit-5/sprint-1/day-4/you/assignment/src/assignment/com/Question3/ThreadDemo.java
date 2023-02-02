package assignment.com.Question3;

public class ThreadDemo implements Runnable{
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++)
			System.out.println(Thread.currentThread().getName() + " is running Thread");
	}
}

class Main{
	public static void main(String args[]) {
		ThreadDemo t1 = new ThreadDemo();
		Thread th1 = new Thread(t1);
	    Thread th2 = new Thread(t1);
	    
	    th1.start();
	    th2.start();
	}
}
