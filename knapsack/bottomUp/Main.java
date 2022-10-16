package knapsack.bottomUp;
public class Main {

	int[][] dpTable;
	public int knapsack(int[] vals, int[] weights, int w, int n) {
		dpTable = new int[n + 1][w + 1];
		for(int i = 1; i < n + 1; i++) {
			for(int j = 1; j < w + 1; j++) {
				if(weights[i - 1] <= j) {
					/* two choices
					 * 1. take
					 * 2. don't take
					 */
					dpTable[i][j] = Math.max(vals[i - 1] + dpTable[i - 1][j - weights[i - 1]], 
							dpTable[i - 1][j]);
				}
				else {
					dpTable[i][j] = dpTable[i - 1][j];
				}
			}
		}
		return dpTable[n][w];
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		int[] vals = {4, 5, 2, 3};
		int[] weights = {3, 5, 1, 4};
		System.out.println(m.knapsack(vals, weights, 10, weights.length));

	}

}
