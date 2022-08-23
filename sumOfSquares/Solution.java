package sumOfSquares;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.judgeSquareSum(2147483646));
	}
	
	public boolean judgeSquareSum(int c) {
		// begin from 1, go upto the point where i*i > c
		
		for(int i = 0; i*i < c; i++) {
			if(isPerfectSquare(c - i*i)) return true;
		}
		return false;
	}
	
	private boolean isPerfectSquare(int c) {
		double sqrtC = Math.sqrt(c);
		if(sqrtC == Math.floor(sqrtC)) {
			return true;
		}
		return false;
	}
}
