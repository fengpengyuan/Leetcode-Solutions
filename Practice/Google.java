package com.Practice;

public class Google {
	Node parent;
	Node sibling;
	Node firstChild;
public Google(){
	
}

public Node getParent(){
	return this.parent;
}

public Node getSibling(){
	return this.sibling;
}

public Node getFirstChild(){
	return this.firstChild;
}

public Node getNextNode(Node node){
	if(node==null)
		return null;
	if(getFirstChild()!=null)
		return getFirstChild();
	if(getSibling()!=null)
		return getSibling();
	Node p=getParent();
	
	while(p!=null){
		Node next=getSibling();
		if(next!=null)
			return next;
		p=getParent();
	}
	return null;
}
}
