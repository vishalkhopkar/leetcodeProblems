package playersWithZeroOrOneLosses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

	public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> noOfMatchesLost = new TreeMap<>();
        
        Integer lostCount, lostCountWinner;
        for(int[] x : matches) {
        	/*
        	 * x[0] is the winner
        	 * x[1] is the loser
        	 */
        	lostCount = noOfMatchesLost.get(x[1]);
        	if(lostCount == null) {
        		noOfMatchesLost.put(x[1], 1);
        	}
        	else {
        		noOfMatchesLost.put(x[1], lostCount + 1);
        	}
        	lostCountWinner = noOfMatchesLost.get(x[0]);
        	if(lostCountWinner == null) {
        		noOfMatchesLost.put(x[0], 0);
        	}
        }
        
        Iterator<Map.Entry<Integer, Integer>> it = noOfMatchesLost.entrySet().iterator();
        Map.Entry<Integer, Integer> entry;
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());
        ret.add(new ArrayList<>());
        while(it.hasNext()) {
        	entry = it.next();
        	if(entry.getValue() == 0) {
        		ret.get(0).add(entry.getKey());
        	}
        	else if(entry.getValue() == 1) {
        		ret.get(1).add(entry.getKey());
        	}
        }
        return ret;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] arr = {{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
		System.out.println(s.findWinners(arr));

	}

}
