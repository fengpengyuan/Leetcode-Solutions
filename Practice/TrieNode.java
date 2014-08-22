package com.Practice;

import java.util.HashMap;

public class TrieNode {
	char value;
	boolean isEnd;
	HashMap<Character, TrieNode> children;
	
	public TrieNode(char c){
		value=c;
		isEnd=false;
		children=new HashMap<Character, TrieNode>();
	}
	
	public HashMap<Character,TrieNode> getChildren() {   return children;  }    
    public char getValue()                           {   return value;     }    
    public void setIsEnd(boolean val)                {   isEnd = val;     }    
    public boolean isEnd()                           {   return isEnd;    }
}
