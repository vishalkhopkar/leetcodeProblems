package largestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

	class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o2, Integer o1) {
			if(o1.equals(o2)) {
				// tie breaker
				return 1;
			}
			String x = String.valueOf(o1);
			String y = String.valueOf(o2);
			int m = x.length();
			int n = y.length();
			int limit = Math.min(m,  n);
			for(int i = 0; i < limit; i++) {
				if(x.charAt(i) == y.charAt(i)) {
					/*
					 * if both chars are equal,
					 * proceed ahead
					 */
					
				}
				else {
					return x.charAt(i) > y.charAt(i) ? 1 : -1;
				}
			}
			/*
			 * If you've come here, it means 
			 * you've exhausted the limit
			 */
			char dealBreaker;
			if(m > n) {
				// x > y
				dealBreaker = x.charAt(limit);
				if(dealBreaker > y.charAt(0)) return 1;
				if(dealBreaker == y.charAt(0)) {
					return max(x, y);
				}
				
				return -1;
			}
			
			// y > x
			System.out.println("x = "+x+" y = "+y);
			dealBreaker = y.charAt(limit);
			if(dealBreaker > x.charAt(0)) return -1;
			if(dealBreaker == x.charAt(0)) {
				return max(x, y);
			}
			return 1;
		}

		private int max(String x1, String y1) {
			/*
			 *	check x+y, y+x
			 *	whichever is greater, return 1/-1 
			 */
			String x = x1.concat(y1);
			String y = y1.concat(x1);
			
			int m = x.length();
			int n = y.length();
			int limit = Math.min(m,  n);
			for(int i = 0; i < limit; i++) {
				if(x.charAt(i) == y.charAt(i)) {
					/*
					 * if both chars are equal,
					 * proceed ahead
					 */
					
				}
				else {
					return x.charAt(i) > y.charAt(i) ? 1 : -1;
				}
			}
			return 0;
		}
		
	}
	public String largestNumber(int[] nums) {
		Integer[] nums1 = new Integer[nums.length];
		for(int i = 0; i < nums.length; i++) nums1[i] = nums[i];
        Arrays.sort(nums1, new MyComparator());
        System.out.println(Arrays.toString(nums1));
        StringBuilder sb = new StringBuilder();
        Integer x;
        for(int i = 0; i < nums1.length; i++) {
        	x = nums1[i];
        	/*
        	 * if x is 0, do not append unless
        	 * it is the last number
        	 */
        	sb.append(x);
        }
        // remove any trailing zeroes
        if(sb.charAt(0) == '0') {
        	// all zeroes
        	return "0";
        }
        if(sb.isEmpty()) return "0";
        return sb.toString();
        
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {0, 0};
		System.out.println(s.largestNumber(nums));
		MyComparator a = s.new MyComparator();
		System.out.println(a.compare(30323, 3032));
	}

}
