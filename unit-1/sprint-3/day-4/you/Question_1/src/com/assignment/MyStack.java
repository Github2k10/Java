package com.assignment;

class MyStack implements Stack{
	  private int stack[];
	  private int top;
	  final static int MAX_SIZE = 5;
	  MyStack(){
	    stack = new int[MAX_SIZE];
	    top = -1;
	  }
	  
	  public String toString(){
	    return Stack.displayStackElements(stack);
	  }
	  
	  public void push(int element) throws OverflowException{
		  top += 1;
		  stack[top] = element;
	  }
	  
	  public int pop() throws UnderflowException{
		  int ele = stack[top];
		  stack[top] = 0;
		  top -= 1;
		  return ele;
	  }
	  
	  
	  public int peek() throws UnderflowException{
		  return stack[top];
	  }
}