package fractionToDec;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder res = new StringBuilder();
        boolean isNegative = false;
        Map<Integer, Integer> uniqueRems = new HashMap<>();
        if(numerator % denominator == 0) return String.valueOf(numerator / denominator);
        if(numerator < 0 && denominator < 0) {
        	numerator = -numerator;
        	denominator = -denominator;
        }
        else if(numerator < 0 || denominator < 0) {
        	numerator = Math.abs(numerator);
        	denominator = Math.abs(denominator);
        	isNegative = true;
        			
        }
        int whole = numerator / denominator;
    	res.append(whole);
    	res.append('.');
    	int decimalPtPosn = res.length() - 1;
    	numerator %= denominator;
    	int quo, rem = numerator;
    	int placesAfterDecimalPt = 0;
    	Integer prevPlace;
    	while(rem != 0) {
    		rem *= 10;
    		quo = rem / denominator;
    		
    		rem -= quo*denominator;
    		prevPlace = uniqueRems.get(rem);
    		if(prevPlace != null && Integer.valueOf(String.valueOf(res.charAt(decimalPtPosn + prevPlace + 1))) == quo) {
    			/*
    			 * recurring
    			 */
    			System.out.println("number at prev place "+Integer.valueOf(String.valueOf(res.charAt(decimalPtPosn + prevPlace + 1))));
    			System.out.println("repeated remainder "+quo);
    			String finite = res.substring(decimalPtPosn + 1, decimalPtPosn + 1 + prevPlace);
    			String recurring = res.substring(decimalPtPosn + 1 + prevPlace, res.length());
    			System.out.println("finite "+finite);
    			System.out.println("recurring "+recurring);
    			res = new StringBuilder();
    			res.append(whole);
    			res.append('.');
    			res.append(finite);
    			res.append('(');
    			res.append(recurring);
    			res.append(')');
    			break;
    		}
    		else {
    			res.append(quo);
    			uniqueRems.put(rem, placesAfterDecimalPt++);
    		}
    		System.out.println("now "+res);
    	}
        if(isNegative) {
        	return "-" + res.toString();
        }
        return res.toString();
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.fractionToDecimal(2, 5));

	}

}
