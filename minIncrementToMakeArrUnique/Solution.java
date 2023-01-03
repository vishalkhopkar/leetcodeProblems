package minIncrementToMakeArrUnique;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class Solution {

	public int minIncrementForUnique(int[] nums) {
        Map<Integer, Integer> treeMap = new ConcurrentSkipListMap<>();
        for(int i = 0; i < nums.length; i++) {
        	inc(treeMap, nums[i]);
        }
        
        System.out.println(treeMap);
        
        Iterator<Map.Entry<Integer, Integer>> it = treeMap.entrySet().iterator();
        Map.Entry<Integer, Integer> entry;
        int ret = 0, count, key;
        while(it.hasNext()) {
        	entry = it.next();
        	key = entry.getKey();
        	count = treeMap.get(key);
        	if(count > 1) {
        		for(int i = 1; i <= count - 1; i++) {
        			System.out.println("key "+key);
        			inc(treeMap, key + i);
        			System.out.println(treeMap);
        			ret += i;
        		}
        	}
        }
        
        return ret;
    }

	private void inc(Map<Integer, Integer> treeMap, int key) {
		Integer x = treeMap.get(key);
    	if(x == null) {
    		treeMap.put(key, 1);
    	}
    	else {
    		treeMap.replace(key, x + 1);
    	}		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {3,2,1,2,1,7};
		System.out.println(s.minIncrementForUnique(nums));

	}

}
