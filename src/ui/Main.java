package ui;

import java.util.Scanner;

import model.SnakesAndLadders;
import model.GameGrid;
import model.Player;

public class Main {
	
	public final static Scanner sc = new Scanner(System.in);
	private static SnakesAndLadders game;
	private static Menu menu;
	
	public static void main(String[] args) {
		
		Main ppal = new Main();
		
//		menu.displayOptions();
		
		GameGrid gameGrid = new GameGrid(10,10);
		Player newPlayer = new Player("#");
		gameGrid.searchInRows(1, gameGrid.getFirst()).addPlayer(newPlayer);
		
		game.setBoard(gameGrid);
		game.setRows(10);
		game.setColumns(10);
		game.createSnakes(65, 70);
		game.createLadders(1, 3);
		gameGrid.movePlayer(newPlayer);
		System.out.println(gameGrid);
	}
	
	public Main() {
		game = new SnakesAndLadders();
		menu = new Menu(game);
		
	}

}

