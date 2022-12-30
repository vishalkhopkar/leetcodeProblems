package perfectSquares;

public class Solution {

	int[] dpTable;
	public int numSquares(int n) {
        dpTable = new int[n];
        return numSquaresInner(n);
    }
	
	private int numSquaresInner(int x) {
		if(dpTable[x - 1] != 0) return dpTable[x - 1];
		double xSqrt = Math.sqrt(x);
		double xFloor = Math.floor(xSqrt);
		if(xSqrt == xFloor) {
			// x is a perfect square
			return 1;
		}
		// not a perfect square
		int sqrtOfNearestPS = (int)xFloor;
		/*
		 * Check for all perfect squares now
		 */
		int minPS = Integer.MAX_VALUE;
		for(int y = 1; y <= sqrtOfNearestPS; y++) {
			minPS = Math.min(minPS, numSquaresInner(x - y*y));
		}
		dpTable[x - 1] = minPS + 1;
		return dpTable[x - 1];
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numSquares(12));
	}

}
