package com.Solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {
//	int capacity;
//	HashMap<Integer, Integer> map;
//	Queue<Integer> que;
//	
//public LRUCache(int capacity) {
//        this.capacity=capacity;
//        map=new HashMap<Integer, Integer>();
//        que=new LinkedList<Integer>();
//    }
//    
//    public int get(int key) {
//        if(!map.containsKey(key))
//        	return -1;
//        else{
//        	que.remove(key);
//        	que.add(key);
//        	return map.get(key);
//        }
//    }
//    
//    public void set(int key, int value) {
//        if(map.containsKey(key)){
//        	map.put(key, value);
//        	que.remove(key);
//        	que.add(key);
//        }
//        else{
//        	if(map.size()==capacity){
//        		int del=que.remove();
//        		que.add(key);
//        		map.remove(del);
//        		map.put(key, value);
//        	}
//        	map.put(key, value);
//        	que.add(key);
//        }
//    }
	
	int capacity;
	HashMap<Integer, CacheNode> map=new HashMap<Integer, CacheNode>();
	CacheNode head=null;
	CacheNode tail=null;
	
	class CacheNode{
		int key;
		int val;
		CacheNode pre=null;
		CacheNode next=null;
		CacheNode(int key, int val){
			this.key=key;
			this.val=val;
		}
	}
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public int get(int key) {
		if(!map.containsKey(key))
			return -1;
		CacheNode node=map.get(key);
		CacheNode pre=node.pre;
		CacheNode next=node.next;
		
		if(next!=null){
			if(pre!=null)
				pre.next=next;
			else
				head=next;
			
			next.pre=pre;
			
			node.pre=tail;
			tail.next=node;
			node.next=null;
			tail=node;			
		}
		return node.val;
	}
	
	public void set(int key, int value) {
		if(map.containsKey(key)){
			get(key); // only to move it to the tail
            map.get(key).val = value;
		}
		else{
			CacheNode node=new CacheNode(key,value);
			if(map.size()==capacity){
				if(head!=null){
					CacheNode old=head;
					head=old.next;
					old.next=null;
					if(head!=null)
						head.pre=null;
					map.remove(old.key);
				}
			}
			
			if(head==null){
				head=node;
				tail=node;
			}
			else{
				tail.next=node;
				node.pre=tail;
				tail=node;
			}
			
			map.put(key, node);
			
		}
	}
	
	
	
	
}
