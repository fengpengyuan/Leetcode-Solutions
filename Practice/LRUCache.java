package com.Practice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache<K,V> {
	private int maxSize;
	private HashMap<K,V> map;
	private Queue<K> que;
	
	public LRUCache(int maxSize){
		this.maxSize=maxSize;
		this.map=new HashMap<K,V>();
		this.que=new LinkedList<K>();
	}
	
	public void put(K key, V value){
		if(map.containsKey(key))
			que.remove(key);
		
		while(que.size()>=maxSize){
			K oldkey=que.poll();
			if(oldkey!=null)
				map.remove(oldkey);						
		}
		que.add(key);
		map.put(key, value);
	}
	
	public V get(K key){
		return map.get(key);
	}
}
