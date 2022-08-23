package longestPalindrome;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	public int longestPalindrome(String s) {
        // get the frequencies of all letters in s
		Map<Character, Integer> letterFrequencies = new HashMap<>();
		Integer frequency;
		for(int i = 0; i < s.length(); i++) {
			frequency = letterFrequencies.get(s.charAt(i));
			if(frequency == null) {
				// letter encountered for the first time
				letterFrequencies.put(s.charAt(i), 1);
			}
			else {
				letterFrequencies.put(s.charAt(i), ++frequency);
			}
			
		}
		int noOfOddFreqLetters = 0;
		// find the number of letters with odd frequencies
		for(char x : letterFrequencies.keySet()) {
			frequency = letterFrequencies.get(x);
			if(frequency % 2 != 0) noOfOddFreqLetters++;
		}
		
		return (noOfOddFreqLetters > 0) ? s.length() - noOfOddFreqLetters + 1 : s.length();
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.longestPalindrome("dccaccd"));
	}
}
