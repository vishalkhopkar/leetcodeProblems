package reverseVowels;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	
	public String reverseVowels(String s) {
        int currLeft = 0, currRight = s.length() - 1;
        Set<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] arr = s.toCharArray();
        while(currLeft < currRight) {
        	
        	while(!vowels.contains(s.charAt(currLeft))) {
        		currLeft++;
        	}
        	while(!vowels.contains(s.charAt(currRight))) {
        		currRight--;
        	}
        	System.out.println("currleft "+currLeft+", currRight "+currRight);
        	// swap currLeft and currRight
        	if(currLeft < currRight)
        		swap(arr, currLeft, currRight);
        	currLeft++;
        	currRight--;
        }
        System.out.println(Arrays.toString(arr));
        return new String(arr);
    }

	private void swap(char[] arr, int currLeft, int currRight) {
		char x = arr[currLeft];
		arr[currLeft] = arr[currRight];
		arr[currRight] = x;
		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.reverseVowels("aA"));

	}

}
