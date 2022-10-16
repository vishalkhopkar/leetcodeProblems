package findKClosestElements.real;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> ret = new ArrayList<>();
		if(k == 0) return ret;
		if(k >= arr.length) {
			for(int x1 : arr) ret.add(x1);
			return ret;
		}
		int pos = binarySearch(arr, x);
		System.out.println("pos "+pos);
		int left = pos - 1, right = pos + 1;
		int leftDiff, rightDiff, noOfElems = 1;
		int orgLeft = pos, orgRight = pos;
		while(noOfElems < k) {
			System.out.println("left = "+left+", right = "+right);
			if(left < 0) {
				orgRight = right;
				right++;
			}
			else if(right >= arr.length) {
				orgLeft = left;
				left--;
			}
			else {
				leftDiff = x - arr[left];
				rightDiff = arr[right] - x;
				if(leftDiff <= rightDiff) {
					orgLeft = left;
					left--;
				}
				else {
					orgRight = right;
					right++;
				}
			}
			noOfElems++;
			
		}
		System.out.println("orgleft "+orgLeft+", orgRight = "+orgRight);
		left = Math.max(left, 0);
		right = Math.min(right, arr.length - 1);
		for(int i = orgLeft; i <= orgRight; i++) ret.add(arr[i]);
		return ret;
	}

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
		return closest(arr, start - 1, start, val);
	}
	private int closest(int[] arr, int x, int y, int val) {
		System.out.println("x = "+x+", y =  "+y);
		int leftDiff = val - arr[x];
		int rightDiff = arr[y] - val;
		System.out.println("leftdiff "+leftDiff+", rightDiff = "+rightDiff);
		if(leftDiff <= rightDiff) return x;
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
		Solution s = new Solution();
		//int[] arr = {0,1,1,1,2,3, 6, 6,6,7,8,9};
		int[] arr = {1,1,1,10,10,10};
		System.out.println(s.findClosestElements(arr, 1, 9));

	}

}
