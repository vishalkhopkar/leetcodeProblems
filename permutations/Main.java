package permutations;

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
public class Main {
	
	/**
	 * Nums can have duplicates
	 * @param nums
	 */
	private static void permutations(int[] nums) {
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
			System.out.println(popped.perm);
			if(popped.perm.size() == nums.length) {
				// all have been covered
				
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
	}
	public static void main(String[] args) {
		int[] arr = {1, 5, 1};
		permutations(arr);
	}

}
