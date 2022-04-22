package org.howard.edu.lsp.finalExam.test;
import org.howard.edu.lsp.finalExam.implementation.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import  org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class MapUtilitiesTest {

	@Test
	@DisplayName("MapUtilities.isEmpty test case")
	public void testIsEmpty() throws NullMapException {
		System.out.println("Testing MapUtilities.isEmpty test case...\nInput:");
		
		HashMap<String,String> mapA = new HashMap<String,String>();
		HashMap<String,String> mapB = new HashMap<String,String>();
		
		System.out.println("MapA: " + mapA.toString());
		System.out.println("MapB: " + mapB.toString());
		
		assertTrue(mapA.isEmpty());
		assertTrue(mapB.isEmpty());
		assertTrue(MapUtilities.commonKeyValuePairs(mapA, mapB) == 0);
		
		mapB.put("Game", "Minecraft");
		
		assertFalse(mapB.isEmpty());
		assertTrue(MapUtilities.commonKeyValuePairs(mapA, mapB) == 0);
		System.out.println();
	}
	
	@Test
	@DisplayName("MapUtilies.NullMaps test case")
	public void testNullMaps() {
		System.out.println("Testing MapUtilies.NullMaps test case...");
		
		HashMap<String,String> mapA = null;
		HashMap<String,String> mapB = null;
		System.out.println("MapA: " + mapA);
		System.out.println("MapB: " + mapB);
		
		try {
			MapUtilities.commonKeyValuePairs(mapA, mapB);
			assertFalse(true);
		} catch (NullMapException e) {
			assertTrue(e != null);
		}
		assertTrue(mapA == null);
		assertTrue(mapB == null);
		System.out.println();
		
		mapB = new HashMap<String,String>();
		mapB.put("Game", "Minecraft");
		
		try {
			MapUtilities.commonKeyValuePairs(mapA, mapB);
			assertFalse(true);
		} catch (NullMapException e) {
			assertTrue(e != null);
		}
		
		mapA = new HashMap<String,String>();
		mapA.put("Test", "PopQuiz");
		
		try {
			MapUtilities.commonKeyValuePairs(mapA, mapB);
			assertTrue(true);
		} catch (NullMapException e) {
			assertFalse(e != null);
		}
	}
	
	@Test
	@DisplayName("MapUtilities.AllCommonKeys test case")
	public void testAllCommonKeys() throws NullMapException {
		System.out.println("Testing MapUtilies.AllCommonKeys test case...\nInput:");
		
		HashMap<String,String> mapA = new HashMap<String,String>();
		HashMap<String,String> mapB = new HashMap<String,String>();
		
		mapA.put("1", "A");
		mapA.put("2", "B");
		mapA.put("3", "C");
		mapA.put("4", "D");
		
		mapB.put("1", "A");
		mapB.put("2", "C");
		mapB.put("3", "D");
		mapB.put("4", "E");
		
		assertFalse(mapB.isEmpty());
		assertFalse(mapB.isEmpty());
		System.out.println("MapA: " + mapA.toString());
		System.out.println("MapB: " + mapB.toString());
		
		int output = MapUtilities.commonKeyValuePairs(mapA, mapB);
		assertEquals(output, 1);
		
		
		System.out.println();
	}
	
	@Test
	@DisplayName("MapUtilities.AllCommonValues test case")
	public void testAllCommonValues() throws NullMapException {
		System.out.println("Testing MapUtilies.AllCommonValues test case...\nInput:");
		
		HashMap<String,String> mapA = new HashMap<String,String>();
		HashMap<String,String> mapB = new HashMap<String,String>();
		
		mapA.put("1", "A");
		mapA.put("2", "B");
		mapA.put("3", "C");
		mapA.put("4", "D");
		
		mapB.put("1", "A");
		mapB.put("3", "B");
		mapB.put("4", "C");
		mapB.put("5", "D");
		
		assertFalse(mapB.isEmpty());
		assertFalse(mapB.isEmpty());
		System.out.println("MapA: " + mapA.toString());
		System.out.println("MapB: " + mapB.toString());
		
		int output = MapUtilities.commonKeyValuePairs(mapA, mapB);
		assertEquals(output, 1);
		
		
		System.out.println();
	}
	
	@Test
	@DisplayName("MapUtilities.AllCommonKeyValuePairs test case")
	public void testAllCommonKeyValuePairs() throws NullMapException {
		System.out.println("Testing MapUtilies.AllCommonKeyValuePairs test case...\nInput:");
		
		HashMap<String,String> mapA = new HashMap<String,String>();
		HashMap<String,String> mapB = new HashMap<String,String>();
		
		mapA.put("1", "A");
		mapA.put("2", "B");
		mapA.put("3", "C");
		mapA.put("4", "D");
		
		mapB.put("1", "A");
		mapB.put("2", "B");
		mapB.put("3", "C");
		mapB.put("4", "D");
		
		assertFalse(mapB.isEmpty());
		assertFalse(mapB.isEmpty());
		System.out.println("MapA: " + mapA.toString());
		System.out.println("MapB: " + mapB.toString());
		
		int output = MapUtilities.commonKeyValuePairs(mapA, mapB);
		assertEquals(output, 4);
		
		
		System.out.println();
	}
	
	@Test
	@DisplayName("MapUtilities.NoCommonKeyValuePairs test case")
	public void testNoCommonKeyValuePairs() throws NullMapException {
		System.out.println("Testing MapUtilies.NoCommonKeyValuePairs test case...\nInput:");
		
		HashMap<String,String> mapA = new HashMap<String,String>();
		HashMap<String,String> mapB = new HashMap<String,String>();
		
		mapA.put("1", "A");
		mapA.put("2", "B");
		mapA.put("3", "C");
		mapA.put("4", "D");
		
		mapB.put("5", "E");
		mapB.put("6", "F");
		mapB.put("7", "G");
		mapB.put("8", "H");
		
		assertFalse(mapB.isEmpty());
		assertFalse(mapB.isEmpty());
		System.out.println("MapA: " + mapA.toString());
		System.out.println("MapB: " + mapB.toString());
		
		int output = MapUtilities.commonKeyValuePairs(mapA, mapB);
		assertEquals(output, 0);
		
		
		System.out.println();
	}
	
	
}
