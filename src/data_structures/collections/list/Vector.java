package data_structures.collections.list;

public class Vector {
	
	private static final int DEFAULT_CAPACITY = 10 ; 
	private int[] data; 
	private int size ; 
	
	public Vector(int capacity) {
		this.data = new int[capacity] ; 
		this.size = 0 ; 
	}
	
	public Vector() {
		this.data = new int[DEFAULT_CAPACITY];
		this.size = 0 ; 
	}
	
	public int size() {
		return data.length;
	}
	

	private void resize() {
		int[] bigger = new int[this.data.length*2];
		
		for ( int i = 0 ; i < this.data.length ; i++ ) {
			bigger[i] = this.data[i] ; 
		}
		
		this.data = bigger;
	}
	
	public boolean isFull() {
		return this.size == this.data.length - 1 ; 
	}
	
	public synchronized void add(int data) {
		if ( this.isFull() ) this.resize();
		this.data[size++] = data;
	}
	
	public synchronized int remove(int index) {
		if ( index < 0 || index > this.size ) return -1 ; 
		int removed = this.data[index] ; 
		for ( int i = index ; i < size - 1; i++ ) {
			this.data[i] = data[i+1] ; 
		}
		return removed;
	}
	
	public int get(int index) {
		if ( index < 0 || index > this.size ) return -1 ; 
		return this.data[index] ;
	}

	public static void main(String[] args) {
		Vector vector = new Vector(3);
        vector.add(1);
        vector.add(2);
        vector.add(3);

        System.out.println("Vector size: " + vector.size()); // Output: Vector size: 3

        System.out.println("Element at index 1: " + vector.get(1)); // Output: Element at index 1: 2

        vector.add(4);
        vector.add(5);

        System.out.println("Vector size after adding elements: " + vector.size()); // Output: Vector size after adding elements: 5

        vector.remove(2); // Removes the element at index 2 (value 3)

        System.out.println("Vector size after removal: " + vector.size()); // Output: Vector size after removal: 4

        System.out.println("Element at index 2 after removal: " + vector.get(2)); // Output: Element at index 2 after removal: 4
    
	}
}
