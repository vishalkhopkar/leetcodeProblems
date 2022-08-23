package medianSorted;

import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr1 = {1, 4, 7, 9, 19};
		int[] arr2 = {3, 7, 8, 10, 14, 19};
		System.out.println(s.findMedianSortedArrays(arr1, arr2));

	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
	    int n1 = nums1.length;
	    int[] newNums1 = new int[n1 + 1];
	    newNums1 = Arrays.copyOfRange(nums1, 0, n1 + 1);
	    int n2 = nums2.length;
	    int[] newNums2 = new int[n2 + 1];
	    newNums2 = Arrays.copyOfRange(nums2, 0, n2 + 1);
	    newNums1[n1] = Integer.MAX_VALUE;
	    newNums2[n2] = Integer.MAX_VALUE;
	    int n = n1 + n2;
	    int[] res = new int[n/2 + 1];
	    int i = 0, j = 0, k = 0;
	    while(k < res.length) {
	    	if(newNums1[i] < newNums2[j]) {
	    		res[k] = newNums1[i];
	    		i++;
	    	}
	    	else {
	    		res[k] = newNums2[j];
	    		j++;
	    	}
	    	k++;
	    	
	    }
	    System.out.println(Arrays.toString(res));
	    if(n % 2 == 0) return (double)(res[n/2] + res[n/2 - 1])/2;
	    return res[n/2];
	}

}
