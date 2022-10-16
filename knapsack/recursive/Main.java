package knapsack.recursive;

public class Main {
	
	public int knapsack(int[] vals, int[] weights, int w, int n) {
		System.out.println("(w = "+w+", n = "+n+")");
		if(n == 0 || w == 0) return 0;
		if(weights[n - 1] <= w) {
			/* two choices
			 * 1. take
			 * 2. don't take
			 */
			return Math.max(vals[n - 1] + knapsack(vals, weights, w - weights[n - 1], n - 1), 
					knapsack(vals, weights, w, n - 1));
		}
		else {
			return knapsack(vals, weights, w, n - 1);
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		int[] vals = {4, 5, 2, 3};
		int[] weights = {3, 5, 1, 4};
		System.out.println(m.knapsack(vals, weights, 10, weights.length));

	}

}
