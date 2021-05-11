package ui;

import java.io.IOException;
import java.util.Scanner;

import model.SnakesAndLadders;
import model.Winner;
import model.BinarySearchTree;
import model.Cell;
import model.GameGrid;
import model.Player;

public class Main {
	
	public final static Scanner sc = new Scanner(System.in);
	private static SnakesAndLadders game;
	private static Menu menu;
	
	public static void main(String[] args) {
		
		Main ppal = new Main();
		
		try {
			game.loadWinners();
		} catch (ClassNotFoundException | IOException e) {
		
			e.printStackTrace();
		}
		
//		GameGrid gameGrid = new GameGrid(10,10);
//		Player newPlayer = new Player("#");
//		gameGrid.searchInRows(22, gameGrid.getFirst()).addPlayer(newPlayer);
//		gameGrid.searchInRows(22, gameGrid.getFirst()).setSnake('A');
//		gameGrid.searchInRows(2, gameGrid.getFirst()).setSnake('A');
//		Cell finalCell = gameGrid.searchInRows(22, gameGrid.getFirst());
//		if (finalCell.getSnake() != ' ') {
//				Cell firstCell = gameGrid.searchFirst(finalCell.getRow(), gameGrid.getFirst());
//				if (firstCell.getDown() != null) {
//					finalCell = gameGrid.searchInRows('A', firstCell.getDown());
//					finalCell.addPlayer(newPlayer);
//				}
//				else {
//					System.out.println("cola");
//				}
//
//		}
//		System.out.println(gameGrid);
		
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

