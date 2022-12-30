package strictlyPalindromic;

public class Solution {
	
	boolean checkPalindromeBase(int n, int base) {
		System.out.println("cp("+n+")");
		if(n < base) return true;
		if(n % base == 1) {
			int nearestPower = (int) Math.floor(Math.log(n)/Math.log(base));
			System.out.println("nearest power "+nearestPower);
			return checkPalindromeBase((n - (int)Math.pow(base, nearestPower) - 1)/ base, base);
		}
		return false;
	}
	
	public boolean isStrictlyPalindromic(int n) {
        return checkPalindromeBase(n, 2);
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isStrictlyPalindromic(2));

	}

}
