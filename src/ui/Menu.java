package ui;

import java.util.Scanner;

import model.SnakesAndLadders;

public class Menu {
	
	private String entry;
	private int start;
	private Scanner sc = new Scanner(System.in);
	private SnakesAndLadders sal;
	
	public Menu(SnakesAndLadders snakesAndLadders) {
		sal=snakesAndLadders;
	}
	
	public void menuOptions() {
		System.out.println("Do you want to start the game?");
		System.out.println("Type the number with the option that you want to use");
		System.out.println("1. Yes or 2. No");
		start = Integer.parseInt(sc.nextLine()); //this line avoid the problem when is use after nextLine() 
		if (start == 1) {
			System.out.println("You must type one line whit number of rows, columns, snakes, stairs"+
								"\n and one symbol for every player. In case you want the system to assign the symbols, just enter the other data"+
								"\nAvailable symbols:" +
								"\n* ! O X % $ # + &"+
								"\nEntry example: 5 4 2 3 #%*");
			entry = sc.nextLine();
			
			
		}
		else if (start == 2) {
			System.exit(0); //close the program
		}
		else {
			System.out.println("There is no option available for the entered value");
		}
	}
	
	public void displayOptions() {
		int start;
		String entry; 
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
			sal.separateEntry(entry);
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
