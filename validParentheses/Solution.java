package validParentheses;

import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isValid("{}()[()]{[()]}"));

	}
	
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		int sLength = s.length();
		if(sLength % 2 != 0) return false;
		char x;
		for(int i = 0; i < sLength; i++) {
			x = s.charAt(i);
			if(x == '(' || x == '{' || x == '[')
				stack.push(s.charAt(i));
			else {
				// closing bracket encountered
				/*
				 * If no opening bracket exists, the string is invalid
				 */
				if(stack.isEmpty()) return false;
				char top = stack.pop();
				if(!matches(top, x)) return false;
			}
			
		}
		return stack.isEmpty();
	}

	private boolean matches(char top, char x) {
		switch(top) {
		case '(':
			return (x == ')');
		case '[':
			return (x == ']');
		case '{':
			return (x == '}');
		}
		return false;
	}

}
