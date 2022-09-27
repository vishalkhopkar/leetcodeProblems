package jumpGame2;

import java.util.Arrays;

public class Solution {
	
	int[][] dpTable;
	public int jump(int[] nums) {
		
		dpTable = new int[nums.length][nums.length];
		for(int i = 0; i < nums.length; i++) {
			Arrays.fill(dpTable[i], -1);
		}
        return minSteps(nums, 0, 0);
    }
	
	int minSteps(int[] arr, int pos, int currStep) {
		System.out.println("minSteps("+pos+", "+currStep+")");
		if(dpTable[pos][currStep] > -1) return dpTable[pos][currStep];
		if(pos == arr.length - 1) return currStep;
		
		int minRet = Integer.MAX_VALUE;
		for(int i = 1; i <= arr[pos]; i++) {
			if(pos + i < arr.length)
				minRet = Math.min(minRet, minSteps(arr, pos + i, currStep + 1));
		}
		System.out.println("minSteps("+pos+", "+currStep+") = "+minRet);
		dpTable[pos][currStep] = minRet;
		return minRet;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] jumps = {1, 1, 1, 1};
		System.out.println(s.jump(jumps));
	}

}
