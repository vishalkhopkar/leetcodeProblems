package knapsack.memoized;

import java.util.Arrays;

public class Main {
	
	int[][] dpTable;
	public int knapsack(int[] vals, int[] weights, int w, int n) {
		if(dpTable[n][w] != -1) return dpTable[n][w];
		System.out.println("(w = "+w+", n = "+n+")");
		if(n == 0 || w == 0) {
			dpTable[0][0] = 0;
			return 0;
		}
		int x;
		if(weights[n - 1] <= w) {
			/* two choices
			 * 1. take
			 * 2. don't take
			 */
			x = Math.max(vals[n - 1] + knapsack(vals, weights, w - weights[n - 1], n - 1), 
					knapsack(vals, weights, w, n - 1));
			dpTable[n][w] = x;
			return x;
		}
		else {
			x = knapsack(vals, weights, w, n - 1);
			dpTable[n][w] = x;
			return x;
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		int w = 10;
		int[] vals = {4, 5, 2, 3};
		int[] weights = {3, 5, 1, 4};
		m.dpTable = new int[vals.length + 1][w + 1];
		for(int i = 0; i < vals.length + 1; i++) {
			Arrays.fill(m.dpTable[i], -1);
		}
		System.out.println(m.knapsack(vals, weights, 10, weights.length));

	}

}
