package ui;

import java.util.Scanner;

import model.SnakesAndLadders;

public class Main {
	
	public final static Scanner sc = new Scanner(System.in);
	
	private SnakesAndLadders game;
	private static Menu menu;
	
	public static void main(String[] args) {
		
		Main ppal = new Main();
		
		menu.displayOptions();
		
		//m.menuOptions();
	}
	
	public Main() {
		game = new SnakesAndLadders();
		menu = new Menu(game);
		
	}
	

}
