package sortCharactersByFrequency;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public String frequencySort(String s) {
        /*
         * using maps
         */
		Map<Character, Integer> freqMap = new HashMap<>();
		Queue<Map.Entry<Character, Integer>> priorityQ = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
			
			
		});
		
		char x;
		Integer freq;
		for(int i = 0; i < s.length(); i++) {
			x = s.charAt(i);
			freq = freqMap.get(x);
			if(freq == null) {
				/*
				 * doesn't exist
				 */
				freqMap.put(x, 1);
			}
			else {
				/*
				 * exists
				 */
				freqMap.put(x, freq + 1);
			}
		}
		
		Iterator<Map.Entry<Character, Integer>> it = freqMap.entrySet().iterator();
		Map.Entry<Character, Integer> entry;
		while(it.hasNext()) {
			priorityQ.offer(it.next());
		}
		StringBuilder res = new StringBuilder();
		char[] temp;
		while(!priorityQ.isEmpty()) {
			entry = priorityQ.poll();
			x = entry.getKey();
			freq = entry.getValue();
			temp = new char[freq];
			Arrays.fill(temp, x);
			res.append(temp);
		}
		return res.toString();
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.frequencySort("etttrr"));

	}

}
