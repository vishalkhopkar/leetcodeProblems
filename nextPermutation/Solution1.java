package nextPermutation;

import java.util.Arrays;

public class Solution1 {
	
	public void nextPermutation(int[] nums) {
		int ptr = nums.length - 1;
		while(ptr > 0 && nums[ptr] <= nums[ptr - 1]) {
			ptr--;
		}
		if(ptr == 0) {
			// nums is a decreasing array
			reverse(nums, 0, nums.length - 1);
			return;
		}
		if(ptr == nums.length - 1) {
			// nums is an increasing array
			if(nums.length > 1)
				reverse(nums, nums.length - 2, nums.length - 1);
			return;
		}
		// Find the elem just larger than nums[ptr - 1]
		// let its index be j
		int j = binarySearch(nums, nums[ptr - 1], ptr, nums.length - 1);
		while(j >= 0 && nums[j] == nums[ptr - 1]) {
			j--;
		}
		System.out.println(" j = "+j+" ptr = "+ptr);
		// swap ptr - 1 with j and reverse the rest from ptr to nums.length - 1
		int x = nums[ptr - 1];
		nums[ptr - 1] = nums[j];
		nums[j] = x;
		reverse(nums, ptr, nums.length - 1);
		
	}
	private int binarySearch(int[] arr, int val, int x, int y) {
		System.out.println("BS val = "+val+" x = "+x+" y = "+y);
		int start = 0, end = (y - x);
		int mid = 0;
		int arrLen = (y - x + 1);
		while(start != end) {
			
			mid = (start + end)/2;
			System.out.println("start = "+start+", mid = "+mid+", end = "+end);
			if(arr[x + arrLen - 1 - mid] == val) return x + arrLen - 1 - mid;
			else if(arr[x + arrLen - 1 - mid] > val) end = mid;
			else start = mid + 1;
		}
		System.out.println("start = "+start+", mid = "+mid);
		return x + arrLen - 1 - start;
	}
	
	private void reverse(int[] nums, int start, int end) {
		if(start >= end) return;
		int x;
		for(int i = start, j = end; i <= (start + end)/2; i++, j--) {
			x = nums[i];
			nums[i] = nums[j];
			nums[j] = x;
		}
		
	}
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int[] nums = {2,2,7,5,4,3,2,2,1};
		s.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));

	}

}
