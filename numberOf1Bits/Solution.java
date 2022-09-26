package numberOf1Bits;

public class Solution {
	
	public int hammingWeight(int n) {
		int ret = 0;
		for(int i = 0; i < 32; i++) {
			if((Integer.rotateRight(n, i) & 0x00000001) == 1) ret++;
		}
		return ret;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.hammingWeight(-3));

	}

}
