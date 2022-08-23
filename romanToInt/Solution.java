package romanToInt;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.romanToInt("XIII"));
		System.out.println(sol.romanToInt("MCMXCIX"));
		System.out.println(sol.romanToInt("XL"));
		System.out.println(sol.romanToInt("XLIX"));
	}
	
	public int romanToInt(String s) {
	     Map<Character, Integer> mapping = new HashMap<Character, Integer>();
	     mapping.put('I', 1);
	     mapping.put('V', 5);
	     mapping.put('X', 10);
	     mapping.put('L', 50);
	     mapping.put('C', 100);
	     mapping.put('D', 500);
	     mapping.put('M', 1000);
	     char[] romans = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
	     int n = s.length();
	     int currentNum, nextNum, ret = 0;
	     for(int i = 0; i < n; i++) {
	    	 /*
	    	  *  if the next letter is higher than the current one, subtract this from the next
	    	  *  for ex: XLIII = (50 - 10) + 3
	    	  *  MCMXCIX = 1000 + (1000 - 100) + (100 - 10) + (10 - 1)
	    	  *  = 1000 + 900 + 90 + 9 = 1999
	    	  */
	    	 currentNum = mapping.get(s.charAt(i));
	    	 if(i < n - 1) {
	    		 nextNum = mapping.get(s.charAt(i + 1));
		    	 if(nextNum > currentNum) {
		    		 ret += (nextNum - currentNum);
		    		 i++;
		    	 }
		    	 else ret += currentNum;
	    	 }
	    	 
	    	 else {
	    		 ret += currentNum;
	    	 }
	     }
	     return ret;
	}
}
