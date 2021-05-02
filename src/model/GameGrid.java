package model;

public class GameGrid {
	private Cell first;
	private int numRows;
	private int numColumns;
	
//	private int ladders;
//	private int snakes;
	
	public GameGrid(int numRows, int numColumns) {
		this.numRows = numRows;
		this.numColumns = numColumns; 
		createMatrix();
	}
	
	public Cell getFirst() {
		return first;
	}
	
	private void createMatrix() {
		if (numRows % 2 == 0) {
			
			first = new Cell(1, 1,numRows * numColumns);
			createRow(1, 1, first);
		} 
		else {
			
			first = new Cell(1, 1, numRows * numColumns - (numColumns - 1));
			createRow2(1, 1, first);
		}
	}
	
	//methods to create the matrix when the rows number is even---------------------------------
	private void createRow(int i, int j, Cell currentFirstRow) {
		createCol(i, j + 1, currentFirstRow, currentFirstRow.getUp());
		if (i < numRows) {

			if (i % 2 != 0) {
					
				Cell downFirstRow = new Cell(i + 1, j, currentFirstRow.getNumber() - (2 * numColumns - 1));
				downFirstRow.setUp(currentFirstRow);
				currentFirstRow.setDown(downFirstRow);
				createRow(i + 1, j, downFirstRow);

			} 
			else {
					
				Cell downFirstRow = new Cell(i + 1, j, currentFirstRow.getNumber() - 1);
				downFirstRow.setUp(currentFirstRow);
				currentFirstRow.setDown(downFirstRow);
				createRow(i + 1, j, downFirstRow);
			}
		}
	}

	private void createCol(int i, int j, Cell prev, Cell rowPrev) {
		if (j <= numColumns) {
				
			if (i % 2 == 0) {
					
				Cell current = new Cell(i, j, prev.getNumber() + 1);
				current.setPrevious(prev);
				prev.setNext(current);

				if (rowPrev != null) {
						
					rowPrev = rowPrev.getNext();
					current.setUp(rowPrev);
					rowPrev.setDown(current);
				}
				createCol(i, j + 1, current, rowPrev);
			} 
			else {
					
				Cell current = new Cell(i, j, prev.getNumber() - 1);
				current.setPrevious(prev);
				prev.setNext(current);

				if (rowPrev != null) {
						
					rowPrev = rowPrev.getNext();
					current.setUp(rowPrev);
					rowPrev.setDown(current);
				}
				createCol(i, j + 1, current, rowPrev);
			}
		}
	}
	//-------------------------------------------------------------------------------------------
	
	//methods to create the matrix when the rows number is odd---------------------------------
	private void createRow2(int i, int j, Cell currentFirstRow) {
		createCol2(i, j + 1, currentFirstRow, currentFirstRow.getUp());
		if (i < numRows) {
				
			if (i % 2 != 0) {
					
				Cell downFirstRow = new Cell(i + 1, j, currentFirstRow.getNumber() - 1);
				downFirstRow.setUp(currentFirstRow);
				currentFirstRow.setDown(downFirstRow);
				createRow2(i + 1, j, downFirstRow);

			}
			else {
					
				Cell downFirstRow = new Cell(i + 1, j, currentFirstRow.getNumber() - (2 * numColumns - 1));
				downFirstRow.setUp(currentFirstRow);
				currentFirstRow.setDown(downFirstRow);
				createRow2(i + 1, j, downFirstRow);
			}
		}
	}
		
	private void createCol2(int i, int j, Cell prev, Cell rowPrev) {
		if (j <= numColumns) {
				
			if (i % 2 == 0) {
					
				Cell current = new Cell(i, j, prev.getNumber() - 1);
				current.setPrevious(prev);
				prev.setNext(current);

				if (rowPrev != null) {
						
					rowPrev = rowPrev.getNext();
					current.setUp(rowPrev);
					rowPrev.setDown(current);
				}	
				createCol2(i, j + 1, current, rowPrev);
			} 
			else {
					
				Cell current = new Cell(i, j, prev.getNumber() + 1);
				current.setPrevious(prev);
				prev.setNext(current);

				if (rowPrev != null) {
						
					rowPrev = rowPrev.getNext();
					current.setUp(rowPrev);
					rowPrev.setDown(current);
				}
				createCol2(i, j + 1, current, rowPrev);
			}
		}
	}
    //-----------------------------------------------------------------------------------------
	
	//Methods to show the game grid------------------------------------------------------------
	public String toString() {
		String msg;
		msg = toStringRow(first);
		return msg;
	}

	private String toStringRow(Cell firstRow) {
		String msg = "";
		if (firstRow != null) {
			msg = toStringCol(firstRow) + "\n";
			msg += toStringRow(firstRow.getDown());
		}
		return msg;
	}

	private String toStringCol(Cell current) {
		String msg = "";
		if (current != null) {
			msg = current.toString();
			msg += toStringCol(current.getNext());
		}
		return msg;
	}
    //-----------------------------------------------------------------------------------------
	
	//Methods to search -----------------------------------------------------------------------
	public Cell searchInRows(int number, Cell first) {
		Cell foundNode = null;
		foundNode = searchInCols(number, first.getNext());
		if(foundNode == null){
			if (first.getNumber() == number ) {
				foundNode = first;

			} 
			else if (first.getDown() != null) {
				foundNode = searchInRows(number, first.getDown());
			}
		}

		return foundNode;
	}

	private Cell searchInCols(int number, Cell next) {
		Cell foundNode = null;
			if (next.getNumber() == number) {
				foundNode = next;
			}
			else if (next.getNext() != null) {
				foundNode = searchInCols(number, next.getNext());

			}
			
		return foundNode;
	}
    //-----------------------------------------------------------------------------------------
}
