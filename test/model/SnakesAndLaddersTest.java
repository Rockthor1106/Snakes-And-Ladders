package model;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SnakesAndLaddersTest {
	
	private SnakesAndLadders sal;
	
	public void setupScenary1() {
		sal = new SnakesAndLadders();
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
