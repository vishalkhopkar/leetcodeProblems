package findKClosestElements;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /*
         * Use binary search to find the element
         * just smaller than or equal to x in arr
         */
		int pos = binarySearch(arr, x);
		System.out.println("pos = "+pos);
		List<Integer> ret = new ArrayList<>();
		if(k >= arr.length) {
			
			// exceeding the array on both sides
			// return the entire array
			for(int i = 0; i < arr.length; i++) ret.add(arr[i]);
			return ret;
			
		}
		int start, end;
		if(k % 2 != 0) {
			/*
			 * k is odd
			 * go (k - 1)/2 right of pos, (k - 1)/2 left of pos
			 * if we exceed the array length anywhere, compensate it
			 * on the other side
			 */
			start = pos - (k - 1)/2;
			end = pos + (k - 1)/2;
			
		}
		else {
			/*
			 * k is even
			 * 
			 */
			start = pos - k/2;
			end = pos + (k - 2)/2;
		}
		
		// k is strictly less than the array length
		if(start < 0) {
			end += (-1* start);
			start = 0;
		}
		else if(end >= arr.length) {
			start -= -1*(arr.length - 1 - end);
			end = arr.length - 1;
		}
		for(int i = start; i <= end; i++) ret.add(arr[i]);
		return ret;
    }

	private int binarySearch(int[] arr, int val) {
		
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
		if(val == arr[start])
			return start;
		if(val > arr[start])
			return start;
		if(start == 0)
			return start - 1;
		int leftDiff = val - arr[start - 1];
		int rightDiff = arr[start] - val;
		return (leftDiff > rightDiff) ? start : start - 1;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = {0,1,1,1,2,3,6,7,8,9};
		//int[] arr = {1,1,1,10,10,10};
		System.out.println(s.findClosestElements(arr, 9, 4));

	}

}
