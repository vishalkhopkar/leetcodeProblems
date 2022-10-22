package maximumIcecreams;

import java.util.Arrays;

public class Solution {

	public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int remCoins = coins;
        int currPos = 0;
        while(currPos < costs.length && remCoins >= costs[currPos]) {
        	remCoins -= costs[currPos++];
        }
        return currPos;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] costs = {1,6,3,1,2,5};
		System.out.println(s.maxIceCream(costs, 7));

	}

}
