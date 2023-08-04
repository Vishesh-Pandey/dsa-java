package algorithms.sort;

import java.util.Arrays;

public class SelectionSort {
	
	public static void swap(int[] arr , int first , int second) {
		int temp = arr[first] ; 
		arr[first] = arr[second] ; 
		arr[second] = temp;
	}
	
	public static void sort(int[] arr) {
		for(int i = 0 ; i < arr.length ; i++ ) {
			int si = i ; 
			for ( int j = i ; j < arr.length ; j++ ) {
				if ( arr[j] < arr[si]) {
					si = j ; 
				}
			}
			swap(arr , i , si);
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {6,3,8,2,9,7,5};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
