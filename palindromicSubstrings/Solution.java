package palindromicSubstrings;

public class Solution {
	public int countSubstrings(String s) {
		int ret = 0;
		boolean[][] isPalindrome = new boolean[s.length()][s.length()];
		int maxStart = 0, maxEnd = 0;
		for(int i = 0; i < s.length(); i++) {
			isPalindrome[i][i] = true;
			ret++;
		}
		for(int i = 0; i < s.length() - 1; i++) {
			isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
			if(isPalindrome[i][i + 1]) {
				ret++;
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
						ret++;
					}
				}
			}
		}
		return ret;
	}
	public static void main(String[] args) {
		

	}

}
