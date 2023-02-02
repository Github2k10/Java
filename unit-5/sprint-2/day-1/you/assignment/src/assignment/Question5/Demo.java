package assignment.Question5;

class A{

	public static synchronized void sayHello(String name){

		System.out.print("Welcome : ");
	
		try{
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		System.out.println(name);
		
	}

}

public class Demo implements Runnable{
	A a;
	String str;
	
	Demo(A a, String str){
		this.str = str;
		this.a = a;
	}
	
	@Override
	public void run() {
		a.sayHello(str);
	}

	public static void main(String[] args) {
		A o = new A();
		
		Demo t1 = new Demo(o, "Hello");
		Demo t2 = new Demo(o, "World");
		Demo t3 = new Demo(o, "Developers");
		
		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);
		Thread th3 = new Thread(t3);
		
		th1.start();
		th2.start();
		th3.start();
		
		try {
			th1.join();
			th2.join();
			th3.join();
		} catch(Exception ex) {
			
		}

	}

}
