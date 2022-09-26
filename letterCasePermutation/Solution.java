package letterCasePermutation;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StackNode {
	int level;
	StringBuilder sb;
	public StackNode(int level, StringBuilder sb) {
		super();
		this.level = level;
		this.sb = sb;
	}
	
}
public class Solution {
	
	public List<String> letterCasePermutation(String s) {
        List<Integer> charPositions = new ArrayList<>();
        List<String> results = new ArrayList<>();
        char x;
        for(int i = 0; i < s.length(); i++) {
        	x = s.charAt(i);
        	if((x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z')) {
        		// x is an english letter
        		charPositions.add(i);
        	}
        	
        }
        int maxLevel = charPositions.size();
        if(maxLevel == 0) {
        	results.add(s);
        	return results;
        }
        StackNode init = new StackNode(0, new StringBuilder());
        StackNode popped;
        Stack<StackNode> stack = new Stack<>();
        stack.push(init);
        StringBuilder sb1;
        while(!stack.isEmpty()) {
        	popped = stack.pop();
        	if(popped.level == maxLevel) {
        		sb1 = popped.sb;
        		if(charPositions.get(popped.level - 1) < s.length() - 1) {
        			sb1.append(s.subSequence(charPositions.get(popped.level - 1) + 1, s.length()));
        		}
        		results.add(sb1.toString());
        	}
        	else {
        		// add the char at position popped.level to sb
        		sb1 = new StringBuilder(popped.sb);
        		if(popped.level == 0) {
        			if(charPositions.get(popped.level) > 0){
        				sb1.append(s.subSequence(0, charPositions.get(popped.level)));
        			}
        		}
        		else {
        			if(charPositions.get(popped.level) - charPositions.get(popped.level - 1) > 1) {
        				sb1.append(s.subSequence(charPositions.get(popped.level - 1) + 1, charPositions.get(popped.level)));
        			}
        		}
        		sb1.append(s.charAt(charPositions.get(popped.level)));
        		stack.add(new StackNode(popped.level + 1, sb1));
        		
        		sb1 = new StringBuilder(popped.sb);
        		if(popped.level == 0) {
        			if(charPositions.get(popped.level) > 0){
        				sb1.append(s.subSequence(0, charPositions.get(popped.level)));
        			}
        		}
        		else {
        			if(charPositions.get(popped.level) - charPositions.get(popped.level - 1) > 1) {
        				sb1.append(s.subSequence(charPositions.get(popped.level - 1) + 1, charPositions.get(popped.level)));
        			}
        		}
        		sb1.append(flip(s.charAt(charPositions.get(popped.level))));
        		stack.add(new StackNode(popped.level + 1, sb1));
        	}
        }
        return results;
        
        
    }

	private char flip(char x) {
		if(x >= 'a' && x <= 'z') {
			// if x is lowercase, return the equivalent uppercase
			return (char) ('A' + x - 'a');
		}
		else {
			// if x is uppercase, return the equivalent lowercase
			return (char) ('a' + x - 'A');	
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.letterCasePermutation("3ZA1b42c"));

	}

}
