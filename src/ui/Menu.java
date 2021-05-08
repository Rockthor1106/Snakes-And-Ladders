package ui;

import java.util.Scanner;

import model.BinarySearchTree;
import model.SnakesAndLadders;

public class Menu {
	
	private String entry;
	private int start;
	private Scanner sc = new Scanner(System.in);
	private SnakesAndLadders sal;
	
	public Menu(SnakesAndLadders snakesAndLadders) {
		sal=snakesAndLadders;
	}

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
