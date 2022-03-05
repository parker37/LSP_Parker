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

	// Default Constructor
	public IntegerSet() {
	}

	/**
	 *  Clears the internal representation of the set
	 */
	public void clear() {
		set.clear();
	};
	
	/**
	 * Length Method return the size of the integer set
	 * @return Returns the length of the set
	 */
	public int length() {
		return set.size();
	}; // returns the length
	
	
	/** 
	 * Checks if the 2 sets are equal
	* Two sets are equal if they contain all of the same values in ANY order.
	* @paramA takes in an IntegerSet object
	* @return returns true if they equal each other
	*/
	public boolean equals(IntegerSet b) {
		if (set.size() != b.set.size()) return false;
		if (set.size() == 0) return true;
	
		for(int i = 0; i < set.size(); i++) {
			if(set.get(i) != b.set.get(i)) {
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 *  Checks if the set contains the value
	 * @param value: integer to check
	 * @return returns true or false whether the set contains that value
	 */
	public boolean contains(int value) {
		return set.contains(value);
	};
	
	
	/**
	 *  Gets the largest integer in the set
	 * @return Returns the largest item in the set
	 * @throws Throws a IntegerSetException if the set is empty 
	 */
	public int largest() throws IntegerSetException {
		try {
			return set.get(set.size() - 1);
		} catch(Error e) {
			throw new IntegerSetException("This Integer Set is empty");
		}
		
	}; 
	
	/**
	 *  Gets the smallest integer in the set
	 * @return Returns the smallest item in the set
	 * @throws Throws a IntegerSetException if the set is empty 
	 */
	public int smallest() throws IntegerSetException {
		try {
			return set.get(0);
		} catch(Error e) {
			throw new IntegerSetException("This Integer Set is empty");
		}
	};


	/**
	 *  Adds an item to the set or does nothing it already there	
	 * @param item: integer to be added to the set
	 */
 	public void add(int item) {
 		if (!set.contains(item)) {
 			set.add(item);
	 		Collections.sort(set);
 		}
 	}; // adds item to the set or does nothing if it is in set

	/**
	 *  Removes an item from the set or does nothing if not there
	 * @param item: integer to be removed
	 * @throws Throws a IntegerSetException of the set is empty
	 */
	public void remove(int item) throws IntegerSetException {
		if (set.contains(item)) {
			try {
				set.remove(set.indexOf(item));
			} catch(Error e) {
				throw new IntegerSetException("This Integer Set is empty");
			}
		}
		
	};
	
	/**
	 *  Set union: Assigns the value of all the integers in both
	 *  sets to the first set
	 * @param intSetb: 2nd set to perform this method on
	 */
	public void union(IntegerSet intSetb) {
		ArrayList<Integer> newSet = new ArrayList<Integer>();
		
		for(int b : intSetb.set) {
			this.add(b);
		}
		
		set = newSet;
	}
	
	/**
	 *  Set intersect: Assigns the value of the integers in both
	 *  sets to the first set
	 * @param intSetb: 2nd set to perform this method on
	 */
	public void intersect(IntegerSet intSetb) {
		for(int i = 0; i < intSetb.set.size(); i++) {
			if (set.contains(intSetb.set.get(i))) {
				set.remove(intSetb.set.get(i));
			}
		}
		
		set.addAll(intSetb.set);
	}; 
	
	/**
	 *  Set Difference: Removes integers present in the 2nd set
	 *  from the first set
	 * @param intSetb: 2nd set to perform this method on
	 */
	public void diff(IntegerSet intSetb) {
		// set difference, i.e. s1 - s2
		for(int i = 0; i < intSetb.set.size(); i++) {
			if (set.contains(intSetb.set.get(i))) {
				set.remove(intSetb.set.get(i));
			}
		}
	}
	
	// Returns true if the set is empty, false otherwise
	public boolean isEmpty() {
		return set.isEmpty();
	}
	
	// Return String representation of your set
	public String toString() {
		return set.toString();
	};	// return String representation of your set
	
	
	public class IntegerSetException extends Throwable {
	    /**
		 * Random Generated Serial Id Added
		 */
		private static final long serialVersionUID = -4796566397329504307L;
		String str1;
	    
	    IntegerSetException(String str2) {
	    	str1 = str2;
	    }
	    
	    public String toString(){ 
	    	return ("IntegerSetException Occurred: "+str1) ;
	       }
	}
}
