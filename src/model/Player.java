package model;

import java.io.Serializable;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String symbol;
	private int position;
	private int moves;
	
	private Player nextPlayer;
	private Player previousPlayer;
	
	private Player nextPlayerGen;

	public Player(String symbol) {
		this.symbol = symbol;
		position=1;
		moves=0;
	}
	
	public Player() {
		
	}

	public String getSymbol() {
		return symbol;
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Player getNextPlayer() {
		return nextPlayer;
	}

	public void setNextPlayer(Player nextPlayer) {
		this.nextPlayer = nextPlayer;
	}

	public Player getPreviousPlayer() {
		return previousPlayer;
	}

	public void setPreviousPlayer(Player previousPlayer) {
		this.previousPlayer = previousPlayer;
	}

	public Player getNextPlayerGen() {
		return nextPlayerGen;
	}

	public void setNextPlayerGen(Player nextPlayerGen) {
		this.nextPlayerGen = nextPlayerGen;
	}

}
