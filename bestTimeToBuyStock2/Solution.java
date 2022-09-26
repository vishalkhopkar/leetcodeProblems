package bestTimeToBuyStock2;

public class Solution {
	
	public int maxProfit(int k, int[] prices) {
		int profit = 0;
		for(int i = 0; i < prices.length - 1; i++) {
			if(prices[i + 1] > prices[i]) {
				profit += prices[i + 1] - prices[i];
			}
		}
		return profit;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
