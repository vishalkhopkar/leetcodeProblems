package nearestGreaterToRight;

import java.util.Arrays;
import java.util.Stack;

public class Main {

	/*
	 * returns the element strictly greater than
	 */
	public int[] nearestGreaterToRight(int[] arr) {
		int[] ret = new int[arr.length];
		
		/*
		 * The last element does not have any element greater
		 * to its right
		 */
		ret[arr.length - 1] = -1;
		Stack<Integer> st = new Stack<>();
		st.push(arr.length - 1);
		for(int i = arr.length - 2; i >= 0; i--) {
			/*
			 * compare arr[i] and st[top]
			 */
			while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
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
		int[] arr = {1, 3, 0, 0, 1, 2, 4};
		System.out.println(Arrays.toString(m.nearestGreaterToRight(arr)));

	}

}
