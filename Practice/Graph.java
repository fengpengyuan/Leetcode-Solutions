package com.Practice;

import java.util.ArrayList;

public class Graph {
	int V;
	ArrayList<ArrayList<Integer>> adj;
	
	public Graph(int V){
		this.V=V;
		adj=new ArrayList<ArrayList<Integer>>(V);
	}
}
