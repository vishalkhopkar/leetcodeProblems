package countAndSay;

public class Solution {
	
	public String countAndSay(int n) {
        String[] table = new String[n];
        table[0] = "1";
        for(int i = 1; i < n; i++) {
        	table[i] = getCountStr(table[i - 1]);
        }
        return table[n - 1];
    }
	
	String getCountStr(String inputNo) {
		/*
		 * if inputNo = "1211"
		 * return "11, 12, 21" = "111221"
		 */
		StringBuilder sb = new StringBuilder();
		char currNo = inputNo.charAt(0);
		int currNoCount = 1;
		for(int i = 1; i < inputNo.length(); i++) {
			if(inputNo.charAt(i) == inputNo.charAt(i - 1)) {
				currNoCount++;
			}
			else {
				
				sb.append(currNoCount);
				sb.append(currNo);
				currNo = inputNo.charAt(i);
				currNoCount = 1;
			}
		}
		sb.append(String.valueOf(currNoCount)+String.valueOf(currNo));
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.getCountStr("111221"));
		System.out.println(s.countAndSay(4));
	}

}
