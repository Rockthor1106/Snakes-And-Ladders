package model;

public class Cell{
	
	private int number;
	private char snake;
	private int ladder;
	
	private int row;
	private int col;

	private Cell next;
	private Cell previous;
	private Cell up;	
	private Cell down;
	
	private Player firstPlayer;
	
	public Cell(int row, int col, int number) {
		this.row = row;
		this.col = col;
		this.number = number;	
		snake = ' ';
		ladder = 0;
		
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
    
	public Cell getNext() {
		return next;
	}

	public Cell getPrevious() {
		return previous;
	}

	public Cell getUp() {
		return up;
	}

	public Cell getDown() {
		return down;
	}

	public void setPrevious(Cell previous) {
		this.previous = previous;
	}

	public void setNext(Cell next) {
		this.next = next;
	}

	public void setUp(Cell up) {
		this.up = up;
	}

	public void setDown(Cell down) {
		this.down = down;
	}
	
	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public String toString() {
		String msg = "";
		
		if (number >= 10) {
			if (firstPlayer == null) {
				msg= "["+ ladder + " " + snake +"]";
			}
			else {
				msg= "["+ ladder + " " + snake + " " + firstPlayer.getSymbol() +"]";
			}
//			msg = "["+number+"]";
			//msg = "["+number+ " " + snake +  " " + ladder + "]" ;
			
		}
		else {
			if (firstPlayer == null) {
				msg= "["+ ladder + " " + snake +"]";
			}
			else {
				msg= "["+ ladder + " " + snake + " " + firstPlayer.getSymbol() +"]";
			}
//			msg = "[ "+number+"]";
			//msg= "[" + ladder + " " +snake + "]" ;
			
		}
		return msg;
	}
	
	public char getSnake() {
		return snake;
	}

	public void setSnake(char snake) {
		this.snake = snake;
	}

	public int getLadder() {
		return ladder;
	}

	public void setLadder(int ladder) {
		this.ladder = ladder;
	}
	
	//Method to add players---------------------------------------------------
	public void addPlayer(Player newPlayer) {
		if (firstPlayer == null) {
			firstPlayer = newPlayer;
			firstPlayer.setNextPlayer(newPlayer);
			firstPlayer.setPreviousPlayer(newPlayer);
			firstPlayer.setPosition(1);
		}
		else {
			Player lastPlayer = firstPlayer.getPreviousPlayer();
			newPlayer.setNextPlayer(firstPlayer);
			newPlayer.setPreviousPlayer(lastPlayer);
			firstPlayer.setPreviousPlayer(newPlayer);
			lastPlayer.setNextPlayer(newPlayer);
			lastPlayer.setPosition(1);
		}
	}
	//-------------------------------------------------------------------------
	
	//Method to delete the first player----------------------------------------
	public void deletePlayer() {
		Player lastPlayer = firstPlayer.getPreviousPlayer();
		if (firstPlayer == lastPlayer) {
			firstPlayer = null;
			lastPlayer = null;
		}
		else {
			Player newFirst = firstPlayer.getNextPlayer();
			firstPlayer = newFirst;
			newFirst.setPreviousPlayer(lastPlayer);
			lastPlayer.setNextPlayer(firstPlayer);
		}
	}
	//-------------------------------------------------------------------------
	
	public boolean empty() {
		if (firstPlayer == null) {
			return true;
		}
		else {
			return false;
		}
	}

}