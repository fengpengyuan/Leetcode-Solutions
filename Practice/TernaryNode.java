package com.Practice;

import java.util.ArrayList;

public class TernaryNode {
	char val;
	TernaryNode left;
	TernaryNode equal;
	TernaryNode right;
	
	boolean isEnd=false;
	
	public TernaryNode(char val){
		this.val=val;
	}
	
	public static void insert(String word,TernaryNode root){
		if(word==null||word=="")
			throw new IllegalArgumentException();
		insert(word,0,root);
		
	}
	
	public static void insert(String word, int pos, TernaryNode root){
		if(root==null)
			root=new TernaryNode(word.charAt(pos));
		
		if(root.val>word.charAt(pos))
			insert(word,pos,root.left);
		
		else if(root.val<word.charAt(pos))
			insert(word,pos,root.right);
		else{
			if(pos+1==word.length())
				root.isEnd=true;
			else{
				insert(word,pos+1,root.equal);
			}
		}
	}
	
	public static boolean containsKey(String key,TernaryNode root){
//		if (key == null || key == "") throw new IllegalArgumentException();
		
		if(root==null)
			return false;
		
//		TernaryNode cur=root;
		int pos=0;
//		System.out.print(cur.val+" ");
		
		if(root.val>key.charAt(pos))
			return containsKey(key,root.left);
		else if(root.val<key.charAt(pos))
			return containsKey(key,root.right);
		else{
			if(pos+1==key.length())
				return root.isEnd;
			return containsKey(key.substring(pos+1),root.equal);
			}
//		while(cur!=null){
//			if(cur.val>key.charAt(pos))
//				cur=cur.left;
//			else if(cur.val<key.charAt(pos))
//				cur=cur.right;
//			else{
//				if(++pos==key.length())
//					return cur.isEnd;
//				cur=cur.equal;
//			}
////			System.out.print(cur.val+" ");
//				
//		}
//		return false;
	}
	
	
	public static ArrayList<String> traverseTST(TernaryNode root){
		ArrayList<String> res=new ArrayList<String>();
		if(root==null)
			return res;
		String sol="";
		
		traverseTSTUtil(root, sol, res);
		return res;
	}
	
	public static void traverseTSTUtil(TernaryNode root, String sol, ArrayList<String> res){
		if(root==null)
			return;
		
		sol+=root.val;
		if(root.isEnd){
			res.add(sol);
		}
		traverseTSTUtil(root.left,sol,res);
		sol=sol.substring(0,sol.length()-1);
		traverseTSTUtil(root.equal,sol,res);
		sol=sol.substring(0,sol.length()-1);
		traverseTSTUtil(root.right,sol,res);
	}
	
	public static void main(String[] args) {
		TernaryNode root=new TernaryNode('c');
		insert("cat",root);
		insert("cats",root);
		insert("up",root);
		insert("bug",root);
//		insert("cat",root);
		
		System.out.println(containsKey("cat",root));
	}
}
