package model;

public class GameGrid {
	private Cell first;
	private int numRows;
	private int numColumns;
	
	
	public GameGrid(int numRows, int numColumns) {
		this.numRows = numRows;
		this.numColumns = numColumns; 
		createMatrix();
	}
	
	public Cell getFirst() {
		return first;
	}
	
	public int getNumRows() {
		return numRows;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	} 

	public int getNumColumns() {
		return numColumns;
	}

	public void setNumColumns(int numColumns) {
		this.numColumns = numColumns;
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
	
	//Methods to search a cell by number-------------------------------------------------------
	public Cell searchInRows(int number, Cell first) {
		Cell foundCell = null;
		foundCell = searchInCols(number, first.getNext());
		if(foundCell == null){
			if (first.getNumber() == number) {
				foundCell = first;

			} 
			else if (first.getDown() != null) {
				foundCell = searchInRows(number, first.getDown());
			}
		}

		return foundCell;
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
    //----------------------------------------------------------------------------------------
	
	//Methods to search a snake---------------------------------------------------------------
	/**the parameter Cell first is not the first cell of the game grid, 
	instead of this it is the first cell depending on row number - 1.
	I mean, bottom row**/
	public Cell searchInRows(char snake, Cell first) {
		Cell foundCell = null;
		foundCell = searchInCols(snake, first.getNext());
		if(foundCell == null){
			if (first != null) {
				if (first.getSnake() == snake) {
					foundCell = first;

				} 
				else if (first.getDown() != null) {
					foundCell = searchInRows(snake, first.getDown());
				}
			}
		}

		return foundCell;
	}

	private Cell searchInCols(char snake, Cell next) {
		Cell foundCell = null;
			if (next.getSnake() == snake) {
				foundCell = next;
			}
			else if (next.getNext() != null) {
				foundCell = searchInCols(snake, next.getNext());

			}
				
		return foundCell;
	}
	
 	//--------------------------------------------------------------------------------------
		
	//Methods to search a ladder------------------------------------------------------------
	public Cell searchInRows(int i, int row, Cell first, int ladder) {
		Cell foundCell = null;
		foundCell = searchInCols(first.getNext(), ladder);
		if(foundCell == null){
			if (i < row) {
				if (first.getLadder() == ladder) {
					foundCell = first;

				} 
				else if (first.getDown() != null) {
					foundCell = searchInRows(i + 1, row,first.getDown(),ladder);
				}
			}
		}

		return foundCell;
	}

	private Cell searchInCols(Cell next, int ladder) {
		Cell foundCell = null;
			if (next.getLadder() == ladder) {
				foundCell = next;
			}
			else if (next.getNext() != null) {
				foundCell = searchInCols(next.getNext(), ladder);

			}
				
		return foundCell;
	}
	//-----------------------------------------------------------------------------------------
	
	//Method to search the first cell depending on number of row-------------------------------
	public Cell searchFirst(int row, Cell first) {
		Cell foundCell = null;
		if(foundCell == null){
			if (first.getRow() == row) {
				foundCell = first;

			} 
			else if (first.getDown() != null) {
				foundCell = searchFirst(row, first.getDown());
			}
		} 

		return foundCell;
	}
	//--------------------------------------------------------------------------------------------
	
	//Method to move the players------------------------------------------------------------------
	public void movePlayer(Player player) {
		Cell lastCell = searchInRows(numRows*numColumns, first);
		if (lastCell.getFirstPlayer() != null) {//base case
			return;
		}
		int initialPos = player.getPosition();
		Cell initialCell = searchInRows(initialPos, first);
		SnakesAndLadders snl = new SnakesAndLadders();
		int finalPos = snl.throwDice() + initialPos;
		Cell finalCell = searchInRows(finalPos, first);
		finalCell.addPlayer(player);
		initialCell.deletePlayer();
		if (finalCell.getSnake() != ' ') {
			finalCell = searchInRows(finalCell.getSnake(), finalCell);
			finalCell.addPlayer(player);
		}
		if (finalCell.getLadder() != 0) {
			finalCell = searchInRows(1, finalCell.getRow(), getFirst(), finalCell.getLadder());
			finalCell.addPlayer(player);
		}
	}
	
//	public void movePlayer2(Player player) {
//		if (finalCell.getSnake() != ' ') {
//			finalCell = searchInRows(1, finalCell.getRow(), finalCell.getSnake(), getFirst());
//			finalCell.addPlayer(player);		
//		}
//	}
//	
//	public void movePlayer3() {
//		
//	}
	//---------------------------------------------------------------------------------------------

}
