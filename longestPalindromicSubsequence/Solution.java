package longestPalindromicSubsequence;

public class Solution {
	
	public int longestPalindromeSubseq(String s) {
		int[][] dpTable = new int[s.length()][s.length()];
		for(int i = 0; i < s.length(); i++) dpTable[i][i] = 1;
		for(int i = 0; i < s.length() - 1; i++) {
			dpTable[i][i + 1] = (s.charAt(i) == s.charAt(i + 1)) ? 2 : 1;
		}
		for(int round = 2; round < s.length(); round++) {
			for(int i = 0, j = round + i; i < s.length() - round; i++, j++) {
				dpTable[i][j] = (s.charAt(i) == s.charAt(j)) ?
						dpTable[i + 1][j - 1] + 2 : Math.max(dpTable[i + 1][j], dpTable[i][j - 1]);			
			}
		}
		return dpTable[0][s.length() - 1];
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.longestPalindromeSubseq("bbbab"));
		System.out.println(s.longestPalindromeSubseq("cbbd"));

	}

}
