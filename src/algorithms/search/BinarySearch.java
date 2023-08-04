package algorithms.search;

public class BinarySearch {
	
	public static int search(int [] arr , int element) {
		int start = 0 ; 
		int end = arr.length - 1 ; 
		
		while ( start < end ) {
			int mid = (start + end )/2; 
			
			if ( element == arr[mid]) return mid ; 
			
			else if ( element < arr[mid]) end = mid-1 ;
			
			else start = mid + 1 ;
		}
		
		return -1 ; // element not found
	}
	
	public static void main(String[] args) {
		
	}

}
