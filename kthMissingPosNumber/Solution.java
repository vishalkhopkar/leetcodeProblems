package kthMissingPosNumber;

public class Solution {

	public int findKthPositive(int[] arr, int k) {
        int currK = 0;
        int toBeFound = 1;
        int c = 0;
        while(c < arr.length) {
        	if(arr[c] != toBeFound) {
        		currK++;
        		if(currK == k) {
        			return toBeFound;
        		}
        	}
        	else {
        		c++;
        	}
        	toBeFound++;
        }
        System.out.println("currK "+currK);
        return arr[arr.length - 1] + k;
    }

	public static void main(String[] args) {
		int[] arr = {1,13,18};
		System.out.println(new Solution().findKthPositive(arr, 17));

	}

}
