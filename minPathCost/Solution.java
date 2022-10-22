package minPathCost;

public class Solution {
	
	public int minPathCost(int[][] grid, int[][] moveCost) {
		int m = grid.length;
		int n = grid[0].length;
        int[][] minCost = new int[m][n];
        for(int i = 0; i < n; i++) {
        	minCost[0][i] = grid[0][i];
        }
        int min;
        for(int i = 1; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		/*
        		 * minCost[i][j] = min(minCost[i - 1][0] + moveCost[grid[i - 1][0]][0],
        		 * minCost[i - 1][1] + moveCost[grid[i - 1]][1], ...
        		 * minCost[i - 1][n - 1] + moveCost[grid[i - 1]][n - 1]
        		 */
        		min = minCost[i - 1][0] + moveCost[grid[i - 1][0]][j];
        		System.out.println(" i = "+i+" j = "+j+" currmin = "+min);
        		for(int k = 1; k < n; k++) {
        			if(minCost[i - 1][k] + moveCost[grid[i - 1][k]][j] < min) {
        				min = minCost[i - 1][k] + moveCost[grid[i - 1][k]][j];
        				System.out.println(" grid value "+grid[i - 1][j]+" min now "+min);
        			}
        		}
        		minCost[i][j] = min + grid[i][j];
        	}
        	
        }
        // find the minimum in the last row
        min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
        	min = Math.min(min, minCost[m - 1][i]);
        }
        return min;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] grid = {{5,3},{4,0},{2,1}};
		int[][] moveCost = {{9,8},{1,5},{10,12},{18,6},{2,4},{14,3}};
		System.out.println(s.minPathCost(grid, moveCost));

	}

}
