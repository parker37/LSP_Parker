package org.howard.edu.lsp.assignment5.test;

import org.howard.edu.lsp.assignment5.implementation.*;

public class Driver {

	public static void main(String[] args) {
		IntegerSet setA = new IntegerSet();
		setA.add(1);
		setA.add(2);
		setA.add(4);
		IntegerSet setB = new IntegerSet();
		setB.add(3);
		setB.add(4);
		setB.add(5);
		
		System.out.println("Sets A and B were created with these elements:");
		System.out.println("SetA: "+ setA.toString());
		System.out.println("SetB: "+ setB.toString());
		System.out.println();
		System.out.println("True or False: SetA contains the integer 3.");
		System.out.println(setA.contains(3));
		System.out.println();
		System.out.println("True or False: SetA contains the integer 3.");
		System.out.println(setB.contains(3));
		System.out.println();
		
	}

}
