package longestPalindromicSubstring.try2;

public class Solution {
	public String longestPalindrome(String s) {
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		int maxStart = 0, maxEnd = 0;
		for(int i = 0; i < s.length(); i++) {
			isPalindrome[i][i] = true;
		}
		for(int i = 0; i < s.length() - 1; i++) {
			isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
			if(isPalindrome[i][i + 1]) {
				maxStart = i;
				maxEnd = i + 1;
			}
		}
		for(int round = 2; round < s.length(); round++) {
			for(int i = 0, j = round + i; i < s.length() - round; i++, j++) {
				// comparing s[i] and s[j]
				if(s.charAt(i) != s.charAt(j)) isPalindrome[i][j] = false;
				else {
					// s[i] == s[j]
					if(isPalindrome[i + 1][j - 1]) {
						isPalindrome[i][j] = true;
						maxStart = i;
						maxEnd = j;
					}
				}
			}
		}
		return s.substring(maxStart, maxEnd + 1);
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.longestPalindrome("cbbd"));
	}
}
