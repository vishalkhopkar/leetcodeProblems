package removeAdjDuplicatesString;

import java.util.Stack;

public class Solution {

	public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
        	if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
        		stack.pop();
        	}
        	else {
        		stack.push(s.charAt(i));
        	}
        }
        char[] remaining = new char[stack.size()];
        int i = remaining.length - 1;
        while(!stack.isEmpty()) {
        	remaining[i] = stack.pop();
        	i--;
        }
        return new String(remaining);
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.removeDuplicates("azxxzy"));

	}

}
