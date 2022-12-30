package maxBagsWithCapacityRocks;


import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        Queue<Integer> remCapacity = new PriorityQueue<>(rocks.length);
        int y;
        int ret = 0;
        for(int i = 0; i < rocks.length; i++) {
        	if(capacity[i] > rocks[i]) {
        		remCapacity.offer(capacity[i] - rocks[i]);
        	}
        	else {
        		ret++;
        	}
        }
        
        while(additionalRocks > 0 && !remCapacity.isEmpty()) {
        	y = remCapacity.poll();
        	if(additionalRocks >= y) {
        		additionalRocks -= y;
        		ret++;
        	}
        	else {
        		break;
        	}
        }
        return ret;
        
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] capacity = {10, 2, 2};
		int[] rocks = {2, 2, 0};
		System.out.println(s.maximumBags(capacity, rocks, 20));

	}

}
