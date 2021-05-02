package model;


public class Player {
	
	private String symbol;
	private String nickname;
	private int score;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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
