package increasingTriplet;

public class Solution {
	
	public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
        	// using <= as we need a strictly increasing subsequence
        	// else we would use <
        	if(nums[i] <= min1) {
        		min1 = nums[i];
        	}
        	else if(nums[i] <= min2) {
        		min2 = nums[i];
        	}
        	else {
        		// nums[i] > min1 and nums[i] > min2
        		// already min2 > min1
        		return true;
        	}
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
