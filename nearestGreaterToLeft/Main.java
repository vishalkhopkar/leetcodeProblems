package nearestGreaterToLeft;

import java.util.Arrays;
import java.util.Stack;

public class Main {

	/*
	 * returns the element strictly greater than
	 */
	public int[] nearestGreaterToLeft(int[] arr) {
		int[] ret = new int[arr.length];
		
		/*
		 * The last element does not have any element greater
		 * to its right
		 */
		ret[0] = -1;
		Stack<Integer> st = new Stack<>();
		st.push(0);
		for(int i = 1; i < arr.length; i++) {
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
		int[] arr = {31,41,48,59,79};
		System.out.println(Arrays.toString(m.nearestGreaterToLeft(arr)));

	}

}

