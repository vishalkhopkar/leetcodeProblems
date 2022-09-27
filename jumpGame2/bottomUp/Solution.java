package jumpGame2.bottomUp;

import java.util.Arrays;

public class Solution {

	public int jump(int[] arr) {
		int[] dpTable = new int[arr.length];
		dpTable[arr.length - 1] = 0;
		for(int i = arr.length - 2; i >= 0; i--) {
			int k = arr[i];
			k = Math.min(k,  arr.length - i - 1);
			int minVal = Integer.MAX_VALUE;
			if(k > 0) {
				for(int j = 1; j <= k; j++) {
					if(dpTable[i + j] < Integer.MAX_VALUE)
						minVal = Math.min(minVal, 1 + dpTable[i + j]);
				}
				dpTable[i] = minVal;
			}
			else {
				dpTable[i] = Integer.MAX_VALUE;
			}
		}
		System.out.println(Arrays.toString(dpTable));
		return dpTable[0];
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] jumps = {1, 1, 1, 1};
		System.out.println(s.jump(jumps));

	}

}
