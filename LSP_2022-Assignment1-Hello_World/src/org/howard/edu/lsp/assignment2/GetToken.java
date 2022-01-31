package org.howard.edu.lsp.assignment2;

import org.howard.edu.lsp.assignment2.ComputeTokens;

/**
 * This is a class that takes in tokens from the user, 
 * and invokes computeTokens() to print them out along 
 * with their sum and product. After completing the func
 * for one set of tokens, this asks the user if they
 * would like to end the program
 * 
 * @author Ronte' Parker
 */

public class GetToken {

	public static void main(String[] args) {
		
		String end = "";
		System.out.println("Enter your tokens (integers):");
		String[] tokens = ComputeTokens.scanner.nextLine().split(" ");
		
		while (!end.equalsIgnoreCase("goodbye")) {
			
			if (end != "") {
				System.out.println("Enter your tokens (integers):");
				tokens = ComputeTokens.scanner.nextLine().split(" ");
			}
			
			ComputeTokens.compute(tokens);
			
			System.out.println();
			System.out.println("Type \"goodbye\" if you would like to end this program, or \"continue\" to continue.");
			end = ComputeTokens.scanner.nextLine().trim().toLowerCase();
		}
		
		
		System.out.println("Thank you for using my program!");
		ComputeTokens.scanner.close();
	}

}
