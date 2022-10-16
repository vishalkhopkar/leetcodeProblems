package fairSplit;

import java.util.Arrays;

class Pair{
	int x, y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}
public class Solution {

	public int solution(int[] A, int[] B) {
		// find SL and SR
		int[] aSLeft = new int[A.length];
		int[] aSRight = new int[A.length];
		
		int[] bSLeft = new int[B.length];
		int[] bSRight = new int[B.length];
		
		aSLeft[0] = A[0];
		aSRight[A.length - 1] = A[A.length - 1];
		
		bSLeft[0] = B[0];
		bSRight[B.length - 1] = B[B.length - 1];
		
		int ret = 0;
		for(int i = 1; i < A.length; i++) {
			aSLeft[i] = aSLeft[i - 1] + A[i];
			aSRight[A.length - 1 - i] = aSRight[A.length - i] + A[A.length - 1 - i];
			
		}
		
		for(int i = 1; i < B.length; i++) {
			bSLeft[i] = bSLeft[i - 1] + B[i];
			bSRight[B.length - 1 - i] = bSRight[B.length - i] + B[B.length - 1 - i];
			
		}
		
		for(int i = 0; i < Math.min(A.length, B.length) - 1; i++) {
			if(aSLeft[i] == aSRight[i + 1] && bSLeft[i] == bSRight[i + 1] && 
					aSLeft[i] == bSLeft[i]){
				// cut at the (i + 1)th index
				ret++;
			}
		}
		System.out.println(Arrays.toString(aSLeft));
		System.out.println(Arrays.toString(aSRight));
		
		System.out.println(Arrays.toString(bSLeft));
		System.out.println(Arrays.toString(bSRight));
		return ret;
	}
	 
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = {1, 2, 1, 2};
		int[] B = {1, 2, 1, 2};
		System.out.println(s.solution(A, B));

	}

}
