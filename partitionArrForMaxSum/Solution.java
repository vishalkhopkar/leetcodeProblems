package partitionArrForMaxSum;

import java.util.Arrays;

public class Solution {

	int[][] maxMatrix;
	int[] dp;
	public int maxSumAfterPartitioning(int[] arr, int k) {
        /*
         * create the max array first
         */
		maxMatrix = new int[arr.length][arr.length];
		dp = new int[arr.length];
		Arrays.fill(dp, -1);
		int max;
		for(int i = 0; i < arr.length; i++) {
			
			maxMatrix[i][i] = arr[i];
			max = arr[i];
			for(int j = i + 1; j < arr.length; j++) {
				max = Math.max(max, arr[j]);
				maxMatrix[i][j] = max;
			}
			System.out.println(Arrays.toString(maxMatrix[i]));
		}
		return maxSum(arr, 0, k);
    }
	
	private int maxSum(int[] arr, int start, int k) {
		System.out.printf("MS(%d)\n", start);
		int n = arr.length - start;
		if(n <= k) return maxMatrix[start][arr.length - 1]*n;
		int max = 0, val;
		for(int i = 0; i < k; i++) {
			val = maxMatrix[start][start + i]*(i + 1) + maxSum(arr, start + i + 1, k);
			max = Math.max(val, max);
		}
		dp[start] = max;
		return max;
	}

	public static void main(String[] args) {
		int[] arr = {1,4,1,5,7,3,6,1,9,9,3};
		System.out.println(new Solution().maxSumAfterPartitioning(arr, 4));
	}

}
