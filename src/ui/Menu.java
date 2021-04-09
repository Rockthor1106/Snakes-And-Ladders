package ui;

import java.util.Scanner;

public class Menu {
	
	String entry;
	int start;
	Scanner sc = new Scanner(System.in);
	
	public void menuOptions() {
		System.out.println("Do you want to start the game?");
		System.out.println("Type the number with the option that you want to use");
		System.out.println("1. Yes or 2. No");
		start = Integer.parseInt(sc.nextLine()); //this line avoid the problem when is use after nextLine() 
		if (start == 1) {
			System.out.println("You must type one line whit number of rows, columns, snakes, stairs"+
								"\n\t\tand one symbol for every player"+
								"\nEnable symbols:" +
								"\n* ! O X % $ # + &"+
								"\nEntry example: 5 4 2 3 #%*");
			entry = sc.nextLine();
			
		}
		else if (start == 2) {
			
		}
		else {
			System.out.println("There is no option available for the entered value");
		}
	}
}
