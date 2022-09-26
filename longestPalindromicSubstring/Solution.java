package longestPalindromicSubstring;

public class Solution {
	public String longestPalindrome(String s) {
		
		boolean[][] dpTable = new boolean[s.length()][s.length()];
		int maxLenUntilNow = 1, maxStart = 0, maxEnd = 0;
		for(int i = 0; i < s.length(); i++) {
			dpTable[i][i] = true;
		}
		for(int i = 0; i < s.length(); i++) {
			for(int j = i + 1; j < s.length(); j++) {
				if(isPalindrome(s, i, j)) {
					dpTable[i][j] = true;
					if(j - i + 1 > maxLenUntilNow) {
						maxStart = i;
						maxEnd = j;
						maxLenUntilNow = j - i + 1;
						
					}
				}
			}
			if(maxLenUntilNow >= (s.length() - i - 1)) {
				// found the max possible length, so we can stop
				break;
			}
			
		}
		return s.substring(maxStart, maxEnd + 1);
	}
	
	private boolean isPalindrome(String s, int start, int end) {
		for(int i = start; i <= (start + end)/2; i++) {
			if(s.charAt(i) != s.charAt(end - i + start)) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.longestPalindrome("bababefcccfebabab"));

	}

}
