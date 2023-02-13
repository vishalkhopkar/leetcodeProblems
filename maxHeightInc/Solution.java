package maxHeightInc;

import java.util.Arrays;

public class Solution {

	public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] horizontalMax = new int[m];
        int[] verticalMax = new int[n];

        int sum = 0;
        for(int i = 0; i < m; i++) {
        	horizontalMax[i] = Arrays.stream(grid[i]).max().getAsInt();
        	for(int j = 0; j < n; j++) {
            	verticalMax[j] = Math.max(verticalMax[j], grid[i][j]);
            }
        }
        System.out.println(Arrays.toString(horizontalMax));
        System.out.println(Arrays.toString(verticalMax));
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		sum += (Math.min(horizontalMax[i], verticalMax[j]) - grid[i][j]);
        	}
        }
        return sum;
    }
	public static void main(String[] args) {
		int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
		System.out.println(new Solution().maxIncreaseKeepingSkyline(grid));

	}

}
