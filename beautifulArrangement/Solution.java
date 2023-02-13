package beautifulArrangement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

class StackNode {
	List<Integer> arrangement;
	Set<Integer> covered;
	public StackNode(List<Integer> arrangement, Set<Integer> covered) {
		super();
		this.arrangement = arrangement;
		this.covered = covered;
	}
	
	
}
public class Solution {

	public int countArrangement(int n) {
		StackNode stNode = new StackNode(new ArrayList<>(), new HashSet<>());
        
        Stack<StackNode> st = new Stack<>();
        
        st.push(stNode);
        StackNode popped;
        int ret = 0;
        while(!st.isEmpty()) {
        	popped = st.pop();
        	if(popped.arrangement.size() == n) {
        		ret++;
        	}
        	else
        		pushEligibleToStack(popped, st, n);
        }
        return ret;
    }
	
	private void pushEligibleToStack(StackNode popped, Stack<StackNode> st, int n) {
		/*
		 * filling position popped.arrangement.size() + 1
		 */
		int fillingPos = popped.arrangement.size() + 1;
		for(int i = 1; i <= n; i++) {
			if(!popped.covered.contains(i)) {
				if(i % fillingPos == 0 || fillingPos % i == 0) {
					List<Integer> newL = new ArrayList<>(popped.arrangement);
					newL.add(i);
					Set<Integer> newSet = new HashSet<>(popped.covered);
					newSet.add(i);
					st.push(new StackNode(newL, newSet));
				}
			}
			
		}
		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.countArrangement(15));

	}

}
