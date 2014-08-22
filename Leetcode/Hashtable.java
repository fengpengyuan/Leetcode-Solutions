package com.Leetcode;

public class Hashtable {
	 Node[] entries;
     int numvalues;
     float max_load_factor;
     public Hashtable(float max_load_factor) {
    	 this.max_load_factor=max_load_factor; 
     } // constructor
     
     public void insert(int key, String value) {
         int index = key % entries.length;
         Node e = new Node();
         e.key = key;
         e.value = value;
         e.next = entries[index];
         entries[index] = e;
         numvalues++;
         float load_factor = (float)numvalues / entries.length;
         if (load_factor > max_load_factor) {
            rehash();
         }
     }
     private void rehash() {
         Node oldEntries[] = entries;
         int oldCapacity = oldEntries.length; 
         int newCapacity = 2*oldCapacity;
         entries = new Node[newCapacity];
         numvalues=0;
         for (int i = 0 ; i < oldCapacity ; i++) {
             for (Node e = oldEntries[i] ; e != null ; e = e.next) {
                 insert(e.key, e.value);
             }
         }
     }
}
