package data_structures.collections.list;

public class LinkedList {
	
	class Node{
		int data;
		Node next;
		
		public Node(int data ) {
			this.data = data ; 
		}
	}
	
	Node head;
	
	public LinkedList() {
		this.head = null ; 
	}
	
	public void addAtStart(int data) {
		Node node = new Node(data);
		if (this.head == null) {
			this.head = node ; 
			return ;
		}
		node.next = this.head; 
		this.head = node;
	}
	
	public void addAtEnd(int data) {
		Node node = new Node(data);
		
		if (this.head == null ) {
			this.head = node;
			return;
		}
		
		Node ptr = this.head; 
		while(ptr.next != null) ptr = ptr.next; 
		ptr.next = node;
	}

	public int removeFromStart() {
		if (this.head == null ) return -1 ;
		int removed = this.head.data;
		this.head = this.head.next ;
		return removed;
	}
	
	public int removeFromEnd() {
		if (this.head == null) return -1 ;
		if (this.head.next == null ) {
			int removed = this.head.data;
			this.head = null ;
			return removed;
		}
		Node ptr = this.head;
		while(ptr.next.next != null ) ptr = ptr.next;
		int removed = ptr.next.data; 
		ptr.next = null;
		return removed;
	}
	
	public void display() {
		if (this.head == null ) {
			System.out.println("None") ; 
			return ;
		}
		Node ptr = this.head; 
		while(ptr != null) {
			System.out.print(ptr.data + " --> ");
			ptr = ptr.next; 
		}
		System.out.println("None");
	}
	
	public static void main(String[] args) {
		// write program to test all teh methods properly and show output
		 LinkedList list = new LinkedList();

        // Test addAtStart() and display()
        list.addAtStart(3);
        list.addAtStart(2);
        list.addAtStart(1);
        System.out.println("List after adding elements at the start:");
        list.display(); // Output: 1 --> 2 --> 3 -->

        // Test addAtEnd() and display()
        list.addAtEnd(4);
        list.addAtEnd(5);
        System.out.println("List after adding elements at the end:");
        list.display(); // Output: 1 --> 2 --> 3 --> 4 --> 5 -->

        // Test removeFromStart() and display()
        int removedFromStart = list.removeFromStart();
        System.out.println("Removed from start: " + removedFromStart);
        list.display(); // Output: 2 --> 3 --> 4 --> 5 -->

        // Test removeFromEnd() and display()
        int removedFromEnd = list.removeFromEnd();
        System.out.println("Removed from end: " + removedFromEnd);
        list.display(); // Output: 2 --> 3 --> 4 -->

        // Test empty list cases for removeFromStart() and removeFromEnd()
        list.removeFromStart();
        list.removeFromEnd();
        list.removeFromEnd();
        System.out.println("List after removing all elements:");
        list.display(); // Output: (empty)

        // Test an empty list case for removeFromStart()
        removedFromStart = list.removeFromStart();
        System.out.println("Removed from start: " + removedFromStart); // Output: -1
   
	}
}
