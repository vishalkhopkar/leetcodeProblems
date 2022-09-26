package powerOf2;

public class Solution {
	public boolean isPowerOfTwo(int n) {
		for(int i = 0; i < 31; i++) {
			if(Integer.rotateRight(n, i) == 1) return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isPowerOfTwo(Integer.MIN_VALUE));

	}

}
