package org.howard.edu.lsp.finalExam.implementation;

import java.util.HashMap;

public class MapUtilities {

	public static int commonKeyValuePairs(HashMap<String, String> map1, 
			HashMap<String, String> map2) throws NullMapException {
		
		// Throws exception if one or both maps are null
		if (map1 == null || map2 == null) {
			throw new NullMapException("One or both maps are null!");
		}
		
		// Returns 0 if one or both maps are empty
		if (map1.isEmpty() || map2.isEmpty()) {
			return 0;
		}
		
		// counter for matching key, value pairs
		int matches = 0;
		
		// loops through first map and finds matching keys, then checks
		// if the matching keys have matching values
		for(String key : map1.keySet()) {
			if(map2.containsKey(key)) {
				if(map1.get(key).equals(map2.get(key))) {
					matches++;
				}
			}
		}
		
		//returns number of matches
		return matches;
	}

}
