package countSquareSubmatrices;

import java.util.Arrays;

public class Solution {

	public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[][] rowSum = new int[m][n];
        
        for(int i = 0; i < m; i++) {
        	rowSum[i][0] = matrix[i][0];
        	for(int j = 1; j < n; j++) {
        		rowSum[i][j] = rowSum[i][j - 1] + matrix[i][j];
        	}
        }
        
        int[][] colSum = new int[m][n];
        
        for(int i = 0; i < n; i++) {
        	colSum[0][i] = matrix[0][i];
        }
        for(int i = 1; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		colSum[i][j] = colSum[i - 1][j] + matrix[i][j];
        	}
        }
        
        System.out.println("row sum");
        for(int i = 0; i < m; i++) {
        	System.out.println(Arrays.toString(rowSum[i]));
        }
        
        System.out.println("col sum");
        for(int i = 0; i < m; i++) {
        	System.out.println(Arrays.toString(colSum[i]));
        }
        
        /*
         * find the actual sum now
         */
        
        int ret = 0;
        
        int[][] sumMatrix = new int[m][n];
        for(int i = 0; i < n; i++) {
        	sumMatrix[0][i] = rowSum[0][i];
        }
        for(int i = 0; i < m; i++) {
        	sumMatrix[i][0] = colSum[i][0];
        }
        
        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        		sumMatrix[i][j] = colSum[i - 1][j] + rowSum[i][j - 1] +
        				sumMatrix[i - 1][j - 1] + matrix[i][j];
        	}
        }
        
        System.out.println("matrix sum");
        for(int i = 0; i < m; i++) {
        	System.out.println(Arrays.toString(sumMatrix[i]));
        }
        
        ret = sumMatrix[m - 1][n - 1];
        
        int size = 2;
        int maxSquareSize = Math.min(m, n);
        int startX, startY, endX, endY;
        while(size <= maxSquareSize) {
        	System.out.println("size = "+size);
        	startX = 0;
        	endX = startX + size - 1;
        	while(endX < m) {
        		startY = 0;
        		endY = startY + size - 1;
        		while(endY < n) {
        			System.out.println("checking ("+startX+", "+startY+") to ("+endX+", "+endY+")");
        			
        			
        			if(sumMatrix[endX][endY] - getVal(sumMatrix, endX, endY - size) - getVal(sumMatrix, endX - size, endY) + 
        			getVal(sumMatrix, endX - size, endY - size) == size*size) {
        				ret++;
        			}
        			
        			endY++;
        			startY++;
        		}
        		endX++;
        		startX++;        		
        	}
        	size++;
        }
        
        return ret;
    }
	
	private int getVal(int[][] sumMatrix, int x, int y) {
		if(x < 0 || y < 0) return 0;
		return sumMatrix[x][y];
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				  {0,1,1,1},
				  {1,1,1,1},
				  {0,1,1,1}
				};
		
		Solution s = new Solution();
		System.out.println(s.countSquares(matrix));

	}

}
