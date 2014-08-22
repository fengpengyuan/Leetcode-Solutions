package com.Leetcode;

public class CacheNode {
	int key;
	int value;
	CacheNode pre=null;
	CacheNode next=null;
	CacheNode(int key, int value){
		this.key=key;
		this.value=value;
	}
}
