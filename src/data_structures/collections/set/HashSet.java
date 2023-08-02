package data_structures.collections.set;

import java.util.LinkedList;

public class HashSet<E> {
	private static final int INITIAL_CAPACITY = 16 ; 
	private LinkedList<E>[] table; 
	private int size ; 
	
	public HashSet() {
		this.table = new LinkedList[INITIAL_CAPACITY];
		this.size = 0 ; 
	}
	
	private int hashFunction(E element) {
		return element.hashCode()% table.length  ;
	}
	
	public void add(E element) {
		int index = this.hashFunction(element);
		if ( table[index] == null ) {
			table[index] = new LinkedList<>();
		}
		if ( !table[index].contains(element)) {
			table[index].add(element);
			this.size++ ; 
		}
	}
	
	public void remove(E element) {
		int index = this.hashFunction(element);
		if (table[index] != null ) {
			table[index].remove(element);
			this.size--;
		}
	}
	
	public boolean contains(E element) {
		int index = this.hashFunction(element);
		return table[index] != null && table[index].contains(element);
	}
	
	public int size() {
		return this.size; 
	}
	
	public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println("Set size: " + set.size()); // Output: Set size: 3

        set.remove(2);

        System.out.println("Set size after removal: " + set.size()); // Output: Set size after removal: 2
    }
	
}
