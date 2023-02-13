package kadane;

public class Solution {

	public int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        for(int i = 0; i < nums.length; i++) {
        	maxEndingHere += nums[i];
        	maxSoFar = Math.max(maxEndingHere, maxSoFar);
        	maxEndingHere = Math.max(maxEndingHere, 0);
        }
        return maxSoFar;
    }

	public static void main(String[] args) {
		int[] arr = {-3, -2, -1, -4, -5};
		Solution s = new Solution();
		System.out.println(s.maxSubArray(arr));
	}

}
