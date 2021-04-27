package model;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SnakesAndLaddersTest {
	
	private SnakesAndLadders sal;
	public void setupScenary1() {
		sal = new SnakesAndLadders();
	}
	
	
	//This test evaluates the SeparateEntry method when the user chooses that the symbols for players are generated randomly
	@Test
	public void testSeparatePartsRandom() {
		setupScenary1();

		String entry = "5 4 2 3 3";

		
		
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
		
		assertEquals("5", sal.separateEntry(entry)[0]);
		assertEquals("4", sal.separateEntry(entry)[1]);
		assertEquals("2", sal.separateEntry(entry)[2]);
		assertEquals("3", sal.separateEntry(entry)[3]);
		assertEquals("#%*", sal.separateEntry(entry)[4]);

	}
	
	
	//This test verifies if the players are created from an array String with the symbols
	
	@Test
	public void testCreatePlayer() {
		setupScenary1();
		String symbols = "$#";
		sal.createPlayers(symbols, 0);
		
		assertEquals(sal.getFirstPlayer().getSymbol(), "$");
		Player test = sal.getFirstPlayer().getNextPlayer();
		assertEquals(test.getSymbol(), "#");
		
		
	}
	
	
	//This test verifies if the players are created with a random symbol
	@Test
	public void testCreatePlayersRandom() {
		setupScenary1();
		
		sal.createPlayersRandom(3);
		assertNotEquals(sal.getFirstPlayer(), null);
		assertNotEquals(sal.getFirstPlayer().getNextPlayer(), null);
		assertNotEquals(sal.getFirstPlayer().getNextPlayer().getNextPlayer(), null);
	}
	
}
