package pivotRotation;

public class Solution {
	
	public int search(int[] nums, int target) {
		if(nums.length == 1) {
			if(nums[0] == target) return 0;
			return -1;
		}
		if(nums[0] > target && nums[nums.length - 1] < target) {
			return -1;
		}
		int pivotPos = findPivot(nums);
		System.out.println("pivot "+pivotPos);
		if(nums[pivotPos] == target) return pivotPos;
		if(target < nums[0]) {
			return binarySearch(nums, target, pivotPos + 1, nums.length - 1);
		}
		// target > nums[0]
		return binarySearch(nums, target, 0, pivotPos - 1);
	}
	
	private int findPivot(int[] nums) {
		if(nums.length == 1) return 0;
		if(nums.length == 2) return (nums[0] > nums[1]) ? 0 : 1;
		int start = 0, end = nums.length - 1, mid = -1;
		while((end - start) > 1) {
			if(nums[end] > nums[start]) return end;
			mid = (start + end)/2;
			System.out.println("start = "+start+" mid = "+mid+" end = "+end);
			if(nums[mid] > nums[end]) {
				// pivot lies to the right of mid
				start = mid;
			}
			else {
				// nums[mid] < nums[end]
				end = mid - 1;
			}
		}
		return (nums[start] > nums[end]) ? start : end;
	}
	
	private int binarySearch(int[] arr, int val, int x, int y) {
		System.out.println("BS(x = "+x+" y = "+y+")");
		if(y == x) return (arr[x] == val) ? x : -1;
		if(y < x) return -1;
		int start = x, end = y, mid = -1;
		while(start != end) {			
			mid = (start + end)/2;
			//System.out.println("start = "+start+", mid = "+mid+", end = "+end);
			if(arr[mid] == val) return mid;
			else if(arr[mid] > val) end = mid;
			else start = mid + 1;
		}
		//System.out.println("start = "+start+", mid = "+mid);
		return (arr[start] == val) ? start : -1;
	}

	public static void main(String[] args) {
		int[] nums = {4, 4, 4, 4};
		Solution s = new Solution();
		System.out.println(nums[s.findPivot(nums)]);
		System.out.println(s.search(nums, 8));
	}

}
