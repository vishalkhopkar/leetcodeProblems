package lisDp;

import java.util.Arrays;

public class Solution {
	
	public int lengthOfLIS(int[] nums) { 
		// bottom up DP approach
		/*
		 * Represents the length of the LIS starting
		 * at this index
		 * Therefore, LIS[last_ind] = 1
		 */
		int[] lis = new int[nums.length];
		lis[nums.length - 1] = 1;
		
		int localMaxima = 1;
		int globalMaxima = 1;
		
		for(int i = nums.length - 2; i >= 0; i--) {
			localMaxima = 1;
			for(int j = i + 1; j < nums.length; j++) {
				if(nums[j] > nums[i]) {
					// strictly increasing
					localMaxima = Math.max(localMaxima, 1 + lis[j]);
					
				}
			}
			lis[i] = localMaxima;
			globalMaxima = Math.max(globalMaxima, lis[i]);
		}
		System.out.println(Arrays.toString(lis));
		return globalMaxima;
	}
	
	public static void main(String[] args) {
		int[] arr = {0};
		Solution s = new Solution();
		System.out.println(s.lengthOfLIS(arr));

	}

}
