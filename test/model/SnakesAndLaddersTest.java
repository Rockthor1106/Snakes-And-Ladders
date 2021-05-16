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
		
		sal.createPlayers("#$%&", 0);
		
		assertEquals("#", sal.getFirstPlayer().getSymbol());
		assertEquals("$", sal.getFirstPlayer().getNextPlayerGen().getSymbol());
		assertEquals("%", sal.getFirstPlayer().getNextPlayerGen().getNextPlayerGen().getSymbol());
		assertEquals("&", sal.getFirstPlayer().getNextPlayerGen().getNextPlayerGen().getNextPlayerGen().getSymbol());
	}
	
	//This test verifies if the players are created with a random symbol
	@Test
	public void testCreatePlayersRandom() {
		setupScenary1();
		
		sal.createPlayersRandom(3);
		
		assertNotEquals(sal.getFirstPlayer(), null);
		assertNotEquals(sal.getFirstPlayer().getNextPlayerGen(), null);
		assertNotEquals(sal.getFirstPlayer().getNextPlayerGen().getNextPlayerGen(), null);
		//if the nextPlayerGen is verified, it will not be null either since the list of players is circular

	}
	
}
