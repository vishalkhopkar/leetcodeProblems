package maxXORInArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	class ReturnPOJO {
		StringBuilder binary;
		int noOfContinuousOnes;
		int number;
		public ReturnPOJO(StringBuilder binary, int noOfContinuousOnes, int number) {
			super();
			this.binary = binary;
			this.noOfContinuousOnes = noOfContinuousOnes;
			this.number = number;
		}
		
		
	}
	
	public int findMaximumXOR(int[] nums) {
		/*
		 * Find the numbers with the maximum bits
		 */
		int maxBits = 0;
		List<Integer> nosWithMaxBits = new ArrayList<>();
		int noOfBits;
		int[] bits = new int[nums.length];
		final double LOG2 = Math.log(2);
		for(int i = 0; i < nums.length; i++) {
			noOfBits = (int) (Math.log(nums[i]) / LOG2) + 1;
			bits[i] = noOfBits;
			if(noOfBits > maxBits) {
				maxBits = noOfBits;
			}
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(bits[i] == maxBits) {
				nosWithMaxBits.add(nums[i]);
			}
		}
		System.out.println("NOS WITH MAX BITS "+nosWithMaxBits);
		int noOfNumbersWithMaxBits = nosWithMaxBits.size();
        
		ReturnPOJO[] bins = new ReturnPOJO[noOfNumbersWithMaxBits];
		int maxOneSeries = 0;
		for(int i = 0; i < noOfNumbersWithMaxBits; i++) {
			bins[i] = convertToBinReverse(nosWithMaxBits.get(i));
			if(bins[i].noOfContinuousOnes > maxOneSeries) {
				maxOneSeries = bins[i].noOfContinuousOnes;
			}
		}
		
		// comment later
		/*
		for(int i = 0; i < noOfNumbersWithMaxBits; i++) {
			System.out.println(nosWithMaxBits.get(i)+" "+bins[i]);
		}
		*/
		/*
         * Find the nos with the maximum series of 1s
         * starting from their MSBs
         */
		System.out.println("max no of continuous ones "+maxOneSeries);
		List<Integer> nosWithMaximumOneSeries = new ArrayList<>();
		for(int i = 0; i < noOfNumbersWithMaxBits; i++) {
			
				nosWithMaximumOneSeries.add(bins[i].number);
		}
		System.out.println("nos with max series of 1s "+nosWithMaximumOneSeries);
		
		/*
		 * The maximum XOR will be between one of these numbers
		 * and any other number
		 */
		int maxXor = 0, xor;
		for(int i = 0; i < nosWithMaximumOneSeries.size(); i++) {
			for(int j = 0; j < nums.length; j++) {
				if(nums[j] != nosWithMaximumOneSeries.get(i)) {
					xor = nums[j] ^ nosWithMaximumOneSeries.get(i);
					System.out.println(nums[j]+" xor "+nosWithMaximumOneSeries.get(i)+ " = "+xor);
					if(xor > maxXor) {
						maxXor = xor;
					}
				}
			}
		}
		return maxXor;
    }
	
	ReturnPOJO convertToBinReverse(int num1) {
		StringBuilder num1SB = new StringBuilder();
		int originalNumber = num1;
        int continuousOnes = 0;
        while(num1 != 0) {
        	if(num1 % 2 == 1) {
        		continuousOnes++;
        	}
        	else {
        		continuousOnes = 0;
        	}
        	num1SB.append(num1 % 2);
        	num1 >>= 1;
        }
        System.out.println(num1SB+" "+continuousOnes);
        return new ReturnPOJO(num1SB, continuousOnes, originalNumber);
	}
	public static void main(String[] args) {
		int[] nums = {2, 4};
		
		Solution s = new Solution();
		System.out.println(s.findMaximumXOR(nums));

	}

}
