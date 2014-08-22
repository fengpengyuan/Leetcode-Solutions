package com.Practice;

public class TernarySearchTree {
	TernaryNode root=null;
	public TernarySearchTree(){
		this.root=null;
	}
	
	private void insert(String key, int pos, TernaryNode node) 
    { 
        char s[] = key.toCharArray(); 
        if (node == null) { node = new TernaryNode(s[pos]); }

        if (s[pos] < node.val) { 
        	if(node.left == null) node.left = new TernaryNode(s[pos]);
            insert(key, pos, node.left); 
            } 
        else if (s[pos] > node.val) { 
        	if(node.right == null) node.right = new TernaryNode(s[pos]);
            insert(key, pos, node.right); 
            } 
        else 
        { 
        	if(node.equal == null) node.equal = new TernaryNode(s[pos]);
            if (pos + 1 == key.length()) { node.isEnd = true; } 
            else { insert(key, pos + 1, node.equal); } 
        } 
    }

    public void insert(String s) 
    { 
        if (s == null || s == "") throw new IllegalArgumentException();

        insert(s, 0, this.root); 
    }

    public boolean containsKey(String key) 
    { 
        if (key == null || key == "") throw new IllegalArgumentException();
        
        int pos = 0; 
        TernaryNode node = this.root; 
        char s[] = key.toCharArray(); 
        while (node != null) 
        {

            if (s[pos] < node.val) { node = node.left; } 
            else if (s[pos] > node.val) { node = node.right; } 
            else 
            { 
                if (++pos == key.length()) return node.isEnd; 
                node = node.equal; 
            } 
        }

        return false; 
    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TernarySearchTree tree = new TernarySearchTree(); 
        tree.insert("AB"); 
        tree.insert("ABBA"); 
        tree.insert("ABCD"); 
        tree.insert("BCD"); 
        
        boolean found = tree.containsKey("AB"); 
        
        if(found) 
            System.out.println("AB is found in the tree"); 
        else 
            System.out.println("AB is not found"); 
	}

}
