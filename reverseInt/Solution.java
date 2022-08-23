package reverseInt;

public class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.reverse(-2147483648));
		int res = 964632432;
		
	}
	
	public int reverse(int x) {
		boolean isNegative = (x < 0);
		System.out.println(isNegative);
		if(isNegative) x *= (-1);
		if (x < 0) return 0;
		long ret = 0;
		while(x != 0) {
			ret += x % 10;
			x /= 10;
			ret *= 10;
			System.out.println(ret);
			
		}
		ret /= 10;
		if(ret > Integer.MAX_VALUE) return 0;
		if(isNegative) ret *= (-1);
		return (int)ret;
	}

}
