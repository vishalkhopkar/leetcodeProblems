package groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class LetterMap extends TreeMap<Character, Integer>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean equals(Object o) {
		LetterMap otherMap;
		Integer freq;
		try {
			otherMap = (LetterMap) o;
		} catch(Exception e) {
			return false;
		}
		for(Character x : keySet()) {
			freq = otherMap.get(x);
			if(freq == null) return false;
			if(freq != get(x)) return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int h = 0;
        for (Entry<Character, Integer> entry : entrySet())
            h += (entry.getKey().hashCode() + entry.getValue().hashCode());
        return h;
	}
	
	LetterMap(String s){
		for(int i = 0; i < s.length(); i++) {
			if(containsKey(s.charAt(i))) {
				put(s.charAt(i), get(s.charAt(i)) + 1);
			}
			else {
				put(s.charAt(i), 1);
			}
		}
	}
}
public class Solution {
	
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<LetterMap, List<String>> finalMap = new HashMap<>();
		LetterMap lm;
		List<String> anagrams;
		for(String x : strs) {
			// compute the signature of x
			/*
			 * Signature is found as follows:
			 * str = "eat"
			 * signature = {'a' : 1, 'e' : 1, 't': 1}
			 */
			lm = new LetterMap(x);
			anagrams = finalMap.get(lm);
			if(anagrams == null) {
				anagrams = new ArrayList<>();
				anagrams.add(x);
				finalMap.put(lm, anagrams);
			}
			else {
				finalMap.get(lm).add(x);
			}
		}
		return groupAnagrams(finalMap);
		
	}

	private List<List<String>> groupAnagrams(Map<LetterMap, List<String>> finalMap) {
		List<List<String>> ret = new ArrayList<>();
		List<String> l;
		for(Entry<LetterMap, List<String>> entry : finalMap.entrySet()) {
			l = new ArrayList<>();
			l.addAll(entry.getValue());
			ret.add(l);
		}
		return ret;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] listOfStrs = {"", ""};
		System.out.println(s.groupAnagrams(listOfStrs));

	}

}
