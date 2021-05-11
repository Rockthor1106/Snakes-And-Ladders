package model;

import java.io.Serializable;

public class BinarySearchTree implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	public void addWinner(Winner newWinner) {
//		Winner newWinner = new Winner(symbol, nickname, score, game);	
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
			
			System.out.println(winner + "\n");
			
			if (winner.right != null) {
				inOrden(winner.right);
			}
		}
	}
	//---------------------------------------------------------------------------------
	
	//Method to show the content of the tree 
		
	public String showTree(Winner root){
	    String result = "";
	    if (root == null)
	        return "";
	    /*if(root.left!=null) {
	    	
	    }*/
	    result += showTree(root.left);
	    result += root.toString();
	    result += showTree(root.right);
	    return result;
	}
	
	
}

