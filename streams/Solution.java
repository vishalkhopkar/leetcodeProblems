package streams;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {

	private void addToSum() {
		
	}
	public static void main(String[] args) {
		int[] a = {3, 2, 1, 0, -1, -5, -7};
		IntStream i = Arrays.stream(a);
		//IntStream b = i.map(x -> x*x);
		//int[] y = b.toArray();
		//System.out.println(Arrays.toString(y));
		IntStream c = i.filter(x -> (x >= 0));
		System.out.println(Arrays.toString(c.toArray()));
		
		int sum = 0;
		int[] u = {4, 5, 1, -9};
		IntStream uStream = Arrays.stream(u);
		uStream.forEach(addToSum);
	}

}
