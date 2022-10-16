package subsetSum.bottomUp;

public class Main {

	boolean[][] dpTable;
	public boolean subsetSum(int[] vals, int k) {
		dpTable = new boolean[vals.length + 1][k + 1];
		for(int i = 1; i < vals.length + 1; i++) {
			for(int j = 1; j < k + 1; j++) {
				if(vals[i - 1] == j) {
					dpTable[i][j] = true;
					//System.out.println("here "+i+", "+j);
				}
				else if(vals[i - 1] > j) {
					
					dpTable[i][j] = dpTable[i - 1][j];
				}
				else {
					if(j - vals[i - 1] >= 0)
						dpTable[i][j] = dpTable[i - 1][j - vals[i - 1]] || dpTable[i - 1][j];
					else
						dpTable[i][j] = dpTable[i - 1][j];
				}
				
			}
		}
		
		return dpTable[vals.length][k];
	}
	public static void main(String[] args) {
		Main m = new Main();
		int[] vals = {1, 5, 5, 4, 3, 4};
		System.out.println(m.subsetSum(vals, 25));
		
	}

}
