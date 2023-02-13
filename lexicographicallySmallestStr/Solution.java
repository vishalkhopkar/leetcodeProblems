package lexicographicallySmallestStr;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution {

	public String smallestEquivalentString(String s1, String s2, String baseStr) {
        List<Set<Character>> collection = new ArrayList<>(26);
        Set<Character> t, u, res;
        for(int i = 0; i < 26; i++) {
        	t = new TreeSet<>();
        	t.add((char)('a' + i));
        	collection.add(t);
        }
        char s1A, s2A;
        for(int i = 0; i < s1.length(); i++) {
        	/*
        	 * equate s1[i] and s2[i]
        	 */
        	s1A = s1.charAt(i);
        	s2A = s2.charAt(i);
        	t = collection.get(s1A - 'a');
        	u = collection.get(s2A - 'a');
        	if(!t.equals(u)) {
        		t.addAll(u);
        		collection.set(s2A - 'a', t);
        		for(char x : u) {
        			collection.set(x - 'a', t);
        		}
        	}
        }
        
        for(int i = 0; i < 26; i++) {
        	System.out.println((char)('a' + i)+" : "+collection.get(i));
        }
        
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++) {
        	s1A = collection.get(baseStr.charAt(i) - 'a').iterator().next();
        	ret.append(s1A);
        }
        return ret.toString();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.smallestEquivalentString("leetcode", "programs", "aauccacada"));

	}

}
