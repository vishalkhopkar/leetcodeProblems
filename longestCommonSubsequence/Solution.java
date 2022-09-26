package longestCommonSubsequence;

public class Solution {
	public int longestCommonSubsequence(String text1, String text2) {
		int[][] dpTable = new int[text1.length() + 1][text2.length() + 1];
		for(int i = 0; i < text1.length(); i++) dpTable[i][0] = 0;
		for(int i = 0; i < text2.length(); i++) dpTable[0][i] = 0;
		for(int i = 1; i <= text1.length(); i++) {
			for(int j = 1; j <= text2.length(); j++) {
				if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dpTable[i][j] = dpTable[i - 1][j - 1] + 1;
				}
				else {
					dpTable[i][j] = Math.max(dpTable[i][j - 1], dpTable[i - 1][j]);
				}
			}
		}
		return dpTable[text1.length()][text2.length()];
		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.longestCommonSubsequence("fff", "ace"));

	}

}
