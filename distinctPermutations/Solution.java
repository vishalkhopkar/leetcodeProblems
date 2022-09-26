package distinctPermutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class StackNode {
	List<Integer> perm;
	boolean[] posIncluded;
	public StackNode(List<Integer> perm, boolean[] posIncluded) {
		super();
		this.perm = perm;
		this.posIncluded = posIncluded;
	}
	
}

public class Solution {
	
	public List<List<Integer>> permute(int[] nums) {
		Stack<StackNode> st = new Stack<>();
		List<List<Integer>> ret = new ArrayList<>();
		boolean[] initPos = new boolean[nums.length];
		Arrays.fill(initPos, false);
		StackNode stNode = new StackNode(new ArrayList<>(), initPos);
		st.push(stNode);
		StackNode popped;
		List<Integer> l;
		boolean[] pos;
		while(!st.isEmpty()) {
			popped = st.pop();
			if(popped.perm.size() == nums.length) {
				// all have been covered
				ret.add(popped.perm);
			}
			else {
				// add the children of l
				for(int i = nums.length - 1; i >= 0; i--) {
					
					if(!popped.posIncluded[i]) {
						l = new ArrayList<>();
						l.addAll(popped.perm);
						pos = Arrays.copyOf(popped.posIncluded, nums.length);
						l.add(nums[i]);
						pos[i] = true;
						stNode = new StackNode(l, pos);
						st.push(stNode);
					}
					
					
				}
			}
		}
		return ret;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {1, 2, 3, 4};
		System.out.println(s.permute(nums));

	}

}
