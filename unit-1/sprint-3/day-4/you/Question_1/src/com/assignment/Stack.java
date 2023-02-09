package com.assignment;

interface Stack{
	  void push(int element) throws OverflowException;
	  int pop() throws UnderflowException;
	  int peek() throws UnderflowException;
	  static String displayStackElements(int stack[]){
	    //write code to convert the stack elements to comma separate String sequence from index 0 to top
		  StringBuilder str = new StringBuilder();
		
		  for(int i = 0; i < stack.length - 1; i++) {
			  str.append(stack[i]);
			  str.append(", ");
		  }
		  str.append(stack[stack.length - 1]);
		  
		  return str.toString();
	  }
	}
