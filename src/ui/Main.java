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
//		Player newPlayer2 = new Player("$");
//		Player newPlayer3 = new Player("%");
//		Player newPlayer4 = new Player("&");
//		Player newPlayer5 = new Player("/");
//		Player newPlayer6 = new Player("?");
////		
//		gameGrid.searchInRows(1, gameGrid.getFirst()).addPlayer(newPlayer);
//		gameGrid.searchInRows(1, gameGrid.getFirst()).addPlayer(newPlayer2);
//		gameGrid.searchInRows(1, gameGrid.getFirst()).addPlayer(newPlayer3);
//		gameGrid.searchInRows(1, gameGrid.getFirst()).addPlayer(newPlayer4);
//		gameGrid.searchInRows(1, gameGrid.getFirst()).addPlayer(newPlayer5);
//		gameGrid.searchInRows(1, gameGrid.getFirst()).addPlayer(newPlayer6);
////	
////		
//		game.setBoard(gameGrid);
//		game.setRows(10);
//		game.setColumns(10);
//		game.createSnakes(65, 70);
//		game.createLadders(1, 3);
//		
//		System.out.println("Inicia");
//		
//		System.out.println(gameGrid);
//		
//		
//		System.out.println("Eliminar");
//		
//		gameGrid.searchInRows(1, gameGrid.getFirst()).deletePlayer();
//		
//		System.out.println(gameGrid);
//		
//		System.out.println("Mover");
//		
//		gameGrid.searchInRows(4, gameGrid.getFirst()).addPlayer(newPlayer);
//		
//		System.out.println(gameGrid);
		
		
		
//		gameGrid.movePlayer(newPlayer);
		
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

