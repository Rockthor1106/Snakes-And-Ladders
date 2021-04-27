package ui;

import model.GameGrid;

public class Main {

	public static void main(String[] args) {
//		Menu m = new Menu();
//		m.menuOptions();
		GameGrid gameGrid = new GameGrid(10, 10);
		System.out.println(gameGrid);
	}

}
