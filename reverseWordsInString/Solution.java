package reverseWordsInString;

public class Solution {

	public String reverseWords(String s) {
        String[] elems = s.split("\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = elems.length - 1; i >= 0; i--) {
        	sb.append(elems[i]);
        	if(i > 0) sb.append(" ");
        }
        return sb.toString().strip();
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.reverseWords("  hello world  "));

	}

}
