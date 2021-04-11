package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SnakesAndLaddersTest {

	public void setupScenary1() {
		
	}
	
	@Test
	public void testSeparateParts() {
		setupScenary1();

		String entry = "5 4 2 3 #%*";

		SnakesAndLadders sal = new SnakesAndLadders();
		
		assertEquals("5", sal.separateParts(entry)[0]);
		assertEquals("4", sal.separateParts(entry)[1]);
		assertEquals("2", sal.separateParts(entry)[2]);
		assertEquals("3", sal.separateParts(entry)[3]);
		assertEquals("#%*", sal.separateParts(entry)[4]);

	}

}
