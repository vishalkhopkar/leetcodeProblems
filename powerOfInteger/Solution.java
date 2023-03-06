package powerOfInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

	int power(int x) {
		int steps = 0;
		while(x > 1) {
			if(x % 2 == 0) x /= 2;
			else x = 3*x + 1;
			steps++;
		}
		return steps;
	}
	
	public int getKth(int lo, int hi, int k) {
        List<Integer> arr = new ArrayList<>();
        int ctr = lo;
        for(int i = lo; i <= hi; i++) {
        	arr.add(i);
        }
        Collections.sort(arr, new Comparator<>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				int x = power(o1);
				int y = power(o2);
				if(x == y) {
					return o1 - o2;
				}
				return x - y;
			}
        	
        });
        return arr.get(k - 1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
