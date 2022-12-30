package dominoTrominoes;

public class Solution {

	public int numTilings(int n) {
		final int MODULO = (int)Math.pow(10, 9) + 7;
        long[] dpTable = new long[n];
        dpTable[0] = 1;
        if(n >= 2)
        	dpTable[1] = 2;
        
        long doubleStart, doubleSum;
        for(int i = 2; i < n; i++) {
        	doubleStart = i - 3;
        	doubleSum = 2;
        	if(doubleStart >= 0) {
        		for(int j = 0; j <= doubleStart; j++) {
        			doubleSum += 2*dpTable[j];
        			doubleSum %= MODULO;
        		}
        	}
        	//System.out.println("double sum "+doubleSum);
        	dpTable[i] = doubleSum + dpTable[i - 1];
        	dpTable[i] %= MODULO;
        	dpTable[i] += dpTable[i - 2];
        	dpTable[i] %= MODULO;
        }
        
        return (int)(dpTable[n - 1] % MODULO);
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numTilings(80));

	}

}
