package nearestSmallerToRight;

import java.util.Arrays;
import java.util.Stack;

public class Main {

	public int[] nearestSmallerToRight(int[] arr) {
		int[] ret = new int[arr.length];
		
		/*
		 * The last element does not have any element greater
		 * to its right
		 */
		ret[arr.length - 1] = arr.length;
		Stack<Integer> st = new Stack<>();
		st.push(arr.length - 1);
		for(int i = arr.length - 2; i >= 0; i--) {
			/*
			 * compare arr[i] and st[top]
			 */
			while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
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
		return ret;
	}
	public static void main(String[] args) {
		Main m = new Main();
		int[] arr = {11, 81, 94,	43,	3};
		System.out.println(Arrays.toString(m.nearestSmallerToRight(arr)));

	}

}
