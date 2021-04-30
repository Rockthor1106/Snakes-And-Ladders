package model;

public class SnakesAndLadders {
	
	private int rows;
	private int columns;
	
	private Player firstPlayer;
	
	private GameGrid gameBoard;
	
	public Player getFirstPlayer() {
		return firstPlayer;
	}
	
	public void setBoard(GameGrid game) {
		gameBoard=game;
	}
	
	public void setFirstPlayer(Player player) {
		firstPlayer=player;
	}

	public SnakesAndLadders() {
		
	}

	public String[] separateEntry(String entry) {
		String[] parts = entry.split(" ");
		return parts;
	}
	
	/*
	 * returns 0 when the entry is correct
	 * 1 when the snakes and ladders don't fit the grid
	 * 2 when there's more than 8 players
	 */
	public int separateEntry2(String entry) {
		String[] parts = entry.split(" ");
		
		rows = Integer.parseInt(parts[0]);
		columns = Integer.parseInt(parts[1]);
		int snakes = Integer.parseInt(parts[2]);
		int ladders= Integer.parseInt(parts[3]);
		
		String players = parts[4];
		
		if((snakes*2+ladders*2)>rows*columns) {
			return 1;
		}else if(players.length()>8) {
			return 2;
		}else if(players.length()>1) {
			createPlayers(players, 0);
		}else if(players.length()==1) {
			int numPlayers=players.length();
			createPlayersRandom(numPlayers);
		}
		return 0;
	}

	public String generateSymbols() {
		int symbol_number = (int) (Math.random() * 8 + 1);
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

		}
		return symbol;

	}

	public int throwDice() {
		int dices = (int) (Math.random() * 6 + 1); // random numbers between 1 and 6
		return dices;
	}
	
	public void createPlayers(String symbol, int num) {
		
		if(num<symbol.length()) {
			Player newPlayer = new Player(String.valueOf(symbol.charAt(num)));
			addPlayer(newPlayer);
			createPlayers(symbol, num+1);
			
		}
	}
	
	public void createPlayersRandom(int num) {
		
		if(num>0) {
			Player newPlayer = new Player(generateSymbols());
			addPlayer(newPlayer);
			createPlayersRandom(num-1);
		}
	}
	
	public void addPlayer(Player current, Player newPlayer) {
	
		if(current.getNextPlayer()==null) {
			current.setNextPlayer(newPlayer);
		}else {
			Player nextPlayer = current.getNextPlayer();
			addPlayer(nextPlayer, newPlayer);
		}
	}
	
	public void addPlayer(Player newPlayer) {
		if(firstPlayer==null) {
			firstPlayer=newPlayer;
		}else {
			addPlayer(firstPlayer, newPlayer);
		}
	}
	
	public void createSnakes(int code, int max) {
		
		if(code>max) {
			
		}else {
			
			int random = getRandom();
			
			Cell temp = gameBoard.searchInRows(random, gameBoard.getFirst());
			
			if (temp.getLadder()==0 && temp.getSnake()==' ') {
				int tmp2 = getRandomCell(temp.getRow());
				
				createSingleSnake(random, tmp2, code);
				createSnakes(code+1, max);
				
			}else {
				createSnakes(code, max);
			}
		}
			
	}
	
	public void createLadders(int ladder, int max) {
		
		if(ladder>max) {
			
		}else {
			
			int random = getRandom();
	
			Cell temp = gameBoard.searchInRows(random, gameBoard.getFirst());
			
			if (temp.getLadder()==0 && temp.getSnake()==' ') {
				int tmp2 = getRandomCell(temp.getRow());
				
				createSingleLadder(random, tmp2, ladder);
				createLadders(ladder+1, max);
				
			}else {
				createLadders(ladder, max);
			}
		}
			
	}
	
	
	public void createSingleLadder(int start, int end, int ladder) {
		
		System.out.println(ladder);
		
		gameBoard.searchInRows(start, gameBoard.getFirst()).setLadder(ladder);
		
		gameBoard.searchInRows(end, gameBoard.getFirst()).setLadder(ladder);
	}
	
	public void createSingleSnake(int start, int end, int code) {
		
		System.out.println((char)code);
		
		gameBoard.searchInRows(start, gameBoard.getFirst()).setSnake((char)code);
		
		
		gameBoard.searchInRows(end, gameBoard.getFirst()).setSnake((char)code);
		
	}
	
	
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
		} else {
		
			return getRandomCell(row);
		}
		
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

	public int getRandom() {
		
		
		int max = (rows*columns)-1;
		int random = (int) Math.floor(Math.random()*(max-2+1)+2);
		//return (int) (Math.random() * (rows*columns-1) + 2);
		
		return random;
	}
	
	
	
}
