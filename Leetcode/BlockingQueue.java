package com.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
	private Queue que=new LinkedList();
	private int size=10;
	
	public BlockingQueue(int size){
		this.size=size;
	}
	
	public synchronized void enque(Object item) throws InterruptedException{
		while(this.que.size()==this.size){
			wait();
		}
		// notify all the threads are waiting
		if(this.que.size()==0){
			notifyAll();
		}
		this.que.add(item);
	}
	
	public synchronized Object dequeue() throws InterruptedException{
		while(this.que.size()==0){
			wait();
		}
		
		if(this.que.size()==this.size)
			notifyAll();
		
		return que.remove();
	}
}
