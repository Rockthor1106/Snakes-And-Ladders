package ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


//import model.BinarySearchTree;
import model.Player;
import model.SnakesAndLadders;
import model.Winner;

public class Menu {
	
	private String entry;
	private int start;
	private final Scanner sc = new Scanner(System.in);
	private SnakesAndLadders sal;
	
	public Menu(SnakesAndLadders snakesAndLadders) {
		sal=snakesAndLadders;
	}

	public void displayOptions() throws FileNotFoundException, IOException {
		System.out.println("Welcome to Snakes and Ladders. These are the options"+ 
				"\n 1) Play \n " + 
				"2) Show best players \n " + 
				"3) Close the game \n ");
		start = Integer.parseInt(sc.nextLine()); //this line avoid the problem when is use after nextLine() 
		
		switch (start) {
		case 1:
			System.out.println("You must type one line with number of rows, columns, snakes, stairs"+
					"\n and one symbol for every player." 
					+"In case you want the system to assign the symbols, enter the number of players at the end"+
					"\nAvailable symbols:" +
					"\n* ! O X % $ # + &"+
					"\nEntry example: 5 4 2 3 #%*");
			entry = sc.nextLine();
			int result = sal.separateEntry2(entry);
			
				switch (result) {
				case 0:
					System.out.println("Let the game begin!");
					System.out.println(sal.getGameBoard());
					
					keepGame(sal.getFirstPlayer());
					
					break;
				case 1:
					System.out.println("The number of ladders and snakes don't fit the gameboard, verify your entry");
					displayOptions();
					break;
				case 2:
					System.out.println("The number of players exceeds the maximum. Max players: 9");
					displayOptions();
				default:
					break;
				}
			break;
		case 2:
			System.out.println("^o^ Podium of the best players ^o^");
			//BinarySearchTree bSearchTree = new BinarySearchTree();
			//bSearchTree.inOrden(bSearchTree.getRoot());
			System.out.println(sal.getBstWinners().showTree(sal.getBstWinners().getRoot()));
			displayOptions();
			break;
		case 3: 
			System.exit(0);
			break;
		default:
			System.out.println("Please choose a valid option");
			displayOptions();
			break;
		}
				
	}
	
	public void registerWinner() throws FileNotFoundException, IOException {
		
		Player winner = sal.getGameBoard().searchInRows(sal.getColumns()*sal.getRows(), sal.getGameBoard().getFirst()).getFirstPlayer();
		String winnerSymbol = winner.getSymbol();
		
		System.out.println("There's a winner! Player: " + winnerSymbol + " Please, enter the nickname");
		
		String nickname = sc.nextLine();
		
		int score = winner.getMoves()* (sal.getColumns()*sal.getRows());
		
		String game = "Columns: " + sal.getColumns() + "\n" + "Rows: " + sal.getRows() + "\n" + "Snakes: " + sal.getSnakes() + "\n" + "Ladders: " + sal.getLadders();
		
		Winner newWinner = new Winner(winnerSymbol, nickname, score, game);
		
		sal.getBstWinners().addWinner(newWinner);
		sal.saveWinners();
		
		System.out.println(newWinner.toString());
		displayOptions();
	}
	
	public void keepGame(Player first) throws FileNotFoundException, IOException {
		
		System.out.println("Waiting for break line to throw dices, quit game or start simulation mode");
		
		String entry = sc.nextLine();
		
		switch (entry) {
		case "":
			int resultDice = sal.throwDice();
			
			System.out.println("The player " + first.getSymbol() + " threw the dice and got: " + resultDice);
			
			sal.getGameBoard().movePlayer(first, resultDice);
			
			System.out.println(sal.getGameBoard());
			
			if(sal.getGameBoard().searchInRows(sal.getRows()*sal.getColumns(), sal.getGameBoard().getFirst()).empty()) {
				keepGame(first.getNextPlayerGen());
			}else {
				registerWinner();
			}
			
			
			break;
		
		case "menu":
			
			System.out.println("Game ended");
			displayOptions();
			
			break;
			
		case "simul":
			
			System.out.println("Simulation mode started");
			try {
				simulMode(first);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
			
		case "num":
			System.out.println(sal.getGameBoard().initialGrid());
			keepGame(first);
			
		default:
			System.out.println("Pleaee, choose a valid option");
			keepGame(sal.getFirstPlayer());
			break;
		}
		
		
	}
	
	public void simulMode(Player first) throws InterruptedException, FileNotFoundException, IOException {
		
		int resultDice = sal.throwDice();
		
		System.out.println("The player " + first.getSymbol() + " threw the dice and got: " + resultDice);
		
		sal.getGameBoard().movePlayer(first, resultDice);
		
		System.out.println(sal.getGameBoard());
		
		if(sal.getGameBoard().searchInRows(sal.getRows()*sal.getColumns(), sal.getGameBoard().getFirst()).empty()) {
			Thread.sleep(2000);
			simulMode(first.getNextPlayerGen());
		}else {
			registerWinner();
		}
		
		
	}
	

		
}
