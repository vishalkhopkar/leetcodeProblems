package asFarFromLand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Cell {
	int r, c;

	public Cell(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	
}
public class Solution {

	public int maxDistance(int[][] grid) {
        /*
         * find the water cells bordering a land first
         */
		
		Queue<Cell> queue = new LinkedList<>();
		int m = grid.length, n = grid[0].length;
		int maxDistance = 0;
		int[][] distanceFromLand = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 0 && hasLandNeighbour(grid, i, j)) {
					queue.offer(new Cell(i, j));
					distanceFromLand[i][j] = 1;
					maxDistance = Math.max(maxDistance, 1);
				}
			}
		}
		int r, c;
		
		Cell cell;
		while(!queue.isEmpty()) {
			cell = queue.poll();
			r = cell.r;
			c = cell.c;
			/*
			 * traverse all neighbours of cell
			 */
			
			if(getVal(grid, r + 1, c) == 0) {
				if(distanceFromLand[r + 1][c] == 0) {
					queue.offer(new Cell(r + 1, c));
					distanceFromLand[r + 1][c] = distanceFromLand[r][c] + 1;
					maxDistance = Math.max(maxDistance, distanceFromLand[r + 1][c]);
				}
			}
			
			if(getVal(grid, r - 1, c) == 0) {
				if(distanceFromLand[r - 1][c] == 0) {
					queue.offer(new Cell(r - 1, c));
					distanceFromLand[r - 1][c] = distanceFromLand[r][c] + 1;
					maxDistance = Math.max(maxDistance, distanceFromLand[r - 1][c]);
				}
			}
			
			if(getVal(grid, r, c + 1) == 0) {
				if(distanceFromLand[r][c + 1] == 0) {
					queue.offer(new Cell(r, c + 1));
					distanceFromLand[r][c + 1] = distanceFromLand[r][c] + 1;
					maxDistance = Math.max(maxDistance, distanceFromLand[r][c + 1]);
				}
			}
			
			if(getVal(grid, r, c - 1) == 0) {
				if(distanceFromLand[r][c - 1] == 0) {
					queue.offer(new Cell(r, c - 1));
					distanceFromLand[r][c - 1] = distanceFromLand[r][c] + 1;
					maxDistance = Math.max(maxDistance, distanceFromLand[r][c - 1]);
				}
			}
			
			
		}
		for(int i = 0; i < m; i++) {
			System.out.println(Arrays.toString(distanceFromLand[i]));
		}
		return maxDistance;
    }

	private boolean hasLandNeighbour(int[][] grid, int i, int j) {
		return getVal(grid, i - 1, j) == 1 || getVal(grid, i + 1, j) == 1
				|| getVal(grid, i, j - 1) == 1 || getVal(grid, i, j + 1) == 1;
		
	}

	private int getVal(int[][] grid, int i, int j) {
		if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) return grid[i][j];
		
		return -1;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] grid = {{1,0,1},{0,0,0},{1,0,1}};
		System.out.println(s.maxDistance(grid));

	}

}
