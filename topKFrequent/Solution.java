package topKFrequent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
		List<Integer> distinctNums = new ArrayList<>(nums.length);
		Integer val;
		for(int i = 0; i < nums.length; i++) {
			val = frequencies.get(nums[i]);
			if(val == null) {
				frequencies.put(nums[i], 1);
				distinctNums.add(nums[i]);
			}
			else frequencies.put(nums[i], ++val);
		}
		System.out.println(distinctNums);
		Collections.sort(distinctNums, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return frequencies.get(o2) - frequencies.get(o1);
			}
			
		});
		int[] ret = new int[k];
		int c = 0;
		for(int i = 0; i < k; i++) {
			ret[i] = distinctNums.get(i);
		}
		
		return ret;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {4,1,-1,2,-1,2,3,2};
		System.out.println(Arrays.toString(s.topKFrequent(nums,2)));

	}

}
