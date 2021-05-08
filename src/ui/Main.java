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
		gameGrid.searchInRows(100, gameGrid.getFirst()).addPlayer(newPlayer);
//		gameGrid.searchInRows(19, gameGrid.getFirst()).setSnake('A');
//		gameGrid.searchInRows(22, gameGrid.getFirst()).setSnake('A');
//		
//		if (gameGrid.searchInRows(22, gameGrid.getFirst()).getSnake() != ' ') {
//			Cell initialCell = gameGrid.searchInRows(22, gameGrid.getFirst());
//			Cell x = gameGrid.searchFirst(initialCell.getRow(), gameGrid.getFirst());
//			if (x != null) {
//				Cell finalCell = gameGrid.searchInRows('A', x.getDown());
//				finalCell.addPlayer(newPlayer);
//				System.out.println("celda final " + finalCell);
//				initialCell.deletePlayer();
//				
//			}
//			else {
//				System.out.println("estas en la cola");
//			}
//
//		}
		
		if (gameGrid.searchInRows(gameGrid.getNumRows()*gameGrid.getNumColumns(), gameGrid.getFirst()).getFirstPlayer() != null) {
			System.out.println("holi");
		}
		
		game.setBoard(gameGrid);
		game.setRows(10);
		game.setColumns(10);
//		game.createSnakes(65, 70);
//		game.createLadders(1, 3);
//		gameGrid.movePlayer(newPlayer);
		System.out.println(gameGrid);
		
	}
	
	public Main() {
		game = new SnakesAndLadders();
		menu = new Menu(game);
		
	}

}

