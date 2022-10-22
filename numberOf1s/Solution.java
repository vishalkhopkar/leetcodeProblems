package numberOf1s;

public class Solution {
	
	public int numSub(String s) {
        int currLen = 0;
        final int MODULO = (int)Math.pow(10, 9) + 7;
        int ret = 0;
        int sLen = s.length();
        boolean insideOnes = false;
        for(int i = 0; i < sLen; i++) {
        	if(s.charAt(i) == '1' && !insideOnes) {
        		insideOnes = true;
        		currLen = 1;
        	}
        	else if(s.charAt(i) == '1' && insideOnes) {
        		currLen++;
        	}
        	else if(s.charAt(i) == '0' && insideOnes) {
        		insideOnes = false;
        		ret += currLen*(currLen + 1)/2;
        	}
        }
        if(insideOnes) {
        	ret += currLen*(currLen + 1)/2;
        	ret %= MODULO;
        }
        return ret;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numSub("111111"));
	
	}

}
