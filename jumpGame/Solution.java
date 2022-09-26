package jumpGame;

public class Solution {
	
	public boolean canJump(int[] arr) {
        /*
         * In order to reach n, you can do so if
         * (i + arr[i]) >= n
         */
		return canJumpRec(arr, arr.length - 1);
    }

	private boolean canJumpRec(int[] arr, int n) {
		if(n == 0) return true;
		for(int i = n - 1; i >= 0; i--) {
			if(i + arr[i] >= n) {
				return canJumpRec(arr, i);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = {3, 2, 1, 0, 4};
		System.out.println(s.canJump(arr));

	}

}
