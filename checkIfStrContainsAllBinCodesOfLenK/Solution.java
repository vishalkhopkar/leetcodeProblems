package checkIfStrContainsAllBinCodesOfLenK;

public class Solution {

	public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int p = n - k + 1;
        int totalPossible = (int)Math.pow(2, k);
        if(p < totalPossible) return false;
        boolean[] covered = new boolean[totalPossible];
        /*
         * consider s[0..k - 1] for the initial hash code
         */
        int hash = 0;
        int remaining = totalPossible;
        for(int i = 0; i < k; i++) {
        	hash += (s.charAt(i) - '0')*Math.pow(2, i);
        }
        System.out.println("init hash "+hash);
        covered[hash] = true;
        remaining--;
        for(int i = 1; i <= (n - k); i++) {
        	hash -= (s.charAt(i - 1) - '0');
        	hash >>= 1;
        	hash += (s.charAt(i + k - 1) - '0')*Math.pow(2, k - 1);
        	System.out.println("i = "+i+" hash = "+hash);
        	if(!covered[hash]) {
        		covered[hash] = true;
        		remaining--;
        	}
        }
        if(remaining == 0) return true;
        return false;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.hasAllCodes("00110", 2));

	}

}
