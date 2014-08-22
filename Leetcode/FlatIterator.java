package com.Leetcode;

import java.util.Iterator;
import java.util.LinkedList;

public class FlatIterator implements Iterator{
	Iterator curI;
	LinkedList<Iterator> stack;
	
	public FlatIterator(Iterator i){
		curI=i;
		stack=new LinkedList<Iterator>();
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(curI.hasNext())
			return true;
		if(!stack.isEmpty()){
			curI=stack.pop();
			return hasNext();
		}
		else
			return false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		Object next=curI.next();
		if(next instanceof Iterator){
			stack.push(curI);
			curI=(Iterator) next;
			return next();
		}
		else
			return next;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not required!");
	}

}
