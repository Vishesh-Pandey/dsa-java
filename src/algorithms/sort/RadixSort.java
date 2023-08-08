package algorithms.sort;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		int[] arr = {3,4,1,2,2,32,345,31,356,54,567,676,544};
		radixSort(arr );
		System.out.println(Arrays.toString(arr));
	}
	
	public static void radixSort(int[] arr) {
		
		int max = Integer.MIN_VALUE; 
		
		for ( int value : arr ) {
			if ( value > max ) {
				max = value; 
			}
		}
		
		int exp = 1 ; 
		
		while ( exp <= max ) {
			countSort(arr , exp);
			exp = exp * 10 ; 
		}
		
	}
	
	public static void countSort(int[] arr , int exp) {
		
		int[] farr = new int[10] ; 
		
		// finding frequency 
		for ( int i = 0 ; i < arr.length ; i++ ) {
			int value = arr[i]/exp%10 ; 
			farr[value]++ ; 
		}
		
		// prefix sum array
		for ( int i = 1 ; i < farr.length ; i++ ) {
			farr[i] = farr[i] + farr[i-1] ; 
		}
		
		int[] sorted = new int[arr.length] ; 
		
		for ( int i = arr.length - 1 ; i >= 0 ; i-- ) {
			int value = arr[i]/exp%10 ; 
			int pos = farr[value];
			int index = pos - 1 ;
			sorted[index] = arr[i]; 
			farr[value]-- ; 
		}
		
		for ( int i = 0 ; i < arr.length ; i++ ) {
			arr[i] = sorted[i] ; 
		}
		
	}
}
