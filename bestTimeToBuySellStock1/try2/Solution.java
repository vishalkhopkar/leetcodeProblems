package bestTimeToBuySellStock1.try2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public int maxProfit(int[] prices) {
		List<Integer> minimas = new ArrayList<>();
		List<Integer> maximas = new ArrayList<>();
		int n = prices.length;
		if(n == 1) return 0;
		if(n == 2) return Math.max(0, prices[1] - prices[0]);
		if(prices[0] < prices[1]) minimas.add(0);
		if(prices[n - 1] > prices[n - 2]) maximas.add(n - 1);
		for(int i = 1; i < (n - 1); i++) {
			if(prices[i] < prices[i - 1] && prices[i] < prices[i + 1]) {
				minimas.add(i);
			}
			else if(prices[i] > prices[i - 1] && prices[i] > prices[i + 1]) {
				maximas.add(i);
			}
		}
		if(minimas.isEmpty() || maximas.isEmpty()) return 0;
		int maxProfit = 0, profit;
		for(int i = 0; i < minimas.size(); i++) {
			for(int j = 0; j < maximas.size(); j++) {
				if(maximas.get(j) > minimas.get(i)) {
					profit = prices[maximas.get(j)] - prices[minimas.get(i)];
					maxProfit = Math.max(profit, maxProfit);
				}
				
			}
		}
		return maxProfit;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] prices = {7,1,5,3,6,4};
		System.out.println(s.maxProfit(prices));

	}

}
