package zigzag;

public class Solution {

	public String convert(String s, int numRows) {
		if(numRows == 1) return s;
		StringBuilder[] stringsAtLevel = new StringBuilder[numRows];
		for(int i = 0; i < numRows; i++)
			stringsAtLevel[i] = new StringBuilder();
		int currentLevel = 0, inc = 1;
		for(int i = 0; i < s.length(); i++) {
			stringsAtLevel[currentLevel].append(s.charAt(i));
			currentLevel += inc;
			if(inc == 1) {
				if(currentLevel == numRows) {
					currentLevel-=2;
					inc = -1;
				}
			}			
			else {
				// inc == -1
				if(currentLevel == -1) {
					currentLevel += 2;
					inc = 1;
				}
			}
		}
		
		StringBuilder ret = new StringBuilder();
		for(int i = 0; i < numRows; i++)
			ret.append(stringsAtLevel[i]);
		return ret.toString();
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.convert("PAYPALISHIRING", 2));

	}

}
