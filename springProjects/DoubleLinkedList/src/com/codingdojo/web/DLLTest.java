package com.codingdojo.web;

public class DLLTest {
	
	public static void main(String[] arg) {
		System.out.println("started...");
		
		DLL newHead = new DLL();
		
		Node fNode = new Node("1 node");
		Node sNode = new Node("2 node");
		Node tNode = new Node("3 node");
		Node fiveNode = new Node("4 node");

		newHead.add(fNode);
		newHead.add(sNode);
		newHead.add(tNode);
		newHead.add(fiveNode);
	}

	
}
