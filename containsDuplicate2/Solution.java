package containsDuplicate2;

import java.util.Arrays;
import java.util.Comparator;


public class Solution {

	class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1 == o2) return o1 - o2;
			return arr[o1] - arr[o2];
		}
		
	}
	
	Integer[] indexSort() {
		Integer[] indexArr = new Integer[arr.length];
		for(int i = 0; i < arr.length; i++) indexArr[i] = i;
		Arrays.sort(indexArr, new MyComparator());
		return indexArr;
	}
	
	int[] arr;
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		arr = nums;
		Integer[] indices = indexSort();
		System.out.println(Arrays.toString(indices));
		for(int i = 0; i < indices.length - 1; i++) {
			if(arr[indices[i]] == arr[indices[i + 1]]) {
				if(indices[i + 1] - indices[i] <= k) return true;
			}
		}
		return false;
        
    }
	public static void main(String[] args) {
		Solution m = new Solution();
		int[] nums = {1,2,3,1};
		System.out.println(m.containsNearbyDuplicate(nums, 3));

	}

}
