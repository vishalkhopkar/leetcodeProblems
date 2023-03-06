package stubhubTest;

import java.util.Arrays;

public class Solution {

	public int[] solution(int[] A, int F, int M) {
        int sumA = Arrays.stream(A).sum();
        int totalRolls = A.length + F;
        int totalSum = totalRolls*M;
        int diff = totalSum - sumA;
        int[] zeroArr = {0};
        /*
         * find the number of possible ways of splitting diff into F parts
         */
        int[] ret = new int[F];
        if(diff % F == 0) {
        	/*
        	 * all 6s
        	 */
            int q = diff/F;
            if(q >= 1 && q <= 6){
                Arrays.fill(ret, q);
        	    return ret;
            }
            else return zeroArr;
        	
        }
        int avg;
        for(int i = 0; i < ret.length; i++) {
        	avg = diff/F;
            if(avg > 6 || avg < 1){
                return zeroArr;
            }
        	ret[i] = avg;
        	diff -= avg;
        	F--;
        }
        return ret;
        
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = {1, 5, 6};
		System.out.println(s.solution(null, 0, 0));

	}

}

