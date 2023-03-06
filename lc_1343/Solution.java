package lc_1343;

public class Solution {

	public int numOfSubarrays(int[] arr, int k, int threshold) {
		int kSum = 0;
        for(int i = 0; i < k; i++) {
        	kSum += arr[i];
        }
        int ret = 0, end = k - 1, sumThreshold = k*threshold;
        while(end < arr.length) {
        	if(kSum >= sumThreshold) ret++;
        	end++;
        	if(end < arr.length) {
        		kSum += arr[end];
        		kSum -= arr[end - k];
        	}
        	
        }
        return ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
