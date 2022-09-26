package binarySearch;

public class Main {
	
	/*
	 * If the exact elem is not found, return the closest larger one
	 */
	
	static int binarySearch(int val, int[] arr) {
		int start = 0, end = arr.length - 1;
		int mid = 0;
		while(start != end) {
			
			mid = (start + end)/2;
			System.out.println("start = "+start+", mid = "+mid+", end = "+end);
			if(arr[mid] == val) return mid;
			else if(arr[mid] > val) end = mid;
			else start = mid + 1;
		}
		System.out.println("start = "+start+", mid = "+mid);
		return start;
	}
	
	static int binarySearchOnDescArray(int val, int[] arr) {
		int start = 0, end = arr.length - 1;
		int mid = 0;
		while(start != end) {
			
			mid = (start + end)/2;
			System.out.println("start = "+start+", mid = "+mid+", end = "+end);
			if(arr[arr.length - 1 - mid] == val) return arr.length - 1 - mid;
			else if(arr[arr.length - 1 - mid] > val) end = mid;
			else start = mid + 1;
		}
		System.out.println("start = "+start+", mid = "+mid);
		return arr.length - 1 - start;
	}

	public static void main(String[] args) {
		//int[] arr = {1, 3, 4, 5, 7, 9, 10, 14, 17, 18, 22, 25, 26, 27, 30};
		int[] arr1 = {8, 6, 5, 4, 2};
		int[] arr = {1, 3, 4, 6, 7, 8, 14, 15, 16, 17};
		System.out.println(arr1[binarySearchOnDescArray(3, arr1)]);
	}

}
