package com.Practice;

import java.util.PriorityQueue;

public class TopKSums {
	private static class FrontierElem implements Comparable<FrontierElem> {
	       int value;
	      int aIdx;
	       int bIdx;
	 
	       public FrontierElem(int value, int aIdx, int bIdx) {
	            this.value = value;
	         this.aIdx = aIdx;
	           this.bIdx = bIdx;
	       }
	 
	       @Override
	       public int compareTo(FrontierElem o) {
	          return o.value - value;
	     }
	   }
	 
	   public static void findMaxSum( int [] a, int [] b, int k ) {
	        Integer [] frontierA = new Integer[ a.length ];
	     Integer [] frontierB = new Integer[ b.length ];
	     PriorityQueue<FrontierElem> q = new PriorityQueue<FrontierElem>();
	      frontierA[0] = frontierB[0]=0;
	      q.add( new FrontierElem( a[0]+b[0], 0, 0));
	     while( k > 0 ) {
	         FrontierElem f = q.poll();
	          System.out.println( f.value+"    "+"("+f.aIdx+","+f.bIdx+") queue Size"+q.size() );
	         k--;
	            frontierA[ f.aIdx ] = frontierB[ f.bIdx ] = null;
	           int fRight = f.aIdx+1;
	          int fDown = f.bIdx+1;
	           if( fRight < a.length && frontierA[ fRight ] == null ) {
	             q.add( new FrontierElem( a[fRight]+b[f.bIdx], fRight, f.bIdx));
	             frontierA[ fRight ] = f.bIdx;
	               frontierB[ f.bIdx ] = fRight;
	           }
	           if( fDown < b.length && frontierB[ fDown ] == null ) {
	               q.add( new FrontierElem( a[f.aIdx]+b[fDown], f.aIdx, fDown));
	               frontierA[ f.aIdx ] = fDown;
	                frontierB[ fDown ] = f.aIdx;
	            }
	       }
	   }
	   public static void main(String[] args) {
	         int[] A = { 21, 20, 19, 18, 17, 16, 15, 14, 13, 11, 10, 9, 7, 6, 5, 4, 3, 2, 1, 0 }; 
	       int[] B = { 20, 19, 18, 17, 16, 15, 14, 13, 12, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }; 
	          
	        findMaxSum(A, B, 10);
	 }
	}
