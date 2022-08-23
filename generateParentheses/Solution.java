package generateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<String> output = new ArrayList<>();
	public static void main(String[] args) {
		Solution s = new Solution();
		s.generateParenthesis(4);

	}
	public List<String> generateParenthesis(int n) {
		generateParentheses("", 0, 0, n);
		return output;
	}
	
	private void generateParentheses(String brackets, int noOfOpenBrackets, int noOfClosedBrackets, int n) {
		//System.out.println(brackets.toString()+ " "+ noOfOpenBrackets + " " + noOfClosedBrackets);
		if(noOfOpenBrackets == n) {
			// add (n - noOfClosedBrackets) and end this branch
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < (n - noOfClosedBrackets); i++) {
				sb.append(")");
			}
			brackets += sb.toString();
			output.add(brackets.toString());
			System.out.println(brackets.toString());
		}
		else if(noOfOpenBrackets == 0) {
			brackets += "(";
			generateParentheses(brackets, 1, 0, n);
		}
		else {
			if(noOfOpenBrackets == noOfClosedBrackets) {
				generateParentheses(brackets + "(", noOfOpenBrackets + 1, noOfClosedBrackets, n);
			}
			else {
				generateParentheses(brackets + "(", noOfOpenBrackets + 1, noOfClosedBrackets, n);
				generateParentheses(brackets + ")", noOfOpenBrackets, noOfClosedBrackets + 1, n);
			}
		}
	}

}
