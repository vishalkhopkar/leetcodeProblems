package matrixTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] matrix = {
				{1, 2, 3, 4},
				{4, 5, 6, 7},
				{7, 8, 9, 8},
				{6, 7, 9, 12}
		};
		
		int[][] matrix1 = {
				{1}
		};
		
		System.out.println(s.spiralOrder(matrix1));

	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
		// first go right, then down
		if(matrix.length == 0) return null;
		int r = matrix.length;
		int c = matrix[0].length;
		int totalElems = r*c;
		int currX = 0, currY = 0, direction = 0;
		int rightLimit = c, bottomLimit = r;
		int leftLimit = -1, topLimit = 0;
		/**
		 * A note on direction
		 * 0: right
		 * 1: down
		 * 2: left
		 * 3: up
		 */
		List<Integer> ret = new ArrayList<>();
		for(int i = 0; i < totalElems; i++) {
			//ret.add(matrix[currX][currY]);
			System.out.printf("%d, %d\n", currX, currY);
			switch(direction) {
			case 0:
				currY++;
				if(currY == rightLimit) {
					direction++;
					currY = rightLimit - 1;
					rightLimit--;
					currX++;
				}
				break;
			case 1:
				currX++;
				if(currX == bottomLimit) {
					direction++;
					currX = bottomLimit - 1;
					bottomLimit--;
					currY--;
				}
				break;
			case 2:
				currY--;
				if(currY == leftLimit) {
					direction++;
					currY = leftLimit + 1;
					leftLimit++;
					currX--;
				}
				break;
			case 3:
				currX--;
				if(currX == topLimit) {
					direction = 0;
					currX = topLimit + 1;
					topLimit++;
					currY++;
				}
				break;
			}
		}
		return ret;
	}

}
