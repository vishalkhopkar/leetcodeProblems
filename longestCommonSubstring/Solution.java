package longestCommonSubstring;

import java.util.Arrays;

public class Solution {

	int[][] dp;
	private String longestCommonSubstring(String a, String b) {
		int m = a.length(), n = b.length();
		dp = new int[m + 1][n + 1];
		Arrays.fill(dp[0], 0);
		for(int i = 0; i < dp.length; i++)
			dp[i][0] = 0;
		
		int lastPosX = -1, lastPosY = -1;
		int maxLen = 0;
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if(dp[i][j] > maxLen) {
						maxLen = dp[i][j];
						lastPosX = i - 1;
						lastPosY = j - 1;
					}
				}
							
				else
					dp[i][j] = 0;
			}
		}
		/*
		 * traverse for maxLen
		 */
		
		System.out.println(maxLen);
		System.out.println(lastPosX+", "+lastPosY);
		return a.substring(lastPosX - maxLen + 1, lastPosX + 1);
		
	}
	public static void main(String[] args) {
		String a = "APPLE";
		String b = "SES";
		System.out.println(new Solution().longestCommonSubstring(a, b));

	}

}
