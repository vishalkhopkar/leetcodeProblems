package kmp;

import java.util.Arrays;

public class Main {

	public int strStr(String haystack, String needle) {
        int patLength = needle.length();
        int textLength = haystack.length();
        
        if(patLength > textLength) return -1;
        if(patLength == textLength)
        	return haystack.equals(needle) ? 0 : -1;
        
        /*
         * actual KMP starts
         */
        int[] index = createIndex(needle, patLength);
        System.out.println(Arrays.toString(index));
        int i = 0, j = -1;
        while(i < textLength) {
        	//System.out.println("comparing text["+i+"] and pattern["+(j + 1)+"]");
        	if(haystack.charAt(i) == needle.charAt(j + 1)) {
        		i++;
        		j++;
        		System.out.println("now j "+j);
        		if(j == patLength - 1) {
        			return i - patLength;
        		}
        	}
        	else {
        		if(j >= 0) {
        			j = index[j];
        		}
        		else {
        			i++;
        		}
        	}
        }
        
        return -1;
    }

	private int[] createIndex(String needle, int patLength) {
		int[] index = new int[patLength];
		int[] loc = new int[26];
		char x;
		index[0] = -1;
		int k = -1;
		for(int i = 1; i < patLength; i++) {
			x = needle.charAt(i);
			while(k >= 0 & needle.charAt(i) != needle.charAt(k + 1)) {
				k = index[k];
			}
			if(needle.charAt(k + 1) == needle.charAt(i)) k++;
			index[i] = k;
		}
		return index;
	}

	public static void main(String[] args) {
		Main m = new Main();
		System.out.println(m.strStr("aabaaabaaac", "abbab"));

	}

}
