package binarySearch;

public class Main {
	
	/*
	 * If the exact elem is not found, return the closest larger one
	 */
	
	static int binarySearch(int val, int[] arr) {
		int start = 0, end = arr.length - 1;
		int mid = 0;
		while(start != end) {
			System.out.println("start = "+start+", mid = "+mid+", end = "+end);
			mid = (start + end)/2;
			if(arr[mid] == val) return mid;
			else if(arr[mid] > val) end = mid;
			else start = mid + 1;
		}
		System.out.println("start = "+start+", mid = "+mid);
		return start;
	}

	public static void main(String[] args) {
		int[] arr = {1, 3, 4, 5, 7, 9, 10, 14, 17, 18, 22, 25, 26, 27, 30};
		System.out.println(binarySearch(15, arr));
	}

}
