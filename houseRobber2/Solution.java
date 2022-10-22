package houseRobber2;

import java.util.Arrays;

public class Solution {
	
	int myModulo(int x, int n) {
		if(x >= 0) return x%n;
		return n + x;
	} 

	public int rob(int[] nums) {
        int n = nums.length;
        
        int[][] dpTable = new int[n][n];
        for(int i = 0; i < n; i++) {
        	dpTable[i][i] = nums[i];        	
        	dpTable[i][(i + 1)%n] = Math.max(nums[i], nums[(i + 1)%n]);
        	dpTable[i][(i + 2)%n] = Math.max(nums[i], 
        				Math.max(nums[(i + 1)%n], nums[(i + 2)%n]));
        	
        	//System.out.println(Arrays.toString(dpTable[i]));
        }
        
        int x = 0, y = 3, orgY = 3;
        for(int i = 3; i < n; i++) {
        	for(int j = 0; j < n; j++) {
        		dpTable[x][y] = Math.max(
        				Math.max(dpTable[(x + 1)%n][myModulo(y - 2, n)] + nums[myModulo(y, n)],
        						dpTable[(x + 2)%n][myModulo(y - 1, n)] + nums[x%n]), 
        				Math.max(dpTable[x][myModulo(y - 1, n)], dpTable[(x + 1)%n][y]));
        		x++;
        		x%=n;
        		y++;
        		y%=n;
        	}
        	x = 0;
        	y = ++orgY;
        }
        for(int i = 0; i < n; i++) {
        	
        	System.out.println(Arrays.toString(dpTable[i]));
        	
        }
        return dpTable[0][n - 1];
        
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {6,6,4,8,4,3,3,10};
		
		System.out.println(s.rob(nums));

	}

}
