package model;


public class Player {
	
	private String symbol;
	
	private Player nextPlayer;
	private int moves;
	
	private int position;
	
	private Player nextInCell;

	public Player(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}



	public Player getNextPlayer() {
		return nextPlayer;
	}

	public void setNextPlayer(Player nextPlayer) {
		this.nextPlayer = nextPlayer;
	}


	public Player getNextInCell() {
		return nextInCell;
	}

	public void setNextInCell(Player nextInCell) {
		this.nextInCell = nextInCell;
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}
	
	public String toString() {
		return symbol;
		/*String playerString="";
		playerString+=nextInCell.toString();
		
		return playerString;*/
	}
	

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
}
