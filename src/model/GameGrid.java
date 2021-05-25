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
	
	public GameGrid() {
		
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
	/**<b> Method to create matrix rows when the rows number is even </b><br>
	 * <b> pre: </b> <br>
	 * <b> pos: </b> <br>
	 * @param i An integer that represents the row number <br>
	 * @param j An integer that represents the column number <br>
	 * @param currentFirstRow An objects of Cell type that corresponds to the first cell in every row <br>
	 */
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
	
	/**<b> Method to create the matrix columns and it is a helper method of createRow to create the matrix </b><br>
	 * <b> pre: </b> <br>
	 * <b> pos: </b> <br>
	 * @param i An integer that represents the row number <br>
	 * @param j An integer that represents the column number <br>
	 * @param prev An object of Cell type that represents the cell that is before to the current cell <br>
	 * @param rowPrev An object of Cell type that represents the cell up of the current cell <br>
	 */
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
	/**<b> Method to create matrix rows when the rows number is odd </b><br>
	 * <b> pre: </b> <br>
	 * <b> pos: </b> <br>
	 * @param i An integer that represents the row number <br>
	 * @param j An integer that represents the column number <br>
	 * @param currentFirstRow An objects of Cell type that corresponds to the first cell in every row <br>
	 */
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
	 
	/**<b> Method to create the matrix columns and it is a helper method of createRow2 to create the matrix </b><br>
	 * <b> pre: </b> <br>
	 * <b> pos: </b> <br>
	 * @param i An integer that represents the row number <br>
	 * @param j An integer that represents the column number <br>
	 * @param prev An object of Cell type that represents the cell that is before to the current cell <br>
	 * @param rowPrev An object of Cell type that represents the cell up of the current cell <br>
	 */
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
	
	//Methods to show the grid in initial state------------------------------------------------
	//this methods are basically others toString methods with other name
	public String initialGrid() {
		String msg;
		msg = initialGridRow(first);
		return msg;
	}

	private String initialGridRow(Cell firstRow) {
		String msg = "";
		if (firstRow != null) {
			msg = initialGridCol(firstRow) + "\n";
			msg += initialGridRow(firstRow.getDown());
		}
		return msg;
	}

	private String initialGridCol(Cell current) {
		String msg = "";
		if (current != null) {
			msg = current.initialState();
			msg += initialGridCol(current.getNext());
		}
		return msg;
	}
	//----------------------------------------------------------------------------------------
	
	//Methods to search a cell by number-------------------------------------------------------
	/** <b> Method to search in rows a cell by number </b><br>
	 * <b> pre: </b> number is a number between numRows * numColumns <br>
	 * <b> pos: </b> <br>
	 * @param number An integer, It represents a cell number <br>
	 * @param first An object of Cell type, It represents the first cell <br>
	 * @return A cell that corresponds with the number received as parameter <br>
	 */
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

	/** <b> This method search in columns a cell by number </b><br>
	 * <b> pre: </b> number is a number between numRows * numColumns <br>
	 * <b> pos: </b> <br>
	 * @param number An integer, It represents a cell number <br>
	 * @param next An object of Cell type, It represents the cell that is next to the current cell <br>
	 * @return A cell that corresponds with the number received as parameter <br>
	 */
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
	/** <b> Method to search in rows a snake by its char </b><br>
	 * <b> pre: </b> the parameter Cell first is not the first cell of the game grid, 
		instead of this it is the first cell depending on row number - 1. I mean, bottom row <br>
	 * <b> pos: </b> <br>
	 * @param snake A char that represents a snake within game <br>
	 * @param first An object of Cell type that corresponds to the first cell <br>
	 * @return A cell whose snakes attribute corresponds with the char received as parameter <br>
	 */
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

	/** <b> Method to search in columns a snake by its char </b><br>
	 * <b> pre: </b> next is not null <br>
	 * <b> pos: </b> <br>
	 * @param snake A char that represents a snake within game <br>
	 * @param next An object of Cell type that corresponds to the cell next to the current cell <br>
	 * @return A cell whose snakes attribute corresponds with the char received as parameter <br>
	 */
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
	/** <b> Method to search in rows a ladder by its number </b><br>
	 * <b> pre: </b> row must be a integer between the range of row number <br>
	 * <b> pos: </b> <br>
	 * @param i An integer that represents the current row number it will use as a counter <br>
	 * @param row An integer that represent the number row where is the start of the ladder <br>
	 * @param first An object of Cell type that corresponds to the first cell <br>
	 * @param ladder An integer that represents a ladder <br>
	 * @return A cell whose ladder attribute corresponds with the char received as parameter <br>
	 */
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

	/** <b> Method to search in columns a ladder by its number </b><br>
	 * <b> pre: </b> next is not null <br>
     * <b> pos: </b> <br>
	 * @param next An object of Cell type that corresponds to the cell next to the first cell <br>
	 * @param ladder An integer that represents a ladder <br>
	 * @return A cell whose ladder attribute corresponds with the char received as parameter <br>
	 */
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
	/** <b> Method to search the first corresponding to an specific row number </b><br>
	 * *<b> pre: </b> row must be an integer between the row number range <br>
	 * @param row An integer that represent the row number where we want to get the first cell <br>
	 * @param first An object of Cell type that corresponds to the first cell when the matrix is created <br>
	 * @return The first cell at the row number received as parameter <br>
	 */
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
	
	//Method to move players------------------------------------------------------------------
	/** <b> Method to move the player in the game grid </b><br>
	 * <b> pre: </b> Player is not null <br>
	 * <b> pos: </b> the player is assigned in the final cell which is defined using the current player position and dice <br>
	 * @param player An object of Player type, it represents a player within a cell <br>
	 * @param dice An integer, it is a random number between 1 and 6 <br>
	 */
	public void movePlayer(Player player, int dice) {
				
		int initialPos = player.getPosition();
		
		Cell initialCell = searchInRows(initialPos, first);
		
		int finalPos = dice + initialPos;
		
		int newMoves = player.getMoves() + 1;
	    player.setMoves(newMoves);
		
		if(finalPos >= numRows*numColumns) {
			
			Cell finalCell = searchInRows(numColumns*numRows, first);
			initialCell.deletePlayer();	
			finalCell.addPlayer(player);
			
		}
		else {
			
			Cell finalCell = searchInRows(finalPos, first);
			initialCell.deletePlayer();	
			finalCell.addPlayer(player);  
			finalCell.getFirstPlayer().setPosition(finalPos);
			
			if (finalCell.getLadder() != 0) {
				
				initialCell = finalCell;
				finalCell = searchInRows(1, finalCell.getRow(), getFirst(), finalCell.getLadder());
				if (finalCell != null) {
					initialCell.deletePlayer();
					finalCell.addPlayer(player);
					finalCell.getFirstPlayer().setPosition(finalCell.getNumber());
				}
			}
			
			if (finalCell.getSnake() != ' ') {
				initialCell = finalCell;
				Cell firstCell = searchFirst(initialCell.getRow(), getFirst());
				if (firstCell.getDown() != null) {
					
					finalCell = searchInRows(finalCell.getSnake(), firstCell.getDown());
					if (finalCell != null) {
							initialCell.deletePlayer();
							finalCell.addPlayer(player);
							finalCell.getFirstPlayer().setPosition(finalCell.getNumber());
					}

				}
					
			}
			
		}
		
	}
	
	//---------------------------------------------------------------------------------------------

}
