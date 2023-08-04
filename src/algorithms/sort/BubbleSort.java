package algorithms.sort;

import java.util.Arrays;

public class BubbleSort {
	
	public static void swap(int[] arr , int first , int second) {
		int temp = arr[first] ; 
		arr[first] = arr[second] ; 
		arr[second] = temp;
	}
	
	public static void sort(int[] arr) {
		for ( int i = 0 ; i < arr.length - 1 ; i++ ) {
			for ( int j = 0  ; j < arr.length - 1 - i ; j++ ) {
				if ( arr[j] > arr[j+1] ) {
					swap(arr , j , j+1);
				}
			}
		}		
	}
	
	public static void main(String[] args) {
		int[] arr = {6,3,8,2,9,7,5};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
