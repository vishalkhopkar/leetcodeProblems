package fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MyArr{
	int[] elems;
	

	public MyArr(int[] elems) {
		super();
		this.elems = elems;
	}
	MyArr(int a, int b, int c, int d){
		elems = new int[4];
		elems[0] = a;
		elems[1] = b;
		elems[2] = c;
		elems[3] = d;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		Arrays.sort(elems);
		result = prime * result + Arrays.hashCode(elems);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyArr other = (MyArr) obj;
		Arrays.sort(elems);
		Arrays.sort(other.elems);
		return Arrays.equals(elems, other.elems);
	}

	@Override
	public String toString() {
		return Arrays.toString(elems);
	}
	
	
}

public class Solution {
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Set<MyArr> s = new HashSet<>();
		int sum;
		Map<Integer, Set<Integer>> positionMap = getPositionMap(nums);
		Set<Integer> positions;
        for(int i = 0; i < nums.length; i++) {
        	for(int j = (i + 1); j < nums.length; j++) {
        		for(int k = (j + 1); k < nums.length; k++) {
        			// check if the nums array contains this sum
        			sum = target - nums[i] - nums[j] - nums[k];
        			//System.out.println("i:"+i+" "+nums[i]+" j:"+j+" "+nums[j]+" k:"+k+" "+nums[k]+" sum = "+sum);
        			positions = new HashSet<>();
        			if(positionMap.containsKey(sum))
        				positions.addAll(positionMap.get(sum));
        			if(!positions.isEmpty()) {
        				// nums contains this sum somewhere
        				// check if the positions are not the same
        				if(sum == nums[i])
        					positions.remove(i);
        				if(sum == nums[j])
        					positions.remove(j);
        				if(sum == nums[k])
        					positions.remove(k);
        				if(positions.size() > 0) {
        					// the array nums still has that nums[l]
        					// such that i != j != k != l
        					s.add(new MyArr(nums[i], nums[j], nums[k], sum));
        				}
        			}
        		}
        	}
        }
        
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> retInner;
        for(MyArr x : s) {
        	retInner = new ArrayList<>();
        	for(int i : x.elems)
        		retInner.add(i);
        	ret.add(retInner);
        }
        return ret;
    }


	private Map<Integer, Set<Integer>> getPositionMap(int[] nums) {
		Map<Integer, Set<Integer>> positionMap = new HashMap<>();
		Set<Integer> positions;
		for(int i = 0; i < nums.length; i++) {
			positions = positionMap.get(nums[i]);
			if(positions == null) {
				positions = new HashSet<>();
				positionMap.put(nums[i], positions);
			}
			positions.add(i);
		}
		System.out.println(positionMap);
		return positionMap;
	}


	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {-3,-2,-1,0,0,1,2,3};
		System.out.println(s.fourSum(nums, 0));
	}

}
