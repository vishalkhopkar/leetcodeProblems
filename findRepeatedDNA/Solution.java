package findRepeatedDNA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

	private static final int CON_LEN = 10;
	
	public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<>();
        int sLen = s.length();
        if(sLen < CON_LEN) return ret;
        if(sLen == CON_LEN) {
        	ret.add(s);
        	return ret;
        }
        int start = 0, end = CON_LEN - 1;
        Set<Integer> uniqueHashes = new HashSet<>();
        Set<Integer> doneHashes = new HashSet<>();
        Map<Character, Integer> mappings = new HashMap<>();
        mappings.put('A', 0);
        mappings.put('C', 1);
        mappings.put('G', 2);
        mappings.put('T', 3);
        int uniqueChars = mappings.size();
        /*
         * find the initial hash value
         */
        int hashVal = 0;
        int mappingVal;
        for(int i = start; i <= end; i++) {
        	mappingVal = mappings.get(s.charAt(i));
        	hashVal += mappingVal*Math.pow(uniqueChars, CON_LEN - i - 1);        	
        }
        System.out.println(hashVal);
        uniqueHashes.add(hashVal);
        while(end < sLen) {
        	mappingVal = mappings.get(s.charAt(start));
        	hashVal -= mappingVal*Math.pow(uniqueChars, CON_LEN - 1);
        	start++;
        	end++;
        	if(end >= sLen) break;
        	hashVal*=uniqueChars;
        	hashVal += mappings.get(s.charAt(end));
        	System.out.println("end = "+end+" hashval = "+hashVal);
        	if(!uniqueHashes.add(hashVal) && !doneHashes.contains(hashVal)) {
        		System.out.println("adding");
        		ret.add(s.substring(start, end + 1));
        		doneHashes.add(hashVal);
        	}
        }
        return ret;
        
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		//System.out.println(s.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
		System.out.println(s.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
	}

}
