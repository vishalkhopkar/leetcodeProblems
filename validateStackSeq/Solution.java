package validateStackSeq;

import java.util.Stack;

public class Solution {

	public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushCtr = 0, popCtr = 0;
        Stack<Integer> stack = new Stack<>();
        while(popCtr < popped.length) {
        	if((stack.isEmpty()) || (!stack.isEmpty() && stack.peek() != popped[popCtr])) {
        		if(pushCtr == pushed.length)
        			return false;
        		stack.push(pushed[pushCtr]);
        		System.out.println("pushed "+pushed[pushCtr]);
        		pushCtr++;
        	}
        	else {
        		int x = stack.pop();
        		System.out.println("popped "+x);
        		popCtr++;
        	}
        }
        if(popCtr == popped.length) return true;
        return false;
    }
	public static void main(String[] args) {
		int[] pushed = {1,2,3,4,5};
		int[] popped = {4,3,5,1,2};
		
		System.out.println(new Solution().validateStackSequences(pushed, popped));

	}

}
