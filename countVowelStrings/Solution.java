package countVowelStrings;

public class Solution {
	
	public int countVowelStrings(int n) {
        int[][] dpTable = new int[n + 1][5];
        for(int i = 0; i < 5; i++) {
        	dpTable[0][i] = 1;
        }
        
        for(int i = 1; i <= n; i++) {
        	dpTable[i][4] = 1;
        	for(int j = 3; j >= 0; j--) {
        		dpTable[i][j] = dpTable[i][j + 1] + dpTable[i - 1][j];
        	}
        }
        
        
        
        return dpTable[n][0];
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.countVowelStrings(7));

	}

}
