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
		
		//menu.displayOptions();
		
		GameGrid gameGrid = new GameGrid(10,10);
		System.out.println(gameGrid);
		
		game.setBoard(gameGrid);
		game.setRows(10);
		game.setColumns(10);
		
		
		
		game.createSnakes(65, 90);
		game.createLadders(1, 23);
		
		System.out.printf (gameGrid.toString());
		
		//m.menuOptions();
	}
	
	public Main() {
		game = new SnakesAndLadders();
		menu = new Menu(game);
		
	}

}
