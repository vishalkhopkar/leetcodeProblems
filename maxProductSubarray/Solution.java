package maxProductSubarray;

public class Solution {

	public int maxProduct(int[] nums) {
        int maxEndingHere = 1, minEndingHere = 1;
        int maxSoFar = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
        	maxEndingHere *= nums[i];
        	minEndingHere *= nums[i];
        	if(nums[i] < 0) {
        		maxSoFar = Math.max(maxSoFar, minEndingHere);
        	}
        	else {
        		maxSoFar = Math.max(maxSoFar, maxEndingHere);
        	}
        	int t;
        	System.out.println("i = "+i+", maxsofar = "+maxSoFar+ " maxendinghere = "+maxEndingHere+", minendinghere "+minEndingHere);
        	if(maxEndingHere < minEndingHere) {
        		t = minEndingHere;
        		minEndingHere = maxEndingHere;
        		maxEndingHere = t;
        	}
        	maxEndingHere = Math.max(maxEndingHere, 1);
        	minEndingHere = Math.min(minEndingHere, 1);
        }
        return maxSoFar;
        
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {1, -3, -2};
		System.out.println(s.maxProduct(nums));

	}

}
