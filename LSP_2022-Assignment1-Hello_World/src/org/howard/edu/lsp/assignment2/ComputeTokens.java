package org.howard.edu.lsp.assignment2;

import java.util.Scanner;

/**
 * This is a class that declares the compute method, for
 * calculating tokens' stats, and scanner property, for 
 * getting user input.
 * 
 * @author Ronte' Parker
 */

public class ComputeTokens {
	
	// Declaration of input scanner to allow for use in 
	// in the main GetToken.java file and this file
	static Scanner scanner = new Scanner(System.in);
	
	/**
	 * This is a method that displays the given tokens,
	 * the sum of those tokens, and the product of those 
	 * tokens.
	 * 
	 * @param a This parameter is an array of string-type
	 * tokens the user has inputed  
	 */
	public static void compute(String[] tokens) {
		
		int tokensSum = 0;
		int tokensProduct = 1;
		
		System.out.println();
		for(int i = 0; i < tokens.length; i++) {
		// Loops through tokens to print them to the user, calculate
		// the sum, and calculate the product
			
			// Sets up printing the Tokens' information
			if (i == 0) {
				System.out.println("\nTokens:");
				tokensSum = 0;
				tokensProduct = 1;
			}
			
			
			try {
				// This code block attempts to convert the String-type number
				// tokens to Int-type numbers to perform arithmetic operations
				tokensSum += Integer.parseInt(tokens[i]);
				tokensProduct *= Integer.parseInt(tokens[i]);
				
				System.out.println(tokens[i]);
				
			} catch(NumberFormatException err) {
				// If there is an error this code block prints out the error and
				// tells the user to enter an integer to replace the token
				System.out.println(err + "\n\nYou entered an invalid number. Please input an integer: ");
				tokens[i] = scanner.next();
				
				// sets the index back to start over printing the tokens as one 
				// complete block of output
				i = -1;
			}
		}
		
		System.out.println("Sum: " + tokensSum + "\nProduct: " + tokensProduct);
	}
}
