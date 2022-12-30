package stringInterleaving;

// TLEs
public class Solution {
	
	byte[][] dpTable;
	public boolean isInterleave(String s1, String s2, String s3) {
		dpTable = new byte[s1.length() + 1][s2.length() + 1];
		
		return isInterleave(s1, 0, s2, 0, s3, 0);
	}
	
	public boolean isInterleave(String s1, int s1Start, String s2, int s2Start, String s3, int s3Start) {
		System.out.println(s1Start+" "+s2Start);
		int currA = s1Start, currB = s2Start;
        int s1Len = s1.length(), s2Len = s2.length(), s3Len = s3.length();
        if(s3Len == 0) {
            if(s1Len == 0 && s2Len == 0) return true;
            return false;
        }
        if((s3Len - s3Start) != (s1Len - s1Start + s2Len - s2Start)) return false;
        if(dpTable[s1Start][s2Start] == -1) return false;
        
        for(int i = s3Start; i < s3Len; i++) {
        	if(currA < s1Len && currB < s2Len) {
        		if(s1.charAt(currA) != s2.charAt(currB)) {
        			if(s3.charAt(i) == s1.charAt(currA)) {
        				currA++;
        			}
        			else if(s3.charAt(i) == s2.charAt(currB)) {
        				currB++;
        			}
        			else {
        				dpTable[currA][currB] = -1;
        				return false;
        			}
        		}
        		else {
        			/*
        			 * s1[currA] == s2[currB] == s3[i]
        			 */
        			if(s3.charAt(i) != s1.charAt(currA)) {
        				dpTable[currA][currB] = -1;
        				return false;
        			}
        			else {
        				return isInterleave(s1, currA + 1, s2, currB, s3, i + 1) ||
        						isInterleave(s1, currA, s2, currB + 1, s3, i + 1);
        			}
        		}
        	}
        	else {
        		/*
        		 * we have reached the end of one of the strings
        		 */
        		if(currA == s1Len) {
        			if(s3.charAt(i) == s2.charAt(currB)) {
        				currB++;
        			}
        			else {
        				dpTable[currA][currB] = -1;
        				return false;
        			}
        		}
        		else {
        			/*
        			 * currB == s2Len
        			 */
        			if(s3.charAt(i) == s1.charAt(currA)) {
        				currA++;
        			}
        			else {
        				dpTable[currA][currB] = -1;
        				return false;
        			}
        		}
        	}
        }
        return true;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isInterleave( "aabcc", "dbbca", "aadbbcbcac"));
	}

}
