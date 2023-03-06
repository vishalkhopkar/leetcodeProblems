package maxSquare;

import java.util.Arrays;

public class Solution {

	public int maximalSquare(char[][] matrix) {
        /*
         * build 3 matrices
         */
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] rowWise = new int[m][n];
		int[][] colWise = new int[m][n];
		int[][] cornerWise = new int[m][n];
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0) colWise[i][j] = matrix[i][j] - '0';
				else {
					colWise[i][j] = colWise[i - 1][j] + (matrix[i][j] - '0');
				}
			}
		}
		
		for(int j = 0; j < n; j++) {
			for(int i = 0; i < m; i++) {
				if(j == 0) rowWise[i][j] = matrix[i][j] - '0';
				else rowWise[i][j] = rowWise[i][j - 1] + (matrix[i][j] - '0');
			}
		}
		
		cornerWise[0][0] = matrix[0][0] - '0';
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(i == 0) cornerWise[i][j] = rowWise[i][j];
				else if(j == 0) cornerWise[i][j] = colWise[i][j];
				else {
					cornerWise[i][j] = cornerWise[i - 1][j - 1] + rowWise[i][j - 1]
							+ colWise[i - 1][j] + (matrix[i][j] - '0');
				}
			}
		}
		printMatrix(rowWise);
		printMatrix(colWise);
		printMatrix(cornerWise);
		
		int maxLen = 0;
		if(cornerWise[m - 1][n - 1] > 1) maxLen = 1;
		else if(cornerWise[m - 1][n - 1] <= 1) return cornerWise[m - 1][n - 1];
		
		int ctr, noOfOnes;
		for(int i = 1; i < m; i++) {
			ctr = 2;
			for(int j = 1; j < n; j++) {
				ctr = 2;
				while(i - ctr >= -1 && j - ctr >= -1) {
					noOfOnes = cornerWise[i][j]
							- getValue(cornerWise, i, j - ctr)
							- getValue(cornerWise, i - ctr, j)
							+ getValue(cornerWise, i - ctr, j - ctr);
					if(i == 3 && j == 3) {
						System.out.println("no of ones "+noOfOnes+" when ctr = "+ctr);
					}
					if(noOfOnes == ctr*ctr && ctr > maxLen) maxLen = ctr;
					ctr++;
				}
			}
		}
		return maxLen*maxLen;
    }

	private void printMatrix(int[][] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
		System.out.println();
	}
	
	private int getValue(int[][] matrix, int x, int y) {
		if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length) {
			return matrix[x][y];
		}
		return 0;
	}

	public static void main(String[] args) {
		/*
		char[][] mat = {
				{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}
		};
		*/
		char[][] mat = {
				{'1','1','1','1','0'},
				{'1','1','1','1','0'},
				{'1','1','1','1','1'},
				{'1','1','1','1','1'},
				{'0','0','1','1','1'}
		};
		System.out.println(new Solution().maximalSquare(mat));

	}

}
