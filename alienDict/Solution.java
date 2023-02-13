package alienDict;

public class Solution {
	
	public boolean isAlienSorted(String[] words, String order) {
		boolean res;
		int[] orderArr = makeOrder(order);
        for(int i = 1; i < words.length; i++) {
        	/*
        	 * compare words[i] and words[i - 1]
        	 * 
        	 */
        	res = (replace(words[i - 1], orderArr).compareTo(replace(words[i], orderArr)) <= 0);
        	if(!res) return false;
        }
        return true;
    }
	
	private int[] makeOrder(String order) {
		int[] ret = new int[26];
		for(int i = 0; i < order.length(); i++) {
			ret[order.charAt(i) - 'a'] = i;
		}
		return ret;
	}

	private String replace(String string, int[] order) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < string.length(); i++) {
			sb.append((char)('a' + order[string.charAt(i) - 'a']));
		}
		System.out.println("translated str "+sb);
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] words = {"vishal", "ashlesha"};
		Solution s = new Solution();
		System.out.println(s.isAlienSorted(words, "abcdefghijklmnopqrstuvwxyz"));

	}

}
