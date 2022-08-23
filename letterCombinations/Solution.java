package letterCombinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	
	char[][] possibleLetters = {{}, {}, {'a', 'b', 'c'},
	                            {'d', 'e', 'f'},
	                            {'g', 'h', 'i'},
	                            {'j', 'k', 'l'},
	                            {'m', 'n', 'o'},
	                            {'p', 'q', 'r', 's'},
	                            {'t', 'u', 'v'},
	                            {'w', 'x', 'y', 'z'}};
	
	
	public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        int totalDigits = digits.length();
        if(totalDigits == 0) return ret;
        int currLength, newDigit;
        // get the first digit
        int firstDigit = Integer.parseInt(digits.substring(0, 1));
        Stack<String> permutations = new Stack<>();
        // add all possible letters of the first digit to the stack
        for(int i = 0; i < possibleLetters[firstDigit].length; i++) {
        	permutations.push(String.valueOf(possibleLetters[firstDigit][i]));
        }
        
        // perform a DFS on this stack 'permutations'
        while(!permutations.isEmpty()) {
        	String popped = permutations.pop();
        	currLength = popped.length();
        	if(currLength == totalDigits) {
        		// no more additions possible here, this is a final permutation
        		ret.add(popped);
        	}
        	else {
        		// permutations possible here, go on
        		newDigit = Integer.parseInt(digits.substring(currLength, currLength + 1));
        		for(int i = 0; i < possibleLetters[newDigit].length; i++) {
                	permutations.push(popped+String.valueOf(possibleLetters[newDigit][i]));
                }
        	}
        }
        return ret;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.letterCombinations(""));

	}

}
