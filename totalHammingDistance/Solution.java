package totalHammingDistance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
	
	final double LOG2 = Math.log(2);
	int ret = 0;
	public int totalHammingDistance(int[] nums) {
        
        
        
        return ret;
    }

    public int hammingDistance(int x, int y) {
        if(x == y) return 0;
        int ret = 0;
        int limit = (int)Math.ceil(Math.log(Math.max(x, y))/LOG2) + 1;
        for(int i = 0; i < limit; i++) {
            if((x & 1) != (y & 1)) ret++;
            x >>= 1;
            y >>= 1;

        }
        return ret;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
