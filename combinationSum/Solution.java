package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
	
	class StackNode {
		List<Integer> coins;
		int currSum;
		int lastElemInd;
		public StackNode(List<Integer> coins, int currSum, int lastElemInd) {
			super();
			this.coins = coins;
			this.currSum = currSum;
			this.lastElemInd = lastElemInd;
		}
		@Override
		public String toString() {
			return "StackNode [coins=" + coins + ", currSum=" + currSum + ", lastElemInd=" + lastElemInd + "]";
		}
		
		
	}
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> l;
        StackNode sNode, popped;
        Arrays.sort(candidates);
        int newSum;
        // if the target < smallest of the candidate, it is not possible to make it
        if(target < candidates[0]) return ret;
        Stack<StackNode> stack = new Stack<>();
        for(int i = 0; i < candidates.length; i++) {
        	if(candidates[i] <= target) {
        		// add candidates only if their value is less than the target
        		l = new ArrayList<>();
        		l.add(candidates[i]);
        		sNode = new StackNode(l, candidates[i], i);
        		stack.push(sNode);
        	}
        }
        
        // DFS on this stack
        while(!stack.isEmpty()) {
        	popped = stack.pop();
        	if(popped.currSum == target) {        		
        		ret.add(popped.coins);
        	}
        	else {
        		// popped.currSum < target
        		// get the lastElemInd and add candidates from lastElemInd to the end
        		for(int i = popped.lastElemInd; i < candidates.length; i++) {
        			l = new ArrayList<>();
            		l.addAll(popped.coins);
            		l.add(candidates[i]);
            		newSum = popped.currSum + candidates[i];
            		if(newSum <= target) {
            			sNode = new StackNode(l, newSum, i);
            			stack.push(sNode);
            		}
        		}    		
        		
        		
        	}
        }
        
        return ret;
    }
	
	public static void main(String[] args) {
		int[] candidates = {2, 3, 6, 7};
		Solution s = new Solution();
		System.out.println(s.combinationSum(candidates, 80));
	}
}
