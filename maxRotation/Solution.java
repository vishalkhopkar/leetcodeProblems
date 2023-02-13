package maxRotation;

public class Solution {

	public int maxRotateFunction(int[] nums) {
        /*
         * set maxSum to be the currSum
         */
		int maxSum = 0;
		int sumOfArr = 0;
		for(int i = 0; i < nums.length; i++) {
			maxSum += i*nums[i];
			sumOfArr += nums[i];
		}
		
		int currSum = maxSum;
		for(int i = 1; i < nums.length; i++) {
			currSum += (sumOfArr - nums.length*nums[nums.length - i]);
			maxSum = Math.max(maxSum, currSum);
		}
		return maxSum;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = {4, 3, 2, 6};
		System.out.println(s.maxRotateFunction(arr));

	}

}
