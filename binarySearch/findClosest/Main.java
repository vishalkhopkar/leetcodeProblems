package binarySearch.findClosest;

public class Main {

	private int binarySearch(int[] arr, int val) {
		
		int start = 0, end = arr.length - 1;
		int mid = 0;
		while(start != end) {
			
			mid = (start + end)/2;
			System.out.println("start = "+start+", mid = "+mid+", end = "+end);
			if(arr[mid] == val) return middleVal(arr, mid);
			else if(arr[mid] > val) end = mid;
			else start = mid + 1;
		}
		System.out.println("start = "+start+", mid = "+mid);
		if(arr[start] == val) return middleVal(arr, start);
		if(val > arr[start]) return start;
		if(start == 0) return start;
		return closest(arr, start, start - 1, val);
	}
	private int closest(int[] arr, int x, int y, int val) {
		int leftDiff = val - arr[x];
		int rightDiff = arr[y] - val;
		if(leftDiff >= rightDiff) return x;
		return y;
	}
	private int middleVal(int[] arr, int mid) {
		int c = mid, end, start;
		while(c < arr.length && arr[c] == arr[mid]) c++;
		end = c;
		c = mid;
		while(c >= 0 && arr[c] == arr[mid]) c--;
		start = c;
		
		return (start + end)/2;
	}
	public static void main(String[] args) {
		Main m = new Main();
		int[] arr = {1, 1, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 5, 6, 12, 12, 12, 13, 15, 16};
		System.out.println(m.binarySearch(arr,7));
		

	}

}
