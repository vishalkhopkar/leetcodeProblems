package permutationInString;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public boolean checkInclusion(String s1, String s2) {
        /*
         * check if a permutation of s1 is in s2
         * first, make a mapping of all chars of s1
         */
		
		int s1Len = s1.length();
		int s2Len = s2.length();
		if(s2Len < s1Len) return false;
		Map<Character, Integer> s1Mapping = getMapping(s1, 0, s1Len - 1);
		Map<Character, Integer> s2Mapping = getMapping(s2, 0, s1Len - 1);
		System.out.println("s1 mapping "+s1Mapping);
		int start = 0, end = s1Len - 1;
		/*
		 * the length of the sliding window is s1Len
		 */
		Integer x;
		do {
			System.out.println(s2.substring(start, end + 1));
			System.out.println("s2 mapping "+s2Mapping);
			if(s1Mapping.equals(s2Mapping)) return true;
			/*
			 * remove s2.charAt(start) and add s2.charAt(end + 1)
			 */
			x = s2Mapping.get(s2.charAt(start));
			s2Mapping.put(s2.charAt(start), x - 1);
			if(x == 1) s2Mapping.remove(s2.charAt(start));
			
			start++;
			end++;
			if(end >= s2Len) return false;
			
			x = s2Mapping.get(s2.charAt(end));
			if(x == null) x = 0;
			s2Mapping.put(s2.charAt(end), x + 1);
			
			
		} while(end < s2Len);
		
		return false;
		
    }
	
	private Map<Character, Integer> getMapping(String str, int start, int end){
		Map<Character, Integer> mapping = new HashMap<>();
		Integer c;
		for(int i = start; i <= end; i++) {
			c = mapping.get(str.charAt(i));
			if(c == null) {
				c = 0;
			}
			
			mapping.put(str.charAt(i), c + 1);
			
		}
		return mapping;
	}

	public static void main(String[] args) {
		String s1 = "ab", s2 = "eidbaooo";
		Solution s = new Solution();
		System.out.println(s.checkInclusion(s1, s2));

	}

}
