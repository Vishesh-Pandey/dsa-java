package algorithms.search;

public class LinearSearch {
	
	public static int search(int[] arr , int element) {
		for ( int i = 0 ; i < arr.length ; i++ ) {
			if ( element == arr[i]) {
				return i ; 
			}
		}
		return -1 ; // element not found
	}
	
	public static void main(String[] args) {
		int[] arr = {6,3,8,2,9,7,5};
		int position = search(arr , 2);
		System.out.println("Element present at:" + position);
	}

}
