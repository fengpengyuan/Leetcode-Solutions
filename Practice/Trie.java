package com.Practice;

import java.util.HashMap;

public class Trie {
	public TrieNode root;
	
	public Trie(){
		root=new TrieNode('0');
	}
	
	public void insert(String word){
		// Find length of the given word
        int length = word.length();        
        TrieNode crawl = root;
           
        // Traverse through all characters of given word
        for( int level = 0; level < length; level++)
        {
            HashMap<Character,TrieNode> child = crawl.getChildren();            
            char ch = word.charAt(level);
               
            // If there is already a child for current character of given word 
            if( child.containsKey(ch))
                crawl = child.get(ch);
            else   // Else create a child
            {              
                TrieNode temp = new TrieNode(ch);
                child.put( ch, temp );
                crawl = temp;
            }
        }
           
        // Set bIsEnd true for last character
        crawl.setIsEnd(true);
	}
	
	
	public String getMatchingPrefix(String input)  {
		String res="";
		
		int length=input.length();
		// Initialize reference to traverse through Trie
		TrieNode crawl=root;
		 // Iterate through all characters of input string 'str' and traverse 
        // down the Trie
		int prevMatch = 0; 
		for(int i=0;i<length;i++){
			// Find current character of str
			char c=input.charAt(i);
			// HashMap of current Trie node to traverse down
			HashMap<Character, TrieNode> children=crawl.getChildren();
			// See if there is a Trie edge for the current character
			if(children.containsKey(c)){
				crawl=children.get(c); //Update crawl to move down in Trie
				res+=c; //Update result
				// If this is end of a word, then update prevMatch
				if(crawl.isEnd){
					prevMatch=i+1;
				}
			}
			else
				break;
		}
		 // If the last processed character did not match end of a word, 
        // return the previously matching prefix
        if( !crawl.isEnd() )
                return res.substring(0, prevMatch);        
         
        else 
        	return res;
	}
}
