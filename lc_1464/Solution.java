package lc_1464;

public class Solution {

	public int maxProduct(int[] nums) {
        /*
            find the max and second max elem in the array
        */
		int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
		int minDiff = Integer.MAX_VALUE;
		int diff;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] >= max) {
				secondMax = max;
				
				max = nums[i];
				if(secondMax != Integer.MIN_VALUE)
					minDiff = max - secondMax;
				
					
			}
			else {
				diff = max - nums[i];
				if(diff <= minDiff) {
					secondMax = nums[i];
					minDiff = diff;
				}
			}
		}
		System.out.println("max = "+max+", secondMax = "+secondMax);
		return max*secondMax;
		
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {10, 2, 5, 2};
		System.out.println(s.maxProduct(nums));

	}

}
