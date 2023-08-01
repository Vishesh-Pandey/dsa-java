package data_structures.collections.list;

public class Stack {
	final int DEFAULT_CAPACITY = 10 ;
	int top = -1 ; 
	int[] data ; 
	
	public Stack(int capacity) {
		this.data = new int[capacity];
	}
	
	public Stack() {
		this.data = new int[DEFAULT_CAPACITY];
	}
	
	public boolean isFull() {
		return this.top == this.data.length-1;
	}
	
	public boolean isEmpty() {
		return this.top == - 1; 
	}
	
	public boolean push(int data) {
		if ( this.isFull() ) return false;
		this.top++ ; 
		this.data[top] = data; 
		return true;
	}
	
	public int pop() {
		if ( this.isEmpty()) return -1 ; 
		
		int removed = this.data[top] ; 
		top--;
		return removed;
	}
	
	public int peek() {
		if ( this.isEmpty() ) return -1 ; 
		return this.data[top] ; 
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack(5);

        System.out.println("Is the stack empty? " + stack.isEmpty()); // Output: true

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Is the stack full? " + stack.isFull()); // Output: false

        System.out.println("Top element: " + stack.peek()); // Output: 3

        stack.push(4);
        stack.push(5);

        System.out.println("Is the stack full? " + stack.isFull()); // Output: true

        stack.push(6); // The stack is full, so this push will fail

        System.out.println("Popped element: " + stack.pop()); // Output: 5
        System.out.println("Popped element: " + stack.pop()); // Output: 4

        System.out.println("Top element: " + stack.peek()); // Output: 3

        System.out.println("Is the stack empty? " + stack.isEmpty()); // Output: false

        stack.pop();
        stack.pop();
        stack.pop(); // The stack is empty, so this pop will fail

        System.out.println("Is the stack empty? " + stack.isEmpty()); // Output: true
    
	}
}
