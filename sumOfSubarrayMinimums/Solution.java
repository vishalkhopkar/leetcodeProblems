package sumOfSubarrayMinimums;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

	private static final int MODULO = (int)Math.pow(10, 9) + 7;
	public int[] nearestSmallerToRight(int[] arr, Stack<Integer> st) {
		int[] ret = new int[arr.length];
		
		/*
		 * The last element does not have any element greater
		 * to its right
		 */
		ret[arr.length - 1] = arr.length;
		st.clear();
		st.push(arr.length - 1);
		for(int i = arr.length - 2; i >= 0; i--) {
			/*
			 * compare arr[i] and st[top]
			 */
			while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				ret[i] = arr.length;
			}
			else {
				ret[i] = st.peek();
			}
			st.push(i);
		}
		System.out.println("nsr "+Arrays.toString(ret));
		return ret;
	}
	
	public int[] nearestSmallerToLeft(int[] arr, Stack<Integer> st) {
		st.clear();
		int[] ret = new int[arr.length];
		
		/*
		 * There is no element to the left of arr[0]
		 * so put -1
		 */
		ret[0] = -1;
		st.push(0);
		for(int i = 1; i < arr.length; i++) {
			
			while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
				st.pop();
			}
			
			if(st.isEmpty()) {				
				// no elem smaller than this
				ret[i] = -1;
			}
			else {
				ret[i] = st.peek();
			}
			st.push(i);
		}
		System.out.println("NSL "+Arrays.toString(ret));
		return ret;
	}
	
	private int noSubarraysContainingThis(int n, int pos) {
		System.out.println("naa ("+n+", "+pos+")");
		if(n % 2 == 0) {
			if(pos > (n/2 - 1)) {
				pos = n - pos - 1;
			}
		}
		else {
			// n is odd
			if(pos > (n/2)) {
				pos = n - pos - 1;
			}
		}
		System.out.println("naa processed ("+n+", "+pos+")");
		int maxNo = pos + 1;
		int maxFreq = n - 2*pos;
		return pos*(pos + 1) + maxNo*maxFreq;
	}
	
	public int sumSubarrayMins(int[] arr) {
		
		
        Stack<Integer> st = new Stack<>();
        int[] nsl = nearestSmallerToLeft(arr, st);
        int[] nsr = nearestSmallerToRight(arr, st);
        int ret = 0;
        int n, pos;
        for(int i = 0; i < arr.length; i++) {
        	n = nsr[i] - nsl[i] - 1;
        	pos = i - (nsl[i] + 1);
        	ret += noSubarraysContainingThis(n, pos)*arr[i];
        	ret %= MODULO;
        }
        return ret;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr1 = {71,55,82,55};
		System.out.println(s.sumSubarrayMins(arr1));
		System.out.println(s.noSubarraysContainingThis(6, 4));
	}

}
