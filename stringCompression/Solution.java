package stringCompression;

import java.util.Arrays;

public class Solution {

	public int compress(char[] chars) {
		int currStart = 0;
        int currEnd = 1, currCnt = 1, currWriter = 0;
        String cntValue;
        while(currEnd < chars.length) {
        	if(chars[currEnd] == chars[currStart]) {
        		currEnd++;
        		currCnt++;        		
        	}
        	else {
        		
    			/*
    			 * a sequence just ended
    			 */
    			cntValue = String.valueOf(currCnt);
    			/*
    			 * write the char first
    			 */
    			chars[currWriter++] = chars[currStart];
    			if(currCnt > 1) {
    				for(int i = 0; i < cntValue.length(); i++) {
        				chars[currWriter++] = cntValue.charAt(i);
        			}
    			}
    			
    			currCnt = 1;
    			currStart = currEnd;
    			currEnd++;
        		
        	}
        }
        
		
		cntValue = String.valueOf(currCnt);
		/*
		 * write the char first
		 */
		chars[currWriter++] = chars[currStart];
		if(currCnt > 1) {
			for(int i = 0; i < cntValue.length(); i++) {
				chars[currWriter++] = cntValue.charAt(i);
			}
		}
		
        System.out.println(Arrays.toString(chars));
        System.out.println("currWriter "+currWriter);
        return currWriter;
    }

	public static void main(String[] args) {
		char[] chars = {'a', 'a', 'a', 'b', 'c'};
		System.out.println(new Solution().compress(chars));
	}

}
