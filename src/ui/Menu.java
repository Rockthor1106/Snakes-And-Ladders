package ui;

import java.util.Scanner;

import model.Cell;
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
					
					System.out.println(sal.getGameBoard().toString());
					
					/*int dice = sal.throwDice();
					
					System.out.println(dice);
					
					sal.getFirstPlayer().setPosition(sal.getFirstPlayer().getPosition()+dice);
					
					int newPos = sal.getFirstPlayer().getPosition();
					
					Cell tmpCell = sal.getGameBoard().searchInRows(newPos, sal.getGameBoard().getFirst());
					
					tmpCell.addPlayer(sal.getFirstPlayer());
					
					System.out.println(sal.getGameBoard().toString());*/
					
				
					
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
}
