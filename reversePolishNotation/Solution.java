package reversePolishNotation;

import java.util.Stack;

public class Solution {

	public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int op1, op2;
        for(int i = 0; i < tokens.length; i++) {
        	try {
        		op1 = Integer.parseInt(tokens[i]);
        		st.push(op1);
        	} catch(NumberFormatException e) {
        		// operator
        		op2 = st.pop();
        		op1 = st.pop();
        		switch(tokens[i]) {
        		case "+": op1 += op2; break;
        		case "-": op1 -= op2; break;
        		case "*": op1 *= op2; break;
        		case "/": op1 /= op2; break;
        		}
        		st.push(op1);
        	}
        	
        }
        return st.pop();
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		System.out.println(s.evalRPN(tokens));

	}

}
