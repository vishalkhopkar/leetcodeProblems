package diceTarget;

import java.util.Arrays;

public class Solution {
	
	public int numRollsToTarget(int n, int k, int target) {
		buildDpTable(n, target, k);
		for(int i = 1; i <= target; i++) {
			System.out.println(Arrays.toString(w[i]));
		}
		return w[target][n];
	}

	int[][] w;
	final int MODULO_CONSTANT = (int)Math.pow(10, 9) + 7;
	private void buildDpTable(int n, int target, int k) {
		w = new int[target + 1][n + 1];
		// subtract 1 for the actual index
		for(int i = 1; i <= Math.min(target, k); i++) {
			/*
			 * no of ways of getting a number <= k on 1 die
			 * is always 1, for ex: {1, 2, 3, 4, 5, 6}
			 * for k = 6 and n = 1
			 */
			w[i][1] = 1;
			
		}
		for(int i = 1; i <= n; i++) {
			/*
			 * no of ways of getting n on n dice is 1 (n == target)
			 * for ex: {1, 1} for n = 2, target = 2
			 * {1, 1, 1}, n = target = 3
			 */
			w[i][i] = 1;
		}
		int s = 0, left, c;
		for(int i = 2; i <= target; i++) {
			for(int j = 2; j <= n; j++) {
				if(i != j) {
					//System.out.println("filling "+i+", "+j);
					s = 0;
					// assign w[i][j]
					c = 0;
					left = i - 1;
					while(c < k && left >= (j - 1)) {
						s += w[left][j - 1];
						s %= MODULO_CONSTANT;
						//System.out.println("added w["+left+"]["+(j - 1)+"]");
						left--;
						c++;
					}
						
					
					w[i][j] = s;
				}
				
			}
		}	
		
		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.numRollsToTarget(3, 6, 22);

	}

}
