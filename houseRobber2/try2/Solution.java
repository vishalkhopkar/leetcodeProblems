package houseRobber2.try2;

public class Solution {

	public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],  nums[1]);
        if(n == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));
        int[][] dpTable = new int[n][n];
        for(int i = 0; i < n; i++) {
        	dpTable[i][i] = nums[i];
        	if(i != (n - 1)) {
        		dpTable[i][i + 1] = Math.max(nums[i], nums[i + 1]);
        	}
        	
        }
        int x = 0, y = 2, orgY = 2;
        for(int i = 2; i < n - 1; i++) {
        	while(x < n - i) {
        		dpTable[x][y] = Math.max(nums[y] + dpTable[x][y - 2], dpTable[x][y - 1]);
        		x++;
        		y++;
        	}
        	x = 0;
        	y = ++orgY;
        }
        /*
        for(int i = 0; i < n; i++) {
        	
        	System.out.println(Arrays.toString(dpTable[i]));
        	
        }
        */
        return Math.max(
        		Math.max(dpTable[2][n - 2] + nums[0], dpTable[0][n - 2]),
        		Math.max(dpTable[1][n - 3] + nums[n - 1], dpTable[1][n - 1]));
	}
	public static void main(String[] args) {
		int[] nums = {6,6,4,8,4,3,3,10};
		Solution s = new Solution();
		System.out.println(s.rob(nums));

	}

}
