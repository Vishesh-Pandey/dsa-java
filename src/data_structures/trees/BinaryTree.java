package data_structures.trees;

public class BinaryTree {
	int data ; 
	BinaryTree left;
	BinaryTree right;

	public BinaryTree(int data) {
		this.data = data;
		this.left = null ;
		this.right = null ;
	}
	
	public void addLeft(BinaryTree node) {
		this.left = node;
	}
	
	public void addRight(BinaryTree node) {
		this.right = node;
	}
	
	public void displayTree() {
		displayTree(1);
	}
	
	public String getLine(int length) {
		String line = "  ";
		for ( int i = 0 ; i < length ; i++) {
			line += "   ";
		}
		return line;
	}
	
	public void displayTree(int level) {
		
		if ( this.right != null ) {
			this.right.displayTree(level+1);
		}
		
		System.out.println(getLine(level)+ " |-- " + this.data);
		
		if ( this.left != null ) {
			this.left.displayTree(level+1);
		}
		
	}
	
	public static void main(String[] args) {
		
		BinaryTree first = new BinaryTree(1);
		BinaryTree second = new BinaryTree(2);
		BinaryTree third = new BinaryTree(3);
		BinaryTree fourth = new BinaryTree(4);
		BinaryTree fifth = new BinaryTree(5);
		BinaryTree sixth = new BinaryTree(6);
		BinaryTree seventh = new BinaryTree(7);
		
		first.addLeft(second);
		first.addRight(third);
		
		second.addLeft(fourth);
		second.addRight(fifth);
		
		third.addLeft(sixth);
		third.addRight(seventh);
		
		first.displayTree();

	}

}
