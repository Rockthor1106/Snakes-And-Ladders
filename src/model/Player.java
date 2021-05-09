package model;


public class Player {
	
	private String symbol;
	private int position;
	private int moves;
	
	private Player nextPlayer;
	private Player previousPlayer;
	

	public Player(String symbol) {
		this.symbol = symbol;
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
	
//	public String toString() {
//		String msg = "";
//		msg = nextPlayer.getSymbol() ;
//		return msg;
//	}
}
