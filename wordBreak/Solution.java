package wordBreak;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Set<String> cannotBeBroken = new HashSet<>();
        return canBreak(s, 0, s.length() - 1, dict, cannotBeBroken);
    }

	private boolean canBreak(String w, int s, int e, Set<String> dict, Set<String> dp) {
		
		
		String subStr = w.substring(s, e + 1);
		if(dp.contains(subStr)) return false;
		if(dict.contains(subStr)) {
			return true;
		}
		//System.out.println("canBreak("+w.substring(s, e + 1)+")");
		StringBuilder sb = new StringBuilder();
		boolean v;
		for(int i = s; i <= e; i++) {
			sb.append(w.charAt(i));
			if(dict.contains(sb.toString())) {
				v = canBreak(w, i + 1, e, dict, dp);
				if(v) {
					//dp.add(w.substring(i + 1, e + 1));
					return true;
				}
			}
		}
		dp.add(subStr);
		return false;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		List<String> dict = new ArrayList<>();
		String[] dictArr = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		for(String x : dictArr) {
			dict.add(x);
		}
		System.out.println(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", dict));

	}

}
