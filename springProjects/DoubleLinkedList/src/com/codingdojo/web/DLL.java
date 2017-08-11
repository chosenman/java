package com.codingdojo.web;

public class DLL {
	private Node head;
	private Node end;
	

	DLL(){
		this.head = null;
		this.end = null;
	}
	
	// add new node
	public void add(Node node) {
		if(this.head == null) {
			this.head = node;
			setEnd(node);
		} else {
			this.end.setNext(node);		// (end)--setNext-->[newNode]
			node.setPrev(this.end); 		// (end)<--prev--[newNode]
			this.end = node;
		}
	}
	
	public Node getHead() {
		return this.head;
	}
	
	// END setters/getters
	public Node getEnd() {
		return end;
	}

	public void setEnd(Node end) {
		this.end = end;
	}
	
}
