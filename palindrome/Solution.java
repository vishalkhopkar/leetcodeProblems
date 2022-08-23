package palindrome;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isPalindrome(12788721));
	}
	
	public boolean isPalindrome(int x) {
		if(x < 0) return false;
		if(x / 10 == 0) return true;
		int rev = 0, tempX = x, r;
		while(tempX != 0) {
			r = tempX % 10;
			rev = rev*10 + r;
			tempX /= 10;
		}
		System.out.println(Math.pow(2, -2));
		return (x == rev);
		
	}

}
