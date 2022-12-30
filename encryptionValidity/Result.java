package encryptionValidity;

import java.util.ArrayList;
import java.util.List;

public class Result {

	public static List<Integer> encryptionValidity(int instructionCount, int validityPeriod, List<Integer> keys) {
		
		final int MULTIPLIER = (int)Math.pow(10, 5);
		/*
		 * Find that element in keys which has the highest degree of divisibility
		 * Let us try an O(n^2) solution
		 */
		int m = -1;
		int maxDegreeOfDivisiblity = Integer.MIN_VALUE;
		int degOfDivisibility;
		for(int i = 0; i < keys.size(); i++) {
			degOfDivisibility = 0;
			for(int j = 0; j < keys.size(); j++) {
				if(keys.get(i) % keys.get(j) == 0) {
					degOfDivisibility++;
				}
			}
			if(degOfDivisibility > maxDegreeOfDivisiblity) {
				maxDegreeOfDivisiblity = degOfDivisibility;
				m = keys.get(i);
			}
		}
		//System.out.println("m = "+m+" max degree of divisibility = "+maxDegreeOfDivisiblity);
		long encryptionStrength = maxDegreeOfDivisiblity*MULTIPLIER;
		long processingPower = (long) instructionCount* (long)validityPeriod;
		//System.out.println("encryption strength "+encryptionStrength);
		//System.out.println("processing power "+processingPower);
		List<Integer> ret = new ArrayList<>(2);
		if(encryptionStrength <= processingPower) {
			ret.add(1);
		}
		else {
			ret.add(0);
		}
		ret.add((int)encryptionStrength);
		return ret;
		

	}
	public static void main(String[] args) {
		List<Integer> keys = new ArrayList<>();
		int[] keysArr = {83315, 22089, 19068, 64911, 67636, 4640, 80192, 98971};
		for(int x : keysArr) {
			keys.add(x);
		}
		System.out.println(encryptionValidity(9677958, 50058356, keys));

	}

}
