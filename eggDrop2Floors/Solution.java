package eggDrop2Floors;

public class Solution {

	int[][] dpTable;
	public int twoEggDrop(int n) {
		dpTable = new int[n + 1][2];
        return numberOfChances(n, 2);
        
    }
	
	
	private int numberOfChances(int n, int e) {
		if(dpTable[n][e - 1] > 0) return dpTable[n][e - 1];
		if(n == 1) {
			dpTable[1][0] = 1;
			return 1;
		}
		if(e == 1) {
			dpTable[n][0] = n - 1;
			return n - 1;
		}
		
		else {
			int min = Integer.MAX_VALUE;
			for(int i = 1; i <= (n - 1); i++) {
				min = Math.min(min, Math.max(numberOfChances(n - i, 2), numberOfChances(i, 1)));
			}
			dpTable[n][e - 1] = min + 1;
			return min + 1;
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.twoEggDrop(5));

	}

}
