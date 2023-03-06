package maxScoreWords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
	
	/**
	 * 
	 * @param words
	 * @param letters
	 * @param score score.length is 26
	 * @return
	 */
	public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] scoresOfWords = new int[words.length];
        List<Map<Character, Integer>> charCounts = new ArrayList<>();
        /*
         * check if it is possible to make each word with the given letters
         */
        Integer count;
        char x;
        for(int i = 0; i < words.length; i++) {
        	Map<Character, Integer> countMap = new HashMap<>();
        	
        	for(int j = 0; j < words[i].length(); j++) {
        		x = words[i].charAt(j);
        		count = countMap.get(x);
        		if(count != null) countMap.put(x, count + 1);        		
        		else countMap.put(x, 1);
        		scoresOfWords[i] += score[x - 'a'];
        	}
        	charCounts.add(countMap);
        }
        System.out.println(Arrays.toString(scoresOfWords));
        List<String> possibleWords = new ArrayList<>();
        List<Integer> scoresOfPossibleWords = new ArrayList<>();
        
        /*
         * make a map of letters
         */
        Map<Character, Integer> letterMap = new HashMap<>();
        for(char c : letters) {
        	count = letterMap.get(c);
        	if(count != null) letterMap.put(c, count + 1);
        	else letterMap.put(c, 1);
        }
        
        
        return maxScore(words, charCounts, scoresOfWords, 0, letterMap);
    }
	
	private int maxScore(String[] words, List<Map<Character, Integer>> charCounts, int[] scores, int start, Map<Character, Integer> letterMap) {
		
		if(start >= scores.length) return 0;
		//System.out.println("checking for "+words[start]+" letterMap "+letterMap);
		Map<Character, Integer> newMap = checkIfWordPossible(charCounts.get(start), letterMap);
		if(newMap == null) {
			/*
			 * not possible to make this word with existing letters
			 */
			return maxScore(words, charCounts, scores, start + 1, letterMap);
		}
		/*
		 * possible to make
		 */
		return Math.max(
				maxScore(words, charCounts, scores, start + 1, newMap) + scores[start],
				maxScore(words, charCounts, scores, start + 1, letterMap)
		);
		
	}

	private Map<Character, Integer> checkIfWordPossible(Map<Character, Integer> map, Map<Character, Integer> letterMap) {
		Map<Character, Integer> ret = new HashMap<>(letterMap);
		Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
		Map.Entry<Character, Integer> entry;
		int aaplyakadeKitiAhet, requirement;
		while(it.hasNext()) {
			entry = it.next();
			aaplyakadeKitiAhet = letterMap.getOrDefault(entry.getKey(), 0);
			requirement = entry.getValue();
			if(requirement > aaplyakadeKitiAhet) {
				return null;
			}
			else {
				if(aaplyakadeKitiAhet - requirement == 0)
					ret.remove(entry.getKey());
				else
					ret.put(entry.getKey(), aaplyakadeKitiAhet - requirement);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		String[] words = {"dog","cat","dad","good"};
		char[] letters = {'a','a','c','d','d','d','g','o','o'} ;
		int[] scores = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
		System.out.println(new Solution().maxScoreWords(words, letters, scores));

	}

}
