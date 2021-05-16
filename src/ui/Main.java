package ui;

import java.io.IOException;
import java.util.Scanner;

import model.SnakesAndLadders;

public class Main {
	
	public final static Scanner sc = new Scanner(System.in);
	private static SnakesAndLadders game;
	private static Menu menu;
	
	public static void main(String[] args) {
		
	    new Main();
		
		try {
			game.loadWinners();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		try {
			menu.displayOptions();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public Main() {
		game = new SnakesAndLadders();
		menu = new Menu(game);
	}
}

