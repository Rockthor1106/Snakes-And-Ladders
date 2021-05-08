package ui;

import java.util.Scanner;

import model.BinarySearchTree;
import model.Cell;
import model.GameGrid;
import model.SnakesAndLadders;

public class Menu {
	
	private String entry;
	private int start;
	private Scanner sc = new Scanner(System.in);
	private SnakesAndLadders sal;
	
	public Menu(SnakesAndLadders snakesAndLadders) {
		sal=snakesAndLadders;
	}
	
//	public void menuOptions() {
//		System.out.println("Do you want to start the game?");
//		System.out.println("Type the number with the option that you want to use");
//		System.out.println("1. Yes or 2. No");
//		start = Integer.parseInt(sc.nextLine()); //this line avoid the problem when is use after nextLine() 
//		if (start == 1) {
//			System.out.println("You must type one line whit number of rows, columns, snakes, stairs"+
//								"\n and one symbol for every player. In case you want the system to assign the symbols, just enter the other data"+
//								"\nAvailable symbols:" +
//								"\n* ! O X % $ # + &"+
//								"\nEntry example: 5 4 2 3 #%*");
//			entry = sc.nextLine();
//			
//			
//		}
//		else if (start == 2) {
//			System.exit(0); //close the program
//		}
//		else {
//			System.out.println("There is no option available for the entered value");
//		}
//	}
//	
	public void displayOptions() {
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
					
					break;
				case 1:
					System.out.println("The number of ladders and snakes don't fit the gameboard, verify your entry");
					displayOptions();
					break;
				case 2:
					System.out.println("The number o players exceds the maximum. Max players: 9");
					displayOptions();
				default:
					break;
				}
			break;
		case 2:
			System.out.println("^o^ Podium of the best players ^o^");
			BinarySearchTree bSearchTree = new BinarySearchTree();
			bSearchTree.inOrden(bSearchTree.getRoot());
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
	
//	public void registerWinner() {
//		String nickname;
//		System.out.println("Register Winner");
//		System.out.println("Type a nickname");
//		nickname = sc.nextLine();
//		BinarySearchTree binarySearchTree = new BinarySearchTree();
//		GameGrid gameGrid = new GameGrid();
//		binarySearchTree.addWinner(gameGrid.searchInRows(gameGrid.getNumRows()*gameGrid.getNumColumns(), gameGrid.getFirst()).getFirstPlayer().getSymbol(), nickname, 120, entry);
//	}
}
