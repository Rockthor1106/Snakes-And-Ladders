package ui;

import java.util.Scanner;

import model.SnakesAndLadders;
import model.GameGrid;

public class Main {
	
	public final static Scanner sc = new Scanner(System.in);
	private static SnakesAndLadders game;
	private static Menu menu;
	
	public static void main(String[] args) {
		
		Main ppal = new Main();
		
		menu.displayOptions();
		
		//GameGrid gameGrid = new GameGrid(5,5);
		//System.out.println(gameGrid);
		//game.setBoard(gameGrid);
		//game.setRows(5);
		//game.setColumns(5);
		
		
		
		//game.createSnakes(65, 68);
		//game.createLadders(1, 4);
		
		//System.out.printf (gameGrid.toString());
		
		
	}
	
	public Main() {
		game = new SnakesAndLadders();
		menu = new Menu(game);
		
	}

}
