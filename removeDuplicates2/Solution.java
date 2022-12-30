package removeDuplicates2;

import java.util.Arrays;

public class Solution {

	public int removeDuplicates(int[] nums) {
		
        int end = 1;
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
        	if(nums[i] == nums[i - 1]) {
        		count++;
        		if(count > 2) {
        			
        		}
        		else {
        			nums[end] = nums[i];
        			end++;
        		}
        	}
        	else {
        		count = 1;
        		nums[end] = nums[i];
        		end++;
        	}
        }
        return end;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = {0, 0, 1, 1, 1, 2, 2, 2, 2, 3, 3};
		System.out.println(s.removeDuplicates(arr));
		System.out.println(Arrays.toString(arr));

	}

}
