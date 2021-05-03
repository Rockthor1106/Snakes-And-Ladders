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
	
	private Player headCell;
	
	public Cell(int row, int col, int number) {
		this.row = row;
		this.col = col;
		this.number = number;
		
		snake=' ';
		ladder=0;
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
	
	
	public void addPlayer(Player newPlayer) {
		
		if(headCell==null) {
			headCell=newPlayer;
			headCell.setNextInCell(newPlayer);
			newPlayer.setPosition(number);
		}else {
			addPlayer(headCell, newPlayer);
		}
		
	}
	
	private void addPlayer(Player current, Player newPlayer) {
		
		if(current.getNextInCell().equals(headCell)) {
			current.setNextInCell(newPlayer);
			newPlayer.setNextInCell(headCell);
			newPlayer.setPosition(number);
		}else {
			addPlayer(current.getNextInCell(), newPlayer);
		}
		
	}
	
	public Player searchPlayer(Player player) {
		
		if(headCell.equals(player)) {
			return headCell;
		}else if(headCell.getNextInCell()!= headCell){
			return searchPlayer(headCell, player);
		}else {
			return null;
		}
	}
	
	private Player searchPlayer(Player current, Player search) {
		if(current.equals(search)) {
			return current;
		}else if(current.getNextInCell()!=headCell) {
			return searchPlayer(current.getNextInCell(), search);
		}else {
			return null;
		}
	}
	
	public Player getLastPlayer(Player first) {
		if(first.getNextInCell().equals(headCell)) {
			return first;
		}else {
			return getLastPlayer(first.getNextInCell());
		}
	}
	
	public Player getPrev(Player first) {
		if(headCell.getNextInCell().equals(first)) {
			return headCell;
		}else {
			 return getPrev(headCell.getNextInCell(), first);
		}
	}
	
	public Player getPrev(Player current, Player pos) {
		if(current.getNextInCell().equals(pos)) {
			return current;
		}else {
			return getPrev(current.getNextInCell(), pos);
		}
	}
	
	public Player removePlayer(Player quit) {
		if(headCell==null) {
			return null;
		}else if(headCell.equals(quit) && headCell.getNextInCell().equals(headCell)) {
			headCell = null;
			return headCell;
		}else if(headCell.equals(quit)){
			Player temp = getLastPlayer(headCell);
			temp.setNextInCell(headCell.getNextInCell());
			headCell=headCell.getNextInCell();
			return headCell;
		}else if(getLastPlayer(headCell).equals(quit)) {
			Player tmp2 = getPrev(getLastPlayer(headCell));
			tmp2.setNextInCell(headCell);
			return getLastPlayer(headCell);
		}else {
			Player tmp2 = getPrev(quit);
			tmp2.setNextInCell(quit.getNextInCell());
			return quit;
		}
	}
	
	public String toString() {
		String msg = "";
		
		if (number >= 10) {
			//msg = "["+number+ " " + snake +  " " + ladder + "]" ;
			msg= "[" + ladder + " " +snake + getPlayers(headCell) + "]" ;
		}
		else {
			//msg = "[ "+number+"]";
			//msg= "[" + ladder + " " +snake + "]" ;
			msg= "[" + ladder + " " +snake + getPlayers(headCell) + "]" ;
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
	
	
	
	/*public String getPlayers() {
		String playersSymbol="";
		
		playersSymbol = getPlayer(headCell);
		
		return playersSymbol;
				
	}*/
	
	public String getPlayers(Player first) {
		String tos = "";
		/*if(first==null) {
			return "";
		}else {
			tos= first.toString();
			tos+= getPlayers(first.getNextInCell());
		}
		return tos;*/
		tos= first.toString();
		return tos;
	}



}
