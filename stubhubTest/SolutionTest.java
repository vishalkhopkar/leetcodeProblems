package stubhubTest;

import java.util.Arrays;
import java.util.Random;

public class SolutionTest {

	public static void main(String[] args) {
		Solution s = new Solution();
		Random r = new Random();
		int N, F, M, sum, resSum, sumA;
		int[] A;
		int[] res;
		for(int i = 0; i < 5000; i++) {
			N = r.nextInt(2, 100000 + 1);
			F = r.nextInt(1, N);
			A = new int[N - F];
			sum = 0;
			sumA = 0;
			for(int j = 0; j < A.length; j++) {
				A[j] = r.nextInt(1, 7);
				sum += A[j];
				sumA += A[j];
			}
			for(int j = 0; j < F; j++) {
				sum += r.nextInt(1, 7);
			}
			M = sum/N;
			if(M != Math.ceil(M)) continue;
			res = s.solution(A, F, M);
			
			/*
			 * check res
			 */
			resSum = 0;
			for(int j = 0; j < res.length; j++) {
				if(res[j] < 0 || res[j] > 6) {
					System.out.println(Arrays.toString(A)+ ", F = "+F+", M = "+M);
					System.out.println("out of bounds "+resSum+" sumA = "+sumA+" sum = "+sum+" res = "+Arrays.toString(res));
					
					assert false;
				}
				resSum += res[j];
				
			}
			
			if(res.length > 1 && sumA + resSum != M*N) {
				System.out.println(Arrays.toString(A)+ ", F = "+F+", M = "+M);
				System.out.println("incorrect sum "+resSum+" sumA = "+sumA+" sum = "+sum+" res = "+Arrays.toString(res));
				assert false;
			}
		}
	}

}
