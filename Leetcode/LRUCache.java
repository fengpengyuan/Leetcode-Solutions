package com.Leetcode;

import java.util.HashMap;

public class LRUCache {
	int capacity;
	HashMap<Integer, CacheNode> map=new HashMap<Integer, CacheNode>();
	CacheNode head=null;
	CacheNode tail=null;
	public LRUCache(int capacity){
		this.capacity=capacity;
	}
	
	public int get(int key) {
		if(!map.containsKey(key))
			return -1;
		CacheNode node=map.get(key);
		CacheNode next=node.next;
		CacheNode pre=node.pre;
		if(next!=null){
			if(pre!=null){
				pre.next=next;
			}
			else
				head=next;
			next.pre=pre;
			tail.next=node;
			node.pre=tail;
			node.next=null;
			tail=node;
		}
		return node.value;
	}
	
	
	public void set(int key, int value) {
		if(map.containsKey(key)){
			get(key);//move to the tail
			map.get(key).value=value;
		}
		else{
			CacheNode node=new CacheNode(key, value);
			//full
			if(map.size()==capacity){
				CacheNode old=head;
				head=old.next;
				old.next=null;
				if(head!=null)
					head.pre=null;
				map.remove(old.key);
			}
			// empty
			if(head==null){
				head=node;
				tail=node;
			}
			//else
			else{
				tail.next=node;
				node.pre=tail;
				tail=node;
			}
			map.put(key, node);
		}
	}
}
