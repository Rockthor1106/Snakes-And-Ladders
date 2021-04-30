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
	
	public String toString() {
		String msg = "";
		if (number >= 10) {
			//msg = "["+number+ " " + snake +  " " + ladder + "]" ;
			msg= "[" + ladder + " " +snake+ "]" ;
		}
		else {
			//msg = "[ "+number+"]";
			msg= "[" + ladder + " " +snake + "]" ;
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
    
}
