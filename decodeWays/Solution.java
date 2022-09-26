package decodeWays;

import java.util.Arrays;

public class Solution {
	int[] dpTable;
	private int decodeWays(String s, int sLen, int startIndex) {
		if(startIndex >= sLen) return 0;
		if(dpTable[startIndex] != -1) return dpTable[startIndex];		
		if(startIndex == sLen - 1) {
			// only last digit remaining
			if(s.charAt(startIndex) == '0') {
				dpTable[startIndex] = 0;
				return 0;
			}
			dpTable[startIndex] = 1;
			return 1;
		}
		if(startIndex == sLen - 2) {
			if(s.charAt(startIndex) == '0') {
				dpTable[startIndex] = 0;
				return 0;
			}
			if(s.charAt(startIndex + 1) == '0') {
				
				if(s.charAt(startIndex) > '2' || s.charAt(startIndex) < '1') {
					dpTable[startIndex] = 0;
					return 0;
				}
				else {
					dpTable[startIndex] = 1;
					return 1;
				}
			}
			if(Integer.valueOf(s.substring(startIndex, startIndex + 2)) <= 26) {
				dpTable[startIndex] = 2;
				return 2;
			}
			else {
				dpTable[startIndex] = 1;
				return 1;
			}
		}
		int firstNo = Integer.valueOf(s.substring(startIndex, startIndex + 1));
		int secondNo = Integer.valueOf(s.substring(startIndex, startIndex + 2));
		if(firstNo == 0) {
			// a string like 3000 cannot be decoded
			dpTable[startIndex] = 0;
			return 0;
		}
		if(secondNo <= 26) {
			// something like 1253.. which can be (12)53... or (1)253...
			dpTable[startIndex] = decodeWays(s, sLen, startIndex + 2) + decodeWays(s, sLen, startIndex + 1);
			return dpTable[startIndex];
		}
		else {
			// something like 3543... which can only be (3)453...
			dpTable[startIndex] = decodeWays(s, sLen, startIndex + 1);
			return dpTable[startIndex];
		}
	}
	
	public int numDecodings(String s) {
		dpTable = new int[s.length()];
		Arrays.fill(dpTable, -1);
		return decodeWays(s, s.length(), 0);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.numDecodings("230"));

	}

}
