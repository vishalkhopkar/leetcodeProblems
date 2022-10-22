package bestTimeToBuySellStock1;

public class Solution {
	
	public int maxProfit(int[] prices) {
		int[] maximumProfitIfBoughtOnThisDay = new int[prices.length];
		int overallMaximum = Integer.MIN_VALUE;
        for(int i = 0; i < prices.length; i++) {
        	maximumProfitIfBoughtOnThisDay[i] = Integer.MIN_VALUE;
        	for(int j = i + 1; j < prices.length; j++) {
        		maximumProfitIfBoughtOnThisDay[i] =
        				Math.max(prices[j] - prices[i], maximumProfitIfBoughtOnThisDay[i]);
        	}
        	overallMaximum = Math.max(overallMaximum, maximumProfitIfBoughtOnThisDay[i]);
        }
        return Math.max(0, overallMaximum);
        
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] prices = {7,6,4,3,1};
		System.out.println(s.maxProfit(prices));

	}

}
