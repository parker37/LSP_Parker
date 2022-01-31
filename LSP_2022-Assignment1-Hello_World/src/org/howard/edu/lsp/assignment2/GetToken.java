package org.howard.edu.lsp.assignment2;

import java.util.Scanner;

public class GetToken {

	public static void main(String[] args) {
		
		System.out.println("Enter your tokens (integers):");
		
		Scanner scanner = new Scanner(System.in);
		String[] tokens = scanner.nextLine().split(" ");
		
		int tokensSum = 0;
		int tokensProduct = 1;
		
		System.out.println();
		for(int i = 0; i < tokens.length; i++) {
			if (i == 0) {
				System.out.println("\nTokens:");
			}
			
			try {
				tokensSum += Integer.parseInt(tokens[i]);
				tokensProduct *= Integer.parseInt(tokens[i]);
				
				System.out.println(tokens[i]);
				
			} catch(NumberFormatException err) {
				System.out.println("You entered an invalid number. Please input an integer: ");
				tokens[i] = scanner.next();
				i--;
			}
		}
		
		System.out.println("Sum: " + tokensSum + "\nProduct: " + tokensProduct);
		
		scanner.close();
	}

}
