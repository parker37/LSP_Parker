package org.howard.edu.lsp.assignment5.implementation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * IntegerSet
 * @author Ronte' Parker
 * This is a class that manages collections of Integers
 */

public class IntegerSet {
	/**
	 * Integer Array List for each instance
	 */
	private ArrayList<Integer> set = new ArrayList<Integer>();

	/**
	 *  Default Constructor
	 */
	public IntegerSet() {
	}

	/**
	 *  Clears the internal representation of the set
	 */
	public void clear() {
		set.clear();
	};
	
	/**
	 * Length Method returns the size of the integer set
	 * @return Returns the length of the set
	 */
	public int length() {
		return set.size();
	}; // returns the length
	
	
	/** 
	 * Checks if the 2 sets are equal.
	* Two sets are equal if they contain all of the same values in ANY order.
	* @param b: Takes in an IntegerSet object
	* @return Returns true if they equal each other
	*/
	public boolean equals(IntegerSet b) {
		// returns false if sets are of unequal sizes
		if (set.size() != b.set.size()) return false;
		// returns true if first set is 0, since they are equal
		if (set.size() == 0) return true;
		
		// loops through the first set and checks if each integer
		// are equal since this class sorts the sets
		for(int i = 0; i < set.size(); i++) {
			if(set.get(i) != b.set.get(i)) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 *  Checks if the set contains the provided value
	 * @param value: Integer to check
	 * @return Returns true or false whether the set contains that value
	 */
	public boolean contains(int value) {
		return set.contains(value);
	};
	
	
	/**
	 *  Gets the largest integer in the set
	 * @return Returns the largest value in the set
	 * @throws IntegerSetException Is thrown if the set is empty 
	 */
	public int largest() throws IntegerSetException {
		if (set.isEmpty()) {
			//throws an error is thrown if set is empty
			throw new IntegerSetException("\nCannot get an element from an empty set");
		}

		return set.get(set.size() - 1);
	};
	
	/**
	 *  Gets the smallest integer in the set
	 * @return Returns the smallest value in the set
	 * @throws IntegerSetException Is thrown if the set is empty 
	 */
	public int smallest() throws IntegerSetException {
		if (set.isEmpty()) {
			//throws an error is thrown if set is empty
			throw new IntegerSetException("\nCannot get an element from an empty set");
		}
		
		return set.get(0);
		
	};


	/**
	 *  Adds an item to the set or does nothing it already there	
	 * @param item: Integer to be added to the set
	 */
 	public void add(int item) {
 		if (!set.contains(item)) {
 			// adds item to the set or does nothing if it is in set
 			set.add(item);
 			
 			// sorts the set
	 		Collections.sort(set);
 		}
 	}; 
	/**
	 *  Removes an item from the set or does nothing if not there
	 * @param item: Integer to be removed
	 * @throws IntegerSetException Is thrown of the set is empty
	 */
	public void remove(int item) throws IntegerSetException {
		if (set.isEmpty()) {
			//throws an error is thrown if set is empty
			throw new IntegerSetException("\nCannot remove an element from an already empty set");
		}
		if (set.contains(item)) {
			// attempts to remove the integer, if not present
			// nothing happens
			set.remove(set.indexOf(item));
		}
	};
	
	/**
	 *  Set union: Assigns the value of all the integers in both
	 *  sets to the first set
	 * @param intSetb: 2nd set to perform this method with
	 */
	public void union(IntegerSet intSetb) {
		for(int b : intSetb.set) {
			// loops through the second set and adds unique integers
			// to the set
			this.add(b);
		}
	}
	
	/**
	 *  Set intersect: Assigns the value of the integers in both
	 *  sets to the first set
	 * @param intSetb: 2nd set to perform this method with
	 */
	public void intersect(IntegerSet intSetb) {
		ArrayList<Integer> newSet = new ArrayList<Integer>();
		
		for(int i = 0; i < intSetb.set.size(); i++) {
			// loops through the elements of the second set
			if (set.contains(intSetb.set.get(i))) {
				// if they are present in the first set add them
				// to the temp new set
				newSet.add(intSetb.set.get(i));
			}
		}
		
		// assign the values of the new set to be the current set
		set.clear();
		set.addAll(newSet);
	}; 
	
	/**
	 *  Set Difference1: Removes integers present in the 2nd set
	 *  from the first set (Subtraction/Arithmetic). 
	 *  Ex: A - B or A ⋂ !B = setA.diff1(setB)
	 * @param intSetb: 2nd set to perform this method with
	 */
	public void diff1(IntegerSet intSetb) {
		// set difference, i.e. s1 - s2
		for(int i = 0; i < intSetb.set.size(); i++) {
			// Loops through the integers in the second set
			if (set.contains(intSetb.set.get(i))) {
				// removes the integer from the first set if it's
				// found in there
				set.remove(intSetb.set.get(i));
			}
		}
	}
	
	/**
	 *  Set Difference2: Removes integers present in the both sets
	 *  from the first set and adds the remaining integers to the
	 *  first set. Ex: !(A ⋂ B) = setA.diff2(setB)
	 * @param intSetb: 2nd set to perform this method with
	 */
	public void diff2(IntegerSet intSetb) {
		// set difference, i.e. s1 - s2
		for(int i = 0; i < intSetb.set.size(); i++) {
			// Loops through the integers in the second set
			if (set.contains(intSetb.set.get(i))) {
				// removes the integer from both sets if it's
				// found in there
				set.remove(intSetb.set.get(i));
				intSetb.set.remove(intSetb.set.get(i));
				i--;
			}
		}
		
		set.addAll(intSetb.set); //adds remaining elements to the set
	}
	
	/**
	 *  Checks if the set is empty
	 * @return Returns true if the set is empty, false otherwise
	 */
	public boolean isEmpty() {
		return set.isEmpty();
	}
	
	/**
	 * @return Returns a string representation of the set
	 */
	public String toString() {
		return set.toString();
	};	// return String representation of your set
	
	/** IntegerSetException:
	 * 
	 * This catches exceptions in this class that are thrown due
	 * to an empty set.
	 * @author Ronte' Parker
	 */
	public class IntegerSetException extends Exception {
		/**
		 * Random Static Generated Serial
		 */
		private static final long serialVersionUID = -719175053645894022L;

		/**
		 * Constructor function for IntegerSetException
		 * @param s: String that tells what went wrong
		 */
	    IntegerSetException(String s) {
	    	super(s);
	    }
	}
}
