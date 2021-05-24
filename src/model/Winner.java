package model;

import java.io.Serializable;

public class Winner extends Player implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
		String msg = "************************************\n";
		msg += "Nickname: " + nickname + "\n";
		msg += "Symbol: " + getSymbol() + "\n";
		msg += "Score: " + score + "\n";
		msg += game + "\n";
		msg += "************************************\n";
		return msg;
	}
	
}

