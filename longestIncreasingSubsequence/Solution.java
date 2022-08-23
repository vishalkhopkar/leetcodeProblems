package longestIncreasingSubsequence;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	
	int[] arr;
	
	class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			
			return arr[o1] - arr[o2];
		}
		
	}
	
	Integer[] indexSort() {
		Integer[] indexArr = new Integer[arr.length];
		for(int i = 0; i < arr.length; i++) indexArr[i] = i;
		Arrays.sort(indexArr, new MyComparator());
		return indexArr;
	}
	
	public int lengthOfLIS(int[] nums) {       
        arr = Arrays.copyOf(nums, nums.length);
        Integer[] sortedIndices = indexSort();
        int globalMaxLength = 1;
        // now we got the array sorted and the sorted array contains the indices, not the elements
        // now we shall identify the immediate maximum
        int[] immediateMax1 = new int[nums.length];
        int[] immediateMax2 = new int[nums.length];
        Arrays.fill(immediateMax1, -100);
        int[] maxPossibleLen = new int[nums.length];
        
        // by default, the last elem does not have any immediateMax
        immediateMax1[nums.length - 1] = -1;
        immediateMax2[nums.length - 1] = -1;
        maxPossibleLen[nums.length - 1] = 1;
        
        // by default, the max element in nums does not have any immediateMax either
        immediateMax1[sortedIndices[nums.length - 1]] = -1;
        immediateMax2[sortedIndices[nums.length - 1]] = -1;
        maxPossibleLen[sortedIndices[nums.length - 1]] = 1;
        
        // assign immediateMax1 for the remaining elements
        for(int i = 0; i < nums.length; i++) {
        	for(int j = i + 1; j < nums.length; j++) {
        		if(immediateMax1[sortedIndices[i]] == -100) {
        			if(nums[sortedIndices[i]] < nums[sortedIndices[j]] && sortedIndices[j] > sortedIndices[i]) {
            			immediateMax1[sortedIndices[i]] = sortedIndices[j];
            		}
        		}        		
        	}
        	if(immediateMax1[sortedIndices[i]] == -100) immediateMax1[sortedIndices[i]] = -1;
        	if(immediateMax1[sortedIndices[i]] == -1) maxPossibleLen[sortedIndices[i]] = 1;
        }
        System.out.println(Arrays.toString(immediateMax1));
        
        // assign the immediateMax2 for the remaining elems
        for(int i = 0; i < nums.length; i++) {
        	for(int j = i + 1; j < nums.length; j++) {
        		if(nums[j] > nums[i]) {
        			immediateMax2[i] = j;
        			break;
        		}
        		
        	}
        }
        System.out.println(Arrays.toString(immediateMax2));
        // assign the maxPossibleLen for remaining elems
        // this time we shall go in reverse order
        for(int i = nums.length - 2; i >= 0; i--) {
        	if(maxPossibleLen[i] != 1) {
        		maxPossibleLen[i] = Math.max(maxPossibleLen[immediateMax1[i]], maxPossibleLen[immediateMax2[i]]) + 1;
        		if(maxPossibleLen[i] > globalMaxLength) globalMaxLength = maxPossibleLen[i];
        	}
        }
        System.out.println(Arrays.toString(maxPossibleLen));
        return globalMaxLength;
    }

	public static void main(String[] args) {
		int[] nums = {-813,82,-728,-82,-432,887,-551,324,-315,306,-164,-499,-873,-613,932,177,61,52,1000,-710,372,-306,-584,-332,-500,407,399,-648,290,-866,222,562,993,-338,-590,303,-16,-134,226,-648,909,582,177,899,-343,55,629,248,333,1,-921,143,629,981,-435,681,844,349,613,457,797,695,485,15,710,-450,-775,961,-445,-905,466,942,995,-289,-397,434,-14,34,-903,314,862,-441,507,-966,525,624,-706,39,152,536,874,-364,747,-35,446,-608,-554,-411,987,-354,-700,-34,395,-977,544,-330,596,335,-612,28,586,228,-664,-841,-999,-100,-620,718,489,346,450,772,941,952,-560,58,999,-879,396,-101,897,-1000,-566,-296,-555,938,941,475,-260,-52,193,379,866,226,-611,-177,507,910,-594,-856,156,71,-946,-660,-716,-295,-927,148,620,201,706,570,-659,174,637,-293,736,-735,377,-687,-962,768,430,576,160,577,-329,175,51,699,-113,950,-364,383,5,748,-250,-644,-576,-227,603,832,-483,-237,235,893,-336,452,-526,372,-418,356,325,-180,134,-698};
		Solution s = new Solution();
		System.out.println(s.lengthOfLIS(nums));

	}

}
