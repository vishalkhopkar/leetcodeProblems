package addKToAnArr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ret = new LinkedList<>();
        int ctr = 0, sum, carry = 0, x1, x2;
        while(ctr < num.length || k > 0) {
        	if(ctr < num.length) x1 = num[num.length - ctr - 1];
        	else x1 = 0;        	
        	
        	x2 = k%10;
        	sum = num[ctr] + k%10 + carry;
        	carry = sum/10;
        	sum %= 10;
        	ret.add(0, sum);
        	k /= 10;
        	ctr++;
        }
        return ret;
    }

	public static void main(String[] args) {
		
		
	}

}
