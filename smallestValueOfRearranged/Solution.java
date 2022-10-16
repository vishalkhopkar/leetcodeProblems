package smallestValueOfRearranged;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	
	public long smallestNumber(long num) {
        if(num == 0) return 0;
        if(num < 0) return (-1)*largestNumberPositive((-1)*num);
        return smallestNumberPositive(num);
    }
	
	public long largestNumberPositive(long num) {
		List<Integer> digits = new ArrayList<>();
		while(num != 0) {
			digits.add((int)(num % 10));
			num /= 10;
		}
		System.out.println(digits);
		Collections.sort(digits);
		
		long ret = 0;
		
		for(int i = digits.size() - 1; i >= 0; i--) {
			ret += digits.get(i);
			if(i != 0)
				ret *= 10;
		}
		
		return ret;
	}

	public long smallestNumberPositive(long num) {
        /*
         * break number into individual digits
         * sort them
         * if there are any trailing zeroes,
         * bring the first non zero digit before
         * all of them
         */
		List<Integer> digits = new ArrayList<>();
		while(num != 0) {
			digits.add((int)(num % 10));
			num /= 10;
		}
		System.out.println(digits);
		Collections.sort(digits);
		int ind = 0;
		while(digits.get(ind) == 0) {
			ind++;
		}
		if(ind != 0) {
			digits.set(0, digits.get(ind));
			digits.set(ind, 0);
		}
		
		/*
		 * now ind has the first non zero digit
		 */
		long ret = 0;
		System.out.println(digits);
		for(int i =0; i < digits.size(); i++) {
			System.out.println(ret);
			ret += digits.get(i);
			if(i != digits.size() - 1)
				ret *= 10;
		}
		
		return ret;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.smallestNumberPositive(340));
		System.out.println(s.largestNumberPositive(340));
		System.out.println(s.smallestNumber(63));
	}

}
