package com.Practice;

import java.util.Stack;

public class StackWithMin {
	public Stack<Integer> stk;
	public Stack<Integer> minStk;
	
	public StackWithMin(){
		stk=new Stack<Integer>();
		minStk=new Stack<Integer>();
	}
	
	public void push(int val){
		stk.push(val);
		if(minStk.isEmpty())
			minStk.push(val);
		else if(val<=minStk.peek())
			minStk.push(val);
	}
	
	public int pop() throws Exception{
		if(stk.isEmpty())
			throw new Exception("stack is empty!");
		int val=stk.pop();
		if(val==minStk.peek())
			minStk.pop();
		return val;
	}
	
	public int getMin() throws Exception{
		if(!minStk.isEmpty())
			return minStk.peek();
		else
			throw new Exception("stack is empty~");
	}
}
