package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SnakesAndLaddersTest {

	public void setupScenary1() {
		
	}
	
	
	//This test evaluates the SeparateEntry method when the user chooses that the symbols for players are generated randomly
	@Test
	public void testSeparatePartsRandom() {
		setupScenary1();

		String entry = "5 4 2 3 3";

		SnakesAndLadders sal = new SnakesAndLadders();
		
		assertEquals("5", sal.separateEntry(entry)[0]);
		assertEquals("4", sal.separateEntry(entry)[1]);
		assertEquals("2", sal.separateEntry(entry)[2]);
		assertEquals("3", sal.separateEntry(entry)[3]);
		assertEquals("3", sal.separateEntry(entry)[4]);

	}
	
	//This test evaluates the SeparateEntry method when the user chooses that the symbols for players are NOT generated randomly
	@Test
	public void testSeparatePartsNoRandom() {
		setupScenary1();

		String entry = "5 4 2 3 #%*";

		SnakesAndLadders sal = new SnakesAndLadders();
		
		assertEquals("5", sal.separateEntry(entry)[0]);
		assertEquals("4", sal.separateEntry(entry)[1]);
		assertEquals("2", sal.separateEntry(entry)[2]);
		assertEquals("3", sal.separateEntry(entry)[3]);
		assertEquals("#%*", sal.separateEntry(entry)[4]);

	}
	
}
