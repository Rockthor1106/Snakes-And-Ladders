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
	
	public Cell() {}
	
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
		
		String ladderString="";
		
		if(ladder!=0) {
			ladderString=String.valueOf(ladder);
		}
		
		if (number >= 10) {
			if (firstPlayer == null) {
				msg= "["+ ladderString + " " + snake +"]";
			}
			else {
				msg= "["+ ladderString + " " + snake + " " + showPlayers() + "]";
			}
			
		}
		else {
			if (firstPlayer == null) {
				msg=  "["+ ladderString + " " + snake +"]";
			}
			else {
				msg= "["+ ladderString + " " + snake + " " + showPlayers() + "]";
			}
			
		}
		return msg;
	}
	
	/**
	 * It collects the initial information of the cell, that is its identifier and if it contains a snake or a ladder
	 * <b> pre: </b> ladder!= null, number!= null, snake!=null <br>
	 * <b> pos: </b> <br>
	 * @return msg, String that contains the collected information
	 */
	public String initialState() {
		String msg = "";
		String ladderString="";
		
		if(ladder!=0) {
			ladderString=String.valueOf(ladder);
		}
		
		msg= "["+ number+ " " + "|" + ladderString + " " + snake +"]";
		
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
	
	
	/**
	 * This method adds a new player in the double linked list started by firstPlayer
	 * <b> pre: </b> <br>
	 * <b> pos: </b> The double linked list contained in firstPlayer has a new element<br>
	 * @param newPlayer, the player that will be added to the list 
	 */
	public void addPlayer(Player newPlayer) {
		
		newPlayer.setPosition(number);
		if (firstPlayer == null) {
			firstPlayer = newPlayer;
			firstPlayer.setNextPlayer(newPlayer);
			firstPlayer.setPreviousPlayer(newPlayer);
		}
		else {
			Player lastPlayer = firstPlayer.getPreviousPlayer();
			newPlayer.setNextPlayer(firstPlayer);
			newPlayer.setPreviousPlayer(lastPlayer);
			firstPlayer.setPreviousPlayer(newPlayer);
			lastPlayer.setNextPlayer(newPlayer);
		}
	}
	//-------------------------------------------------------------------------
	
	//Method to delete the first player----------------------------------------
	
	/**
	 * This method deletes the first player in the double linked list contained in firstPlayer
	 * <b> pre: </b> <br>
	 * <b> pos: </b> The double linked list contained in firstPlayer has one element less and the firstPlayer is reasigned <br>
	 */
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
	
	//Methods to show the list of players within a cell------------------------
	
	
	/**
	 * This method checks if the double linked list contained in firstPlayer is empty
	 * <b> pre: </b> <br>
	 * <b> pos: </b> <br>
	 * @return a boolean that is true if it's empty, false otherwise 
	 */
	public boolean empty() {
		if (firstPlayer == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * This method shows the players that are currently in the double linked list 
	 * <b> pre: </b> <br>
	 * <b> pos: </b> <br>
	 * @return msg, String that contains the symbols of all the players in the cell
	 */
	public String showPlayers() {
		String msg = "";
		if (!empty()) {
			msg = firstPlayer.getSymbol();
			msg += showPlayers(firstPlayer.getNextPlayer());
		}
		return msg;
	}
	
	
	
	/**
	 * Auxiliary method of showPlayers, in order to continue recursion
	 * <b> pre: </b> <br>
	 * <b> pos: </b> <br>
	 * @param aux, next player to get information from
	 * @return msg, String that contains the symbols of the rest of players in the cell 
	 */
	private String showPlayers(Player aux) {
		String msg = "";
		if (aux != firstPlayer) {
			msg = aux.getSymbol();
			aux = aux.getNextPlayer();
			msg += showPlayers(aux);
		}
		return msg;
	}
	//-------------------------------------------------------------------------

}