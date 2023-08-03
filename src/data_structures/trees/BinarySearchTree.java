package data_structures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	int data ; 
	BinarySearchTree left ; 
	BinarySearchTree right ; 
	
	public BinarySearchTree(int data) {
		this.data = data ; 
		this.left = null ; 
		this.right = null ; 
	}
	
	public void bfs() {
	
	    Queue<BinarySearchTree> queue = new LinkedList<>();
	    queue.offer(this);

	    while (!queue.isEmpty()) {
	        BinarySearchTree current = queue.poll();
	        System.out.println(current.data);

	        if (current.left != null) {
	            queue.offer(current.left);
	        }

	        if (current.right != null) {
	            queue.offer(current.right);
	        }
	    }
	}

	
	public boolean addChild(int data) {
		if ( data == this.data ) {
			return false;
		}
		else if ( data < this.data ) {
			if ( this.left == null ) {
				this.left = new BinarySearchTree(data);
				return true;
			}
			else {
				return this.left.addChild(data);
			}
		}
		else {
			if ( this.right == null) {
				this.right = new BinarySearchTree(data);
				return true;
			}
			else {
				return this.right.addChild(data);
			}
		}
	}
	
	public String getLine(int length) {
		String line = "  ";
		for ( int i = 0 ; i < length ; i++) {
			line += "  ";
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
	
	public int minValue() {
		if ( this.left == null ) {
			return this.data;
		}
		
		return this.left.minValue();
	}
	
	public int maxValue() {
		if ( this.right == null ) {
			return this.data;
		}
		
		return this.right.maxValue();
	}
	
	public BinarySearchTree minNode() {
		if ( this.left == null ) {
			return this;
		}
		return this.left.minNode();
	}
	
	public BinarySearchTree remove(int data) {
		
		if (data < this.data) {
			if ( this.left == null ) {
				return null;
			}
			else {	
				this.left = this.left.remove(data);
			}
		}
		else if( data > this.data ) {
			if ( this.right == null ) {
				return null;
			}
			else {				
				this.right = this.right.remove(data);
			}
		}
		else {
			
			// both the childs are null
			if ( this.left == null && this.right == null ) {
				return null;
			}
			
			// case - 2: one of the child is null 
			if ( this.left == null ) {
				return this.right;
			}
			else if ( this.right == null ) {
				return this.left;
			}
			
			//case -3: has two child
			int successor_value = this.right.minValue();
			
			this.data = successor_value;
			
			this.right = this.right.remove(successor_value);	
		}
		
		return this;
	}
	
	public ArrayList<Integer> inOrderTraversal(ArrayList<Integer> inOrder){
			
		if(this.left != null) {
			this.left.inOrderTraversal(inOrder);
		}
		inOrder.add(this.data);
		if(this.right != null) {
			this.right.inOrderTraversal(inOrder);
		}
		return inOrder;
	}
	
	public ArrayList<Integer> preOrderTraversal(ArrayList<Integer> preOrder){
		
		preOrder.add(this.data);
		if(this.left != null) {
			this.left.preOrderTraversal(preOrder);
		}
		if(this.right != null) {
			this.right.preOrderTraversal(preOrder);
		}
		
		return preOrder;
		
	}
	
	public ArrayList<Integer> postOrderTraversal(ArrayList<Integer> postOrder){
		
		if(this.left != null) {
			this.left.postOrderTraversal(postOrder);
		}
		if(this.right != null) {
			this.right.postOrderTraversal(postOrder);
		}
		
		postOrder.add(this.data);

		return postOrder;
		
	}

	
	
	
	public static void main(String[] args) {
		BinarySearchTree root = new BinarySearchTree(5);
		
		root.addChild(7);
		root.addChild(2);
		root.addChild(6);
		root.addChild(9);
		root.addChild(3);
		root.addChild(0);
		
		System.out.println("Binary Search Tree: ");
		root.displayTree(0);
		
		System.out.println("Max value: " + root.minValue());
		System.out.println("Min value: " + root.maxValue());
		
		ArrayList<Integer> inOrder = new ArrayList<>();
		ArrayList<Integer> preOrder = new ArrayList<>();
		ArrayList<Integer> postOrder = new ArrayList<>();

		System.out.println("DFS : ");
		System.out.println("In order:" + root.inOrderTraversal(inOrder));
		System.out.println("Pre order:" + root.preOrderTraversal(preOrder));
		System.out.println("Post order:" + root.postOrderTraversal(postOrder));
		
		System.out.println("BFS : ");
		root.bfs();
		
		root.remove(2);
		System.out.println("After removing 2 : ");
		root.displayTree(0);
		
	}
}
