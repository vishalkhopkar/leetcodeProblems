package rotateImage;

import java.util.Arrays;

public class Solution {
	
	public void rotate(int[][] matrix) {
		int[] rotations = new int[4];
		int n = matrix.length;
		for(int i = 0; i < n/2; i++) {
			for(int j = i; j < n - (i + 1); j++) {
				rotations[0] = matrix[i][j];
				rotations[1] = matrix[j][n - (i + 1)];
				rotations[2] = matrix[n - (i + 1)][n - (j + 1)];
				rotations[3] = matrix[n - (j + 1)][i];
				
				matrix[i][j] = rotations[3];
				matrix[j][n - (i + 1)] = rotations[0];
				matrix[n - (i + 1)][n - (j + 1)] = rotations[1];
				matrix[n - (j + 1)][i] = rotations[2];
			}
			
		}
    }
	public boolean findRotation(int[][] mat, int[][] target) {
		if(mat.length != target.length) return false;
		// max 4 rotations possible
        for(int i = 0; i < 4; i++) {
        	rotate(mat);
        	if(matricesEqual(mat, target)) return true;
        }
        return false;
    }
	private boolean matricesEqual(int[][] mat, int[][] target) {
		for(int i = 0; i < mat.length; i++) {
			if(!Arrays.equals(mat[i], target[i])) return false;
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 3, 2, 5, 6},
				{14, 10, 8, 9, 20},
				{-4, -5, 0, 13, 12},
				{4, 7, 10, 11, 18},
				{-8, -7, -6, -5, 21}
		};
		int[][] mat1 = {{0,1},{1,0}};
		int[][] target1 = {
				{1, 0},
				{0, 1}
		};
		Solution s = new Solution();
		
	}

}
