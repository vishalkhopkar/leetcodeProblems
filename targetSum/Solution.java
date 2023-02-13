package targetSum;

public class Solution {

	int[] sumArr;
	public int findTargetSumWays(int[] nums, int target) {
        sumArr = new int[nums.length];
        sumArr[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	sumArr[i] = sumArr[i - 1] + nums[i];
        }
        
        return noOfWays(nums, nums.length - 1, target);
    }
	
	private int noOfWays(int[] nums, int end, int target) {
		System.out.println("NW("+end+", "+target+")");
		if(end == 0) {
			int ret = 0;
			if(nums[end] == target) ret++;
			if((-1)*nums[end] == target) ret++;
			return ret;
		}
			
		return noOfWays(nums, end - 1, target - nums[end]) + noOfWays(nums, end - 1, target + nums[end]);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {1, 0};
		System.out.println(s.findTargetSumWays(nums, 1));
	}

}
