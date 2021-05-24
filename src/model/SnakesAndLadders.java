package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SnakesAndLadders {
	
	private int rows;
	private int columns;
	
	private int ladders;
	private int snakes;
		
	private GameGrid gameBoard;
	
	private Player firstPlayer;
	
	private BinarySearchTree bstWinners;
	
	public final static String SAVE_PATH_FILE_WINNER = "data/winners.sal";
	
	public SnakesAndLadders() {
		
		bstWinners= new BinarySearchTree();
		
	}
	
	/**
	 * This method serializes the best players contained in bstWinners 
	 * <b> pre: </b> <br>
	 * <b> pos: </b> <br>
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void saveWinners() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_PATH_FILE_WINNER));
		oos.writeObject(bstWinners);
		oos.close();
	}
	
	/**
	 * This method loads the best winners contained in the serialized object specified in the path
	 * <b> pre: </b> <br>
	 * <b> pos: </b> <br>
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void loadWinners() throws FileNotFoundException, IOException, ClassNotFoundException {
		
	File f = new File(SAVE_PATH_FILE_WINNER);
	if(f.exists()){
	      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
	      bstWinners = (BinarySearchTree)ois.readObject();
	      ois.close();
	    }
		
	}
	
	/**
	 * This method separates the entry given by the user and calls the required methods to start the game <br>
	 * <b> pre: </b> the entry follows the format rows columns snakes ladders players(number or symbols) <br>
	 * <b> pos: gameboard is assigned, linked list strted by firstPlayer isn't empty </b> 
	 * @param entry, given by the user. entry != null, entry != ""
	 * @return 0 when the entry is correct,
	 * 1 when the snakes and ladders don't fit the grid,
	 * 2 when there's more than 9 players
	 */
	
	public int separateEntry(String entry) {
		String[] parts = entry.split(" ");
		
		rows = Integer.parseInt(parts[0]);
		columns = Integer.parseInt(parts[1]);
		snakes = Integer.parseInt(parts[2]);
		ladders= Integer.parseInt(parts[3]);
		
		String players = parts[4];
		
		if((snakes*2+ladders*2)>(rows*columns-2)) {
			return 1;
		}else if(players.length()>9) {
			return 2;
		}else if(players.length()>1) {
			createPlayers(players, 0);
			createBoard();
		}else if(players.length()==1) {
			
			try {
				int numPlayers=Integer.parseInt(players);
				createPlayersRandom(numPlayers);
				createBoard();
		    } catch (NumberFormatException e) {
		        
		    	createPlayers(players, 0);
		    	createBoard();
		    }
			
			
			
		}
		return 0;
	}
	
	
	
	/**
	 * This method creates the gameboard with the specifications given by the user, number of snakes and ladders. <br>
	 * <b> pre: </b> rows and columns != null, integers <br>
	 * <b> pos: </b> attribute gameBoard is assigned 
	 */
	private void createBoard() {
		gameBoard = new GameGrid(rows, columns);
		
		int maxSnakes = 65 + snakes-1;
		
		createSnakes(65, maxSnakes);
		
		createLadders(1, ladders);
		
		setPlayersStart();
				
	}
	
	/**
	 * This method sets all the players in the beginning of the game board <br>
	 * <b> pre: </b> firstPlayer!= null <br>
	 * <b> pos: </b> all the players in the linked list have the property "position" set in 1
	 */
	private void setPlayersStart() {
		if(firstPlayer==null) {
			
		}else {
			Cell tmp = gameBoard.searchInRows(1, gameBoard.getFirst());
			tmp.addPlayer(firstPlayer);
			
			if(firstPlayer.getNextPlayerGen().equals(firstPlayer)) {
				
			}else {
				setPlayersStart(firstPlayer.getNextPlayerGen());
			}
			
		}
	}
	
	
	/**
	 * This method is an auxiliary for setPlayersStart, in order to continue the recursion <br>
	 * <b> pre: </b> <br>
	 * <b> pos: </b> 
	 * @param add it's the player that is going to be added to Cell number 1
	 */
	private void setPlayersStart(Player add) {
		
		Cell tmp = gameBoard.searchInRows(1, gameBoard.getFirst());
		
		if(add.getNextPlayerGen().equals(firstPlayer)) {
			tmp.addPlayer(add);
		}else {
			tmp.addPlayer(add);
			setPlayersStart(add.getNextPlayerGen());
		}
		
		
	}
	
	
	/**
	 * This method generates a random symbol of the following:  * ! O X % $ # + &
	 * <b> pre: </b> <br>
	 * <b> pos: </b> <br>
	 * @return symbol, which is a String with the symbol generated
	 */
	public String generateSymbols() {
		int symbol_number = (int) (Math.random() * 9 + 1);
		String symbol = " ";
		switch (symbol_number) {
		case 1:
			symbol = "!";
			break;

		case 2:
			symbol = "O";
			break;

		case 3:
			symbol = "X";
			break;

		case 4:
			symbol = "%";
			break;
		case 5:
			symbol = "$";
			break;
		case 6:
			symbol = "#";
			break;
		case 7:
			symbol = "+";
			break;
		case 8:
			symbol = "&";
			break;
		case 9:
			symbol = "*";

		}
		
		if(symbolExist(firstPlayer, symbol)) {
			return generateSymbols();
		}else {
			return symbol;
		}

	}
	
	
	
	/**
	 * This metho verifies if some player in the game has the specified symbol in the parameter
	 * <b> pre: </b> <br>
	 * <b> pos: </b> <br>
	 * @param first, it's the first player added to the game, in order to start recursion
	 * @param symbol, it's the symbol that it's been searched for
	 * @return a boolean, true if it was found, false otherwise 
	 */
	public boolean symbolExist(Player first, String symbol) {
		if(first == null) {
			return false;
		}else {
			if(first.getSymbol().equals(symbol)) {
				return true;
			}else {
				if(!first.getNextPlayerGen().equals(firstPlayer)) {
					return symbolExist(first.getNextPlayerGen(), symbol);
				}
			}
		}
		return false;
	}

	public int throwDice() {
		int dices = (int) (Math.random() * 6 + 1); // random numbers between 1 and 6
		return dices;
	}
	
	
	
	/**
	 * This method creates the number of players contained in a String, without spaces in between
	 * and identified by their symbol <br>
	 * <b> pre: </b><br>
	 * <b> pos: </b> the linked list initiated by firstPlayer now contains symbol.length players
	 * @param symbol is the string that contains the symbols for the players
	 * @param num it's an auxiliary parameter to iterate through the String
	 */
	public void createPlayers(String symbol, int num) {
	
		if(num<symbol.length()) {
			Player newPlayer = new Player(String.valueOf(symbol.charAt(num)));
			addPlayer(newPlayer);
			createPlayers(symbol, num+1);
			
		}
	}
	
	
	/**
	 * This method creates a given number of players, each one identified by a different symbol
	 * <b> pre: </b>  <br>
	 * <b> pos: </b> the linked list initiated by firstPlayer now contains num players <br>
	 * @param num it's the number of players that will be created
	 */
	public void createPlayersRandom(int num) {
		
		if(num>0) {
			Player newPlayer = new Player(generateSymbols());
			addPlayer(newPlayer);
			createPlayersRandom(num-1);
		}
	}
	
	/**
	 * addPlayer adds a specified player to the circular linked list started and contained in firstPlayer
	 * <b> pre: </b> <br>
	 * <b> pos: </b> firstPlayer!= null and the circular linked list has a new element <br>
	 * @param newPlayer the player that is going to be added 
	 */
	public void addPlayer(Player newPlayer) {

		if(firstPlayer==null) {
			firstPlayer=newPlayer;
			firstPlayer.setNextPlayerGen(firstPlayer);
		}else {
			addPlayer(firstPlayer, newPlayer);
		}

	}

	/**
	 * auxiliary method for addPlayer in order to continue recursion
	 * <b> pre: </b> <br>
	 * <b> pos: </b> firstPlayer!= null and the circular linked list has a new element <br>
	 * @param current player to verify its next element
	 * @param newPlayer player that is going to be added 
	 */
	private void addPlayer(Player current, Player newPlayer) {

		if(current.getNextPlayerGen().equals(firstPlayer)) {
			current.setNextPlayerGen(newPlayer);
			newPlayer.setNextPlayerGen(firstPlayer);
		}else {
			addPlayer(current.getNextPlayerGen(), newPlayer);
		}

	}
	
	
	/**
	 * This method creates a defined number of snakes in random cells
	 * <b> pre: </b> gameboard is initialized and contains a GameGrid <br>
	 * <b> pos: </b> random cells of gambeboard have the attribute snake set and different than '' <br>
	 * @param code it's the ASCII code for the letter A
	 * @param max it's the ASCII code of the last snake to create, calculated as: letter A's ASCII code + number of snakes -1
	 */
	public void createSnakes(int code, int max) {
		
		if(code>max) {
			
		}else {
			
			int random = getRandom();
			
			Cell temp = gameBoard.searchInRows(random, gameBoard.getFirst());
			
			if (temp.getLadder() == 0 && temp.getSnake() == ' ') {
				int tmp2 = getRandomCell(temp.getRow());
				
				createSingleSnake(random, tmp2, code);
				createSnakes(code+1, max);
				
			}else {
				createSnakes(code, max);
			}
		}
			
	}
	
	/**
	 * This method creates a defined number of ladders in random cells
	 * <b> pre: </b> gameboard is initialized and contains a GameGrid <br>
	 * <b> pos: </b> random cells of gambeboard have the attribute ladder set and different than 0 <br>
	 * @param code it's number 1, in order to start recursion
	 * @param max it's maximum number of ladders that the game will contain 
	 */
	public void createLadders(int ladder, int max) {
		
		if(ladder>max) {
			
		}else {
			
			int random = getRandom();
	
			Cell temp = gameBoard.searchInRows(random, gameBoard.getFirst());
			
			if (temp.getLadder() == 0 && temp.getSnake() == ' ') {
				int tmp2 = getRandomCell(temp.getRow());
				
				createSingleLadder(random, tmp2, ladder);
				createLadders(ladder+1, max);
				
			}else {
				createLadders(ladder, max);
			}
		}
			
	}
	
	
	
	/**
	 * This method creates one ladder with the cells given (identified by number in the GameGrid) and the number of ladder
	 * <b> pre: </b> gameboard is initialized and contains a GameGrid  <br>
	 * <b> pos: </b> the specified cells have the attribute ladder set and different from 0 <br>
	 * @param start the number of the cell where the ladder starts. 
	 * @param end the number of the cell where the ladder ends. 
	 * @param ladder ladder identifier. 
	 */
	public void createSingleLadder(int start, int end, int ladder) {
		gameBoard.searchInRows(start, gameBoard.getFirst()).setLadder(ladder);
		
		gameBoard.searchInRows(end, gameBoard.getFirst()).setLadder(ladder);
		
	}
	
	/**
	 * This method creates one snake with the cells given (identified by number in the GameGrid) and the letter for the snake
	 * <b> pre: gameboard is initialized and contains a GameGrid </b> <br>
	 * <b> pos: the specified cells have the attribute snake set and different than '' </b> <br>
	 * @param start the number of the cell where the snake starts.
	 * @param end, the number of the cell where the snake ends. 
	 * @param code, the ASCII code which corresponds to the letter that identifies the snake
	 */
	public void createSingleSnake(int start, int end, int code) {
		gameBoard.searchInRows(start, gameBoard.getFirst()).setSnake((char)code);
		
		gameBoard.searchInRows(end, gameBoard.getFirst()).setSnake((char)code);
		
	}

	/**
	 * It returns a random cell from the gameboard that is located in a different row from the parameter given
	 * <b> pre: gameboard is initialized </b>  <br>
	 * <b> pos: </b> <br>
	 * @param row, it's the row where the random cell won't be gotten from
	 * @return a Cell from gameboard
	 */
	public int getRandomCell(int row) {
		
		int newRandom = getRandom();
		
		Cell tmpCell = gameBoard.searchInRows(newRandom, gameBoard.getFirst());
		
		
		int newRow=tmpCell.getRow();
		
		if((row<newRow || row>newRow)) {
			if(tmpCell.getLadder()==0 && tmpCell.getSnake()==' ') {
				return  newRandom;
			}else {
				return getRandomCell(row);
			}
		
		}else {
			return getRandomCell(row) ;
		}
	}
	
	
	
	/**
	 * This method generates a random integer between 1 and rows * columns
	 * <b> pre: </b> <br>
	 * <b> pos: </b> <br>
	 * @return random, which is the random generated integer
	 */
	public int getRandom() {
		
		int max = (rows*columns)-1;
		int random = (int) Math.floor(Math.random()*(max-2+1)+2);	
		
		return random;
	}
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public GameGrid getGameBoard() {
		return gameBoard;
	}
	
	public void setBoard(GameGrid game) {
		gameBoard=game;
	}
	
	public BinarySearchTree getBstWinners() {
		return bstWinners;
	}

	public int getLadders() {
		return ladders;
	}

	public int getSnakes() {
		return snakes;
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(Player firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

}
