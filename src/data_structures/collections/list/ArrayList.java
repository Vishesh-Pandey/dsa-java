package data_structures.collections.list;

import java.util.Arrays;

public class ArrayList {
	private static int INITIAL_CAPACITY = 10 ;
	private int[] data ; 
	private int size ; 
	
	public ArrayList(int capacity) {
		data = new int[capacity];
		size = 0 ;
	}
	
	public ArrayList() {
		this(INITIAL_CAPACITY);
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public boolean isFull() {
		return this.size == this.data.length;
	}
	
	public void resize() {
		int[] bigger = new int[data.length*2];
		
		for ( int i = 0 ; i < data.length ; i++) {
			bigger[i] = this.data[i];
		}
		
		data = bigger;
	}
	
	public void add(int data) {
		if (isFull()) {
			resize();
		}
		this.data[size++] = data;
	}
	
	public int remove() {
		if (isEmpty()) {
			return -1 ; 
		}
		return this.data[--size];
	}
	
	public String toString() {
		return Arrays.toString(this.data);
	}
	
	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList();
		
		for ( int i = 0  ; i < 5 ; i++ ) {
			arrayList.add(i);
		}
		
		System.out.println(arrayList);
		arrayList.remove();
		arrayList.add(99);
		System.out.println(arrayList);
		
	}
}
