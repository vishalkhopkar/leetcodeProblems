package longestPalindromeByConcatenating2LetterWords;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution {

	public int longestPalindrome(String[] words) {
        Map<String, Integer> wordCount = new HashMap<>();
        String rev;
        Integer count, countX;
        int ret = 0;
        for(String x : words) {
        	System.out.println("x = "+x);
        	rev = reverse(x);
        	count = wordCount.get(rev);
        	if(count == null || count == 0) {
        		countX = wordCount.get(x);
        		if(countX == null || countX == 0)
        			wordCount.put(x, 1);
        		else
        			wordCount.put(x, countX + 1);
        	}
        	else {
        		ret += 4;
        		wordCount.put(rev, count - 1);
        		System.out.println("count of rev "+count);
        		System.out.println("rev found ret now "+ret);
        	}
        }
        // check for remaining keys
        Map.Entry<String, Integer> entry;
        Iterator<Map.Entry<String, Integer>> it = wordCount.entrySet().iterator();
        while(it.hasNext()) {
        	entry = it.next();
        	if(isSame(entry.getKey()) && entry.getValue() == 1) {
        		ret += 2;
        		break;
        	}
        }
        return ret;
    }
	
	private boolean isSame(String key) {
		
		return key.charAt(0) == key.charAt(1);
	}
	private String reverse(String x) {
		StringBuilder sb = new StringBuilder();
		sb.append(x.charAt(1));
		sb.append(x.charAt(0));
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] arr = {"qo","fo","fq","qf","fo","ff","qq","qf","of","of","oo","of","of","qf","qf","of"};
		System.out.println(s.longestPalindrome(arr));
		String x = "lle ffd";
		System.out.println(Arrays.toString(x.split("\s+")));
	}

}
