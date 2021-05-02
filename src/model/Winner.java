package model;

public class Winner extends Player {
	
	private String nickname;
	private int score;
	private String game; //this String contains the characteristics of the game grid and the game in general
	Winner left, right;
	
	public Winner(String symbol, String nickname, int score, String game) {
		super(symbol);
		this.nickname = nickname;
		this.score = score;
		this.game = game;
	}
	
	public String getNickname() {
		return nickname;
	}

	public int getScore() {
		return score;
	}
	
	public String getGame() {
		return game;
	}

	public Winner getLeft() {
		return left;
	}

	public void setLeft(Winner left) {
		this.left = left;
	}

	public Winner getRight() {
		return right;
	}

	public void setRight(Winner right) {
		this.right = right;
	}	
	
	public String toString() {
		String msg = "";
		msg = nickname + "\n";
		msg += score + "\n";
		msg += game;
		return msg;
	}
	
}
