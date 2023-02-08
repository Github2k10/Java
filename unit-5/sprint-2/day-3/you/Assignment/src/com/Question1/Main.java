package com.Question1;

public class Main {

	public static void main(String[] args) {
		/*
		 * Deadlock in Java is a part of multithreading. Deadlock can occur in a
		 * situation when a thread is waiting for an object lock, that is acquired by
		 * another thread and second thread is waiting for an object lock that is
		 * acquired by first thread. Since, both threads are waiting for each other to
		 * release the lock, the condition is called deadlock.
		 * 
		 * A deadlock may also include more than two threads. The reason is that it can
		 * be difficult to detect a deadlock. Here is an example in which four threads
		 * have deadlocked:
		 * 
		 * Thread 1 locks A, waits for B
		 * Thread 2 locks B, waits for C
		 * Thread 3 locks C, waits for D
		 * Thread 4 locks D, waits for A
		 * 
		 * Thread 1 waits for thread 2, thread 2 waits for thread 3, thread 3 waits for
		 * thread 4, and thread 4 waits for thread 1.
		 */

	}

}
