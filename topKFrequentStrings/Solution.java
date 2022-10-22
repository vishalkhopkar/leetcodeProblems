package topKFrequentStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Solution {

	public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencies = new TreeMap<>();
        Map<Integer, List<String>> ultaFrequencies = 
        		new TreeMap<>(Collections.reverseOrder());
        Integer val;
        List<String> wordsAtFreq;
        for(String x : words) {
        	val = frequencies.get(x);
        	if(val == null) {
        		val = 1;
        		frequencies.put(x, val);
        		
        	}
        	else frequencies.put(x, ++val);    	
        	
        }
        for(String key : frequencies.keySet()) {
        	val = frequencies.get(key);
        	wordsAtFreq = ultaFrequencies.get(val);
        	if(wordsAtFreq == null) {
        		wordsAtFreq = new ArrayList<>();
        		wordsAtFreq.add(key);
        		ultaFrequencies.put(val, wordsAtFreq);
        	}
        	else {
        		wordsAtFreq.add(key);
        	}
        }
        System.out.println(frequencies);
        System.out.println(ultaFrequencies);
        int wordsOutput = 0;
        List<String> preFinalWords = new ArrayList<>();
        Iterator<Entry<Integer, List<String>>> it = ultaFrequencies.entrySet().iterator();
        while(it.hasNext() && wordsOutput < k) {
        	wordsAtFreq = it.next().getValue();
        	for(String x : wordsAtFreq) {
        		preFinalWords.add(x);
        		wordsOutput++;
        		if(wordsOutput == k) break;
        	}
        }
        
        return preFinalWords;
    }
	public static void main(String[] args) {
		String[] words = {"the","day","is","sunny","the","the","the","sunny","is","is"};
		Solution s = new Solution();
		System.out.println(s.topKFrequent(words, 4));

	}

}
