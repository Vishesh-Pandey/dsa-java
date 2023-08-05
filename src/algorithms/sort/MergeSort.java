package algorithms.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {6,3,8,2,9,7,5};
		arr = sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static int[] sort(int[] arr ) {
		if ( arr.length <= 1) {
			return arr;
		}
		
		int mid = (arr.length)/2 ; 
		
		int[] left = sort(Arrays.copyOfRange(arr , 0 , mid));
		int[] right = sort(Arrays.copyOfRange(arr ,  mid , arr.length));
		
		return merge(left , right);
	}
	
	public static int[] merge(int[] arr1 ,int[] arr2) {
		
		int[] combined = new int[arr1.length + arr2.length];
		
		int i = 0 ; 
		int j = 0 ; 
		int k = 0 ; 
		
		while ( i < arr1.length && j < arr2.length ) {
			if ( arr1[i] < arr2[j] ) {
				combined[k] = arr1[i] ; 
				i++ ; 
			}
			else {
				combined[k] = arr2[j] ; 
				j++ ; 
			}
			k++ ; 
		}
		
		while( i < arr1.length ) {
			combined[k] = arr1[i] ; 
			i++ ; 
			k++ ; 
		}
		
		while( j < arr2.length ) {
			combined[k] = arr2[j] ; 
			j++ ; 
			k++ ; 
		}
		
		return combined;
		
	}

}
