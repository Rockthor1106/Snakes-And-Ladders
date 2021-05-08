package model;

public class BinarySearchTree {
	private Winner root;
	
	public BinarySearchTree() {
		
	}
	
	public Winner getRoot() {
		return root;
	}

	public void setRoot(Winner root) {
		this.root = root;
	}
	//Methods to add players that won the game-------------------------------------------
	public void addWinner(String symbol, String nickname, int score, String game) {
		Winner newWinner = new Winner(symbol, nickname, score, game);
		
		if (root == null) {
			root = newWinner;
		}
		else {
			addWinner(root, newWinner);
		}
	}
	
	private void addWinner(Winner curreWinner, Winner newWinner) {
		if (newWinner.getScore() >= curreWinner.getScore()) {
			
			if (curreWinner.getLeft() == null) {
				curreWinner.setLeft(newWinner);
			}
			else {
				addWinner(curreWinner.getLeft(), newWinner);
			}
		}
		else {
			
			if (curreWinner.getRight() == null) {
				curreWinner.setRight(newWinner);
			}
			else {
				addWinner(curreWinner.getRight(), newWinner);
			}
		}
	}
	//---------------------------------------------------------------------------------
	
    //Method to traverse the tree in inOrden------------------------------------------------------
	public void inOrden(Winner winner) {
		if (root != null) {
			
			if (winner.left != null) {
				inOrden(winner.left);
			}
			
			System.out.println(winner);
			
			if (winner.right != null) {
				inOrden(winner.right);
			}
		}
	}
	//---------------------------------------------------------------------------------
}

