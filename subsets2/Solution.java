package subsets2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class MySet extends HashSet<List<Integer>> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean add(List<Integer> elem) {
		Collections.sort(elem);
		return super.add(elem);
	}
}

public class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		MySet ret = new MySet();
		Stack<List<Integer>> stack = new Stack<>();
		
		// root node
		stack.add(new ArrayList<>());
		List<Integer> popped;
		List<Integer> toBePushed;
		int lastElem;
		while(!stack.isEmpty()) {
			popped = stack.pop();
			
			// add this popped element to ret
			ret.add(convert(popped, nums));
			if(popped.size() < nums.length) {
				if(popped.size() == 0) {
					for(int i = 0; i < nums.length; i++) {
						toBePushed = new ArrayList<>();
						toBePushed.add(i);
						stack.push(toBePushed);
					}
					
				}
				else {
					lastElem = popped.get(popped.size() - 1);
					for(int i = lastElem + 1; i < nums.length; i++) {
						toBePushed = new ArrayList<>();
						toBePushed.addAll(popped);
						toBePushed.add(i);
						stack.push(toBePushed);
					}
				}
			}
			
		}
		return new ArrayList<>(ret);
	}
	private List<Integer> convert(List<Integer> popped, int[] nums) {
		if(popped.isEmpty()) return popped;
		List<Integer> ret = new ArrayList<>(nums.length);
		for(int i = 0; i < popped.size(); i++) {
			ret.add(nums[popped.get(i)]);
		}
		return ret;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {};
		System.out.println(s.subsetsWithDup(nums));

	}

}
