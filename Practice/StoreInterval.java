package com.Practice;

public class StoreInterval {
IntervalNode root;

int max=Integer.MAX_VALUE;
int min=Integer.MIN_VALUE;


	public StoreInterval(){
		root=null;
	}
	
	public boolean insert(Interval interval){
		if(root==null){
			root=new IntervalNode(interval);
			max=interval.end;
			min=interval.start;
			return true;
		}
		
		IntervalNode cur=root;
		IntervalNode parent=null;
		while(cur!=null){
			parent=cur;
			if(cur.interval.start>interval.end)
				cur=cur.left;
			else if(cur.interval.end<=interval.start)
				cur=cur.right;
			else
				return false;
		}
		
		if(interval.start>=parent.interval.end)
			parent.right=new IntervalNode(interval);
		else if(interval.end<parent.interval.start)
			parent.left=new IntervalNode(interval);
		
		max=Math.max(max, interval.end);
		min=Math.min(min, interval.start);
		return true;
	}
	
	public Interval find(int val){
		if(val<min||val>max)
			return new Interval(-1,-1);
		
		IntervalNode cur=root;
		
		while(cur!=null){
			if(cur.interval.start>val)
				cur=cur.left;
			else if(cur.interval.end<=val)
				cur=cur.right;
			return cur.interval;
		}
		return new Interval(-1,-1);
	}
}
