package houseRobber;

public class Solution {

	public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] maxSum = new int[nums.length];
        maxSum[0] = nums[0];
        maxSum[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            maxSum[i] = Math.max(nums[i] + maxSum[i - 2], maxSum[i - 1]);
        }
        return maxSum[nums.length - 1];
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {2, 3, 2, 1, 1};
		System.out.println(s.rob(nums));

	}

}
