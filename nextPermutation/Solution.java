package nextPermutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

class StackSetCombo extends Stack<StackNode>{
	/**
	 * adding to remove warning
	 */
	private static final long serialVersionUID = 1L;
	Set<List<Integer>> set;
	public StackSetCombo() {
		super();
		set = new HashSet<>();
	}
	
	@Override
	public StackNode push(StackNode x) {
		if(set.add(x.perm)) {
			super.push(x);
		}
		return x;
	}
	
	@Override
	public StackNode pop(){
		if(isEmpty()) throw new IndexOutOfBoundsException();
		StackNode toBePopped = super.pop();
		set.remove(toBePopped.perm);
		return toBePopped;
	}	
	
	
}
public class Solution {
	
	/**
	 * Nums can have duplicates
	 * @param nums
	 */
	private static List<Integer> permutations(int[] nums, List<Integer> lookOutFor) {
		
		boolean trigger = false;
		StackSetCombo st = new StackSetCombo();
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
				if(trigger) {
					// output this
					trigger = false;
					return popped.perm;
				}
				// all have been covered
				if(popped.perm.equals(lookOutFor)) {
					// this is the input permutation
					// return the next one
					trigger = true;
				}
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
		if(trigger) {
			// we were looking for the last one
			List<Integer> firstPerm = new ArrayList<>();
			for(int x : nums) firstPerm.add(x);
			return firstPerm;
		}
		return null;
	}
	
	public void nextPermutation(int[] nums) {
		List<Integer> lookOutFor = new ArrayList<>();
		for(int x : nums) lookOutFor.add(x);
		Arrays.sort(nums);
		List<Integer> nextPerm = permutations(nums, lookOutFor);
		for(int i = 0; i < nums.length; i++) {
			nums[i] = nextPerm.get(i);
		}
		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {3, 2, 1};
		s.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

}
