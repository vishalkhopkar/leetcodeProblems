package removeStarsFromStr;

import java.util.Stack;

public class Solution {

	public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        char x;
        for(int i = 0; i < s.length(); i++) {
        	x = s.charAt(i);
        	if(x >= 'a' && x <= 'z') {
        		st.push(x);
        	}
        	else {
        		/*
        		 * x is '*'
        		 */
        		st.pop();
        	}
        }
        
        char[] res = new char[st.size()];
        for(int i = 0; i < st.size(); i++) {
        	res[i] = st.get(i);
        }
        return String.valueOf(res);
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.removeStars("leet**cod*e"));

	}

}
