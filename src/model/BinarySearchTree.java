package model;

import java.io.Serializable;

public class BinarySearchTree implements Serializable {

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
	/**
	 * <b>It adds a new Winner to the binary search tree </b><br>
	 * <b> pre: </b> newWinner is not null <br>
	 * <b> pos: </b> the BST has a new element <br>
	 * @param newWinner, new winner to add
	 */
	public void addWinner(Winner newWinner) {
		if (root == null) {
			root = newWinner;
		}
		else {
			addWinner(root, newWinner);
		}
	}
	
	/**
	 * <b>Auxiliary method of addWiner, to continue recursion for finding the position </b><br>
	 * <b> pre: </b> newWinner is not null <br>
	 * <b> pos: </b> the BST has a new element <br>
	 * @param newWinner, new winner to add <br>
	 * @param curreWinner, the winner to check next element <br>
	 */
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
	
	//Method to show the content of the tree, traversing in inOrder
		
	/**
	 * <b>It collects the information into a String through inOrder traversing in the BST </b><br>
	 * <b> pre: </b> <br>
	 * <b> pos: </b> <br>
	 * @param root, root element of the BST <br>
	 * @return result, a String that contains the information of BST in descendant order <br>
	 */
	public String showTree(Winner root){
	    String result = "";
	    if (root == null)
	        return "";
	    result += showTree(root.left);
	    result += root.toString();
	    result += showTree(root.right);
	    return result;
	}
	
	
}

