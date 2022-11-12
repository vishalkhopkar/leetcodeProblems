package minimumSubstringWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution {
	
	public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        
        // if t is larger, it is not possible to create a window
        if(sLen < tLen) return "";
        
        /*
         * If the lengths are equal then
         * s must be equal to t
         */
        
        
        // create tMap and sMap
        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> sMapCount = new HashMap<>();
        Map<Character, List<Integer>> sMapPositions = new HashMap<>();
        
        List<Integer> tPositions = new ArrayList<>();
        
        Integer r;
        for(int i = 0; i < tLen; i++) {
        	r = tMap.get(t.charAt(i));
        	if(r == null) {
        		tMap.put(t.charAt(i), 1);
        	}
        	else {
        		tMap.put(t.charAt(i), r + 1);        		
        	}
        }
        
        int count = tLen;
        List<Integer> p;
        for(int i = 0; i < sLen; i++) {
        	if(tMap.containsKey(s.charAt(i))){
        		r = sMapCount.get(s.charAt(i));
        		if(r == null) {
        			sMapCount.put(s.charAt(i), 1);
        			p = new ArrayList<>();
        			p.add(i);
        			sMapPositions.put(s.charAt(i), p);
        		}
        		else {
        			sMapCount.put(s.charAt(i), r + 1);
        			p = sMapPositions.get(s.charAt(i));
        			p.add(i);
        		}
        		tPositions.add(i);
        	}
        }
        
        Iterator<Map.Entry<Character, Integer>> it = sMapCount.entrySet().iterator();
        Map.Entry<Character, Integer> entry;
        while(it.hasNext()) {
        	entry = it.next();
        	if(tMap.get(entry.getKey()) > entry.getValue()) {
        		return "";
        	}
        }
        
        //System.out.println(tMap);
       //System.out.println(sMapCount);
        //System.out.println(sMapPositions);
        //System.out.println(tPositions);
        
        int tPositionsPtr = 0;
        Map<Character, Integer> tMapCopy = new HashMap<>(tMap);
        int start = 0, end = 0;
        
        int minLen = Integer.MAX_VALUE;
        String minLenStr = "";
        while(tPositionsPtr < tPositions.size()) {
        	//System.out.println("tPosition ptr at "+tPositions.get(tPositionsPtr));
        	start = tPositions.get(tPositionsPtr);        	
        	//System.out.println(tMap);
        	//if(end == sLen) end = sLen - 1;
        	if(end < sLen) {
        		while(count != 0) {
            		r = tMap.get(s.charAt(end));
            		if(r != null) {
            			tMap.put(s.charAt(end), r - 1);
            			if(r > 0)
            				count--;
            		}
            		end++;
            		if(end >= sLen) {
            			end = sLen;
            			break;
            		}
            	}
        	}
        	
        	//System.out.println(s.substring(start, end));
        	if(count == 0) {
        		
        		if(end - start < minLen) {
        			minLen = end - start;
        			minLenStr = s.substring(start, end);
        		}
        	}
        	
        	//System.out.println("count "+count);
        	
        	// to compensate for moving the ptr by 1
        	
        	r = tMap.get(s.charAt(tPositions.get(tPositionsPtr)));
        	//System.out.println(tMap);
        	tMap.put(s.charAt(tPositions.get(tPositionsPtr)), r + 1);
        	if(r >= 0) {
        		count++;
        	}
        	tPositionsPtr++;
        	
        }
        return minLenStr;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.minWindow("ABC", "CBA"));

	}

}
