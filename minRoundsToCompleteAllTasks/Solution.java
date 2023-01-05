package minRoundsToCompleteAllTasks;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer count;
        for(int task : tasks) {
        	count = map.get(task);
        	if(count == null) {
    			map.put(task, 1);
    		}
    		else {
    			map.put(task, count + 1);
    		}
        }
        System.out.println(map);
        int ret = 0;
        for(Integer difficulty : map.keySet()) {
        	count = map.get(difficulty);
        	if(count == 1) return -1;
        	ret += Math.ceil((double)count/3);
        }
        return ret;
    }

	public static void main(String[] args) {
		int[] tasks = {2,2,3,3,2,4,4,4,4,4};
		Solution s = new Solution();
		System.out.println(s.minimumRounds(tasks));

	}

}
