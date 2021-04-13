package model;

public class SnakesAndLadders {

	public String[] separateEntry(String entry) {
		String[] parts = entry.split(" ");
		return parts;
	}

	public String generateSymbols() {
		int symbol_number = (int) (Math.random() * 8 + 1);
		String symbol = " ";
		switch (symbol_number) {
		case 1:
			symbol = "!";
			break;

		case 2:
			symbol = "O";
			break;

		case 3:
			symbol = "X";
			break;

		case 4:
			symbol = "%";
			break;
		case 5:
			symbol = "$";
			break;
		case 6:
			symbol = "#";
			break;
		case 7:
			symbol = "+";
			break;
		case 8:
			symbol = "&";
			break;

		}
		return symbol;

	}

	public int throwDice() {
		int dices = (int) (Math.random() * 6 + 1); // random numbers between 1 and 6
		return dices;
	}
}
