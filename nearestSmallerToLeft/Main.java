package nearestSmallerToLeft;

import java.util.Arrays;
import java.util.Stack;

public class Main {

	public int[] nearestSmallerToLeft(int[] arr) {
		Stack<Integer> st = new Stack<>();
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
		return ret;
	}
	public static void main(String[] args) {
		Main m = new Main();
		int[] arr = {11, 81, 94,	43,	3};
		System.out.println(Arrays.toString(m.nearestSmallerToLeft(arr)));

	}

}
