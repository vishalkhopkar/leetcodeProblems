package palindromePartitioning.try2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	List<List<String>> globalList = new ArrayList<>();
	int currInd = 0;
	public List<List<String>> partition(String s) {
		globalList.add(new ArrayList<>());
        partition(s, 0, s.length() - 1);
        List<List<String>> ret = new ArrayList<>();
        for(int i = 0; i < globalList.size(); i++) {
        	if(globalList.get(i).size() != 0) {
        		ret.add(globalList.get(i));
        	}
        }
        return ret;
    }
	
	private void partition(String s, int start, int end) {
		if(start > end) return;
		System.out.println("PAR("+start+", "+end+")");
		String x;
		for(int i = start; i <= end; i++) {
			x = isPalindrome(s, start, i);
			if(x != null) {
				System.out.println("found "+x);
				globalList.get(currInd).add(x);
				partition(s, i + 1, end);
			}
			
		}
		currInd++;
		globalList.add(new ArrayList<>());
	}
	
	private String isPalindrome(String s, int start, int end) {
		char[] ret = new char[end - start + 1];
		for(int i = 0; i <= (end - start + 1)/2; i++) {
			if(s.charAt(start + i) != s.charAt(end - i)) {
				return null;
			}
			else {
				ret[i] = s.charAt(start + i);
				ret[ret.length - i - 1] = ret[i];
			}
		}
		return String.valueOf(ret);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		//System.out.println(s.isPalindrome("CCABBACA", 1, 7));
		System.out.println(s.partition("cdd"));

	}

}
