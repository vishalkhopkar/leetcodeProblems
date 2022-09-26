package longestSubstrWoRepeatingChars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	
	public int lengthOfLongestSubstring(String s) {
		if(s.length() == 0) return 0;
		// build a positions map
		Map<Character, List<Integer>> positionMap = buildPositionMap(s);
		//System.out.println(positionMap);
		char newCharEncountered;
		int pos, maxUntilNow = 1, currLen = 1;
		int start = 0, end = 0;
		while(end < s.length() - 1) {			
			end++;
			System.out.println("start "+start+", end = "+end);
			// check for substr s[start...end]
			newCharEncountered = s.charAt(end);
			//System.out.println("new char "+newCharEncountered);
			pos = isRepeating(newCharEncountered, start, end - 1, positionMap);
			//System.out.println("is repeating "+pos);
			if(pos != -1) {
				// it is repeating
				start = pos + 1;
				System.out.println("start now "+start);
				if(currLen > maxUntilNow) {
					maxUntilNow = currLen;
					System.out.println("prev currlen/maxuntilnow "+maxUntilNow);
				}
				currLen = end - start + 1;
				System.out.println("repeating currlen "+currLen);
			}
			else {
				// not repeating
				
				currLen++;
				System.out.println("nr currlen "+currLen);
			}
				
			
		}
		if(currLen > maxUntilNow) maxUntilNow = currLen;
		return maxUntilNow;
	}
	
	private Map<Character, List<Integer>> buildPositionMap(String s) {
		Map<Character, List<Integer>> positionMap = new HashMap<>();
		List<Integer> positionsOfChar;
		for(int i = 0; i < s.length(); i++) {
			positionsOfChar = positionMap.get(s.charAt(i));
			if(positionsOfChar == null) {
				positionsOfChar = new ArrayList<>();
				positionMap.put(s.charAt(i), positionsOfChar);
			}
			positionsOfChar.add(i);
			
		}
		return positionMap;
	}

	private int isRepeating(char newCharEncountered, int start, int limit, Map<Character, List<Integer>> positionMap) {
		// check if newCharEncountered is present between start and limit
		List<Integer> positionsOfChar = positionMap.get(newCharEncountered);
		// note that positionsOfChar cannot be null here,
		// since the letter is present at least once
		int bsResult = binarySearch(positionsOfChar, start);
		System.out.println("bs result "+bsResult+" positionsOfChar "+positionsOfChar);
		if(bsResult > limit) {
			// the result returned by BS is higher than limit
			// so no number between start and limit is not present in positionsOfChar
			return -1;
		}
		else {
			// present in the positionsOfChar list
			return bsResult;
		}
	}
	
	/**
	 * Returns the closest value just greater than key in the list
	 * @param positionsOfChar
	 * @param start
	 * @return
	 */
	private int binarySearch(List<Integer> arr, int val) {
		int start = 0, end = arr.size() - 1;
		
		int mid = 0;
		while(start != end) {
			//System.out.println("start = "+start+", mid = "+mid+", end = "+end);
			mid = (start + end)/2;
			if(arr.get(mid) == val) return arr.get(mid);
			else if(arr.get(mid) > val) end = mid;
			else start = mid + 1;
		}
		//System.out.println("start = "+start+", mid = "+mid);
		return arr.get(start);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.lengthOfLongestSubstring("bbbtablud"));
		//System.out.println(s.lengthOfLongestSubstring("abcabcbb"));

	}

}
