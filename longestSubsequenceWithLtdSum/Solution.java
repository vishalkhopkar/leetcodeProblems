package longestSubsequenceWithLtdSum;

import java.util.Arrays;

public class Solution {

	public int[] answerQueries(int[] nums, int[] queries) {
        int[] ret = new int[queries.length];
        Arrays.sort(nums);
        
        /*
         * find the sum of the entire array
         */
        int sum = 0;
        for(Integer x : nums) sum += x;
        
        int currSum;
        int elemCtr = nums.length - 1;
        for(int i = 0; i < queries.length; i++) {
        	currSum = sum;
        	elemCtr = nums.length - 1;
        	while(elemCtr >= 0 && currSum > queries[i]) {
        		currSum -= nums[elemCtr--];
        	}
        	ret[i] = elemCtr + 1;
        }
        return ret;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {4, 5, 2, 1};
		int[] queries = {3, 10, 21};
		System.out.println(Arrays.toString(s.answerQueries(nums, queries)));

	}

}
