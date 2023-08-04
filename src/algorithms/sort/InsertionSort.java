package algorithms.sort;

import java.util.Arrays;

public class InsertionSort {
	
	public static void swap(int[] arr , int first , int second) {
		int temp = arr[first] ; 
		arr[first] = arr[second] ; 
		arr[second] = temp;
	}
	
	public static void sort(int[] arr) {
		
		for ( int i = 1 ; i < arr.length ; i++) {
			int element = arr[i] ; 
			int j = i - 1 ; 
			while ( j >= 0 && element < arr[j]) {
				arr[j+1] = arr[j] ; 
				j--;
			}
			arr[j+1] = element ; 
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr = {6,3,8,2,9,7,5};
		sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
