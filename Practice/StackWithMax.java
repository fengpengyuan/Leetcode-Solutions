package com.Practice;

import java.util.Stack;

public class StackWithMax extends Stack<Integer>{
	Stack<Integer> stk;
	
	public StackWithMax(){
		stk=new Stack<Integer>();
	}
	
	public int max(){
		if(stk.isEmpty())
			return Integer.MIN_VALUE;
		return stk.peek();
	}
	
	public void push(int val){
		if(val>max())
			stk.push(val);
		super.push(val);
	}
	
	public Integer pop(){
		int t=super.pop();
		if(t==max())
			stk.pop();
		return t;
	}
}
