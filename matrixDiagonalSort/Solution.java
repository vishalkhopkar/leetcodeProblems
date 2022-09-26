package matrixDiagonalSort;

public class Solution {
	public int[][] diagonalSort(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		int j1, j2;
		/*
		 * A n x m matrix has n*m - 1 diagonals
		 * These are :
		 * [n - 1][0]
		 * [n - 2][0], [n - 1][1]
		 * [n - 3][0], [n - 2][1], [n - 1][2],
		 * ...
		 * [n - k][0], [n - (k - 1)][1], [n - (k - 2)][2], ..., [n - 1][k + 1],
		 * ...
		 * [0][0], [1][1], [2][2], ..., 
		 * [0][1], [1][2], [2][3], ..., 
		 */
		for(int  i = (n - 1); i >= 0; i--) {
		}
		return null;
	}
	public static void main(String[] args) {
		

	}

}
