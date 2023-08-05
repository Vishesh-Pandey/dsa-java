package algorithms.sort;

import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args) {
		int[] arr = {6,3,8,2,9,7,5};
		sort(arr , 0 , arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr , int low , int high) {
		
		if ( low < high ) {
			int pi = partition(arr , low , high);
			sort(arr , low , pi-1) ;
			sort(arr , pi+1 , high) ;
		}
		
	}
	
	public static int partition(int[] arr , int low , int high) {
		
		int pivot = arr[high] ; 
		int i = low - 1 ;
		
		for( int j = low ; j < high ; j++ ) {
			if ( arr[j] < pivot ) {
				i++ ; 
				swap(arr , i , j );
			}
		}
		
		swap(arr , i+1 , high);
		
		return i+1 ;
		
	}
	
	public static void swap(int[] arr , int first , int second) {
		int temp = arr[first] ; 
		arr[first] = arr[second] ; 
		arr[second] = temp;
	}

}
