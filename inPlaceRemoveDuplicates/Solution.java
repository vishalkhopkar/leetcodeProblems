package inPlaceRemoveDuplicates;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		int[] arr = {0,1, 1,2, 3, 3, 3, 4};
		Solution s = new Solution();
		
		System.out.println(s.removeDuplicates(arr));
		System.out.println(Arrays.toString(arr));

	}
	
	public int removeDuplicates(int[] nums) {
		if(nums.length == 1) return 1;
        int curr = 1;
        int currGroupStart = 0;
        int nUnique = 1;
        while(curr < nums.length) {
        	if(nums[curr] != nums[currGroupStart]) {
        		/*
        		 * nums[curr] no longer equals the start of the group
        		 */
        		nums[++currGroupStart] = nums[curr];
        		nUnique++;
        	}
        	curr++;
        }
        return nUnique;
    }

}
