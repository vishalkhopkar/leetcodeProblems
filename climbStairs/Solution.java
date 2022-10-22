package climbStairs;

public class Solution {
	
	public int climbStairs(int n) {
        int[] dpTable = new int[n];
        dpTable[0] = 1;
        dpTable[1] = 2;
        for(int i = 2; i < n; i++) {
        	dpTable[i] = dpTable[i - 1] + dpTable[i - 2];
        }
        return dpTable[n - 1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
