package ifHalvesAreAlike;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	
	Set<Character> vowelSet;
	public boolean halvesAreAlike(String s) {
		char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		List<Character> vowelList = new ArrayList<>();
		for(char x : vowels) {
			vowelList.add(x);
		}
		vowelSet = new HashSet<>(vowelList);
        return (countVowels(s.substring(0, s.length()/2)) == countVowels(s.substring(s.length()/2)));
    }
	private int countVowels(String s) {
		int ret = 0;
		for(int i = 0; i < s.length(); i++) {
			if(vowelSet.contains(s.charAt(i))) {
				ret++;
			}
		}
		
		return ret;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.halvesAreAlike("book"));

	}

}
