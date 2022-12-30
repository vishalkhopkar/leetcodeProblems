package uglyNumber2;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public int nthUglyNumber(int n) {
        Queue<Integer> pq = new PriorityQueue<>();
        int limit = (int) Math.ceil(Math.sqrt(n));
        for(int i = 0; i <= limit; i++) {
        	for(int j = 0; j <= limit; j++) {
        		for(int k = 0; k <= limit; k++) {
        			pq.offer((int)(Math.pow(2, i)* Math.pow(3, j) * Math.pow(5, k)));
        		}
        	}
        }
        
        for(int i = 1; i < n; i++) {
        	pq.poll();
        }
        
        return pq.poll();
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.nthUglyNumber(10));

	}

}
