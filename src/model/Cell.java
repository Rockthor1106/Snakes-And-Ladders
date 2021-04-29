package model;

public class Cell{
	
	private int number;
	
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
			msg = "["+number+"]";
		}
		else {
			msg = "[ "+number+"]";
		}
		return msg;
	}
}
