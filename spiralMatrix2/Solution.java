package spiralMatrix2;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.generateMatrix(5);
	}
	
	public int[][] generateMatrix(int n) {
		int[][] ret = new int[n][n];
		char currX = 0, currY = 0, direction = 0;
		char rightLimit = (char) n, bottomLimit = (char) n;
		char leftLimit = (char)-1, topLimit = 0;
		for(int i = 0; i < n*n; i++) {
			ret[currX][currY] = (i + 1);
			System.out.printf("%d, %d\n", (int)currX, (int)currY);
			switch(direction) {
			case 0:
				currY++;
				if(currY == rightLimit) {
					direction++;
					currY = (char) (rightLimit - 1);
					rightLimit--;
					currX++;
				}
				break;
			case 1:
				currX++;
				if(currX == bottomLimit) {
					direction++;
					currX = (char)(bottomLimit - 1);
					bottomLimit--;
					currY--;
				}
				break;
			case 2:
				currY--;
				if(currY == leftLimit) {
					direction++;
					currY = (char)(leftLimit + 1);
					leftLimit++;
					currX--;
				}
				break;
			case 3:
				currX--;
				if(currX == topLimit) {
					direction = 0;
					currX = (char)(topLimit + 1);
					topLimit++;
					currY++;
				}
				break;
			}
		}
		return ret;
	}

}
