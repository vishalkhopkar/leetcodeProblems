package multiplyStrings;

public class Solution {

	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0")) return "0";
        StringBuilder res = new StringBuilder();
        
        /*
         * Traverse both the strings in reverse
         */
        int num1Ctr = num1.length() - 1;
        int num2Ctr = num2.length() - 1;
        
        /*
         * num1Ctr and num2Ctr represent what digit positions
         * are we currently multiplying
         */
        
        int product;
        int carry = 0;
        StringBuilder roundSum = new StringBuilder();
        int numZeroes = 0;
        while(num2Ctr >= 0) {
        	numZeroes = num2.length() - 1 - num2Ctr;
        	for(int i = 0; i < numZeroes; i++) {
        		roundSum.append(0);
        	}
        	while(num1Ctr >= 0) {
        		product = Integer.parseInt(num1.substring(num1Ctr, num1Ctr + 1)) *
        				Integer.parseInt(num2.substring(num2Ctr, num2Ctr + 1)) + carry;
        		
        		if(product >= 10) {
        			carry = product/10;
        			product %= 10;
        		}
        		else {
        			carry = 0;
        		}
        		//System.out.println("carry "+carry+", product "+product);
        		roundSum.append(product);
        		num1Ctr--;
        	}
        	
        	if(carry != 0) {
        		roundSum.append(carry);
            	carry = 0;
        	}
        	
        	System.out.println("roundsum "+ reversed(roundSum));
        	res = stringSum(res, roundSum);
        	System.out.println("res "+reversed(res));
        	roundSum.setLength(0);
        	num1Ctr = num1.length() - 1;
        	num2Ctr--;
        }
        return reversed(res);
    }
	
	private String reversed(StringBuilder string) {
		
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = string.length() - 1; i >= 0; i--) {			
			sb.append(string.charAt(i));
		}
		
		
		return sb.toString();
	}

	private StringBuilder stringSum(StringBuilder str1, StringBuilder str2) {
		int maxL = Math.max(str1.length(), str2.length());
		StringBuilder res = new StringBuilder();
		int num1, num2, sum, carry = 0;
		for(int i = 0; i < maxL; i++) {
			num1 = 0;
			num2 = 0;
			if(i < str1.length()) {
				num1 = Integer.parseInt(str1.substring(i, i + 1));				
			}
			if(i < str2.length()) {
				num2 = Integer.parseInt(str2.substring(i, i + 1));
			}
			sum = num1 + num2 + carry;
			if(sum >= 10) {
				carry = sum/10;
				sum %=10;
			}
			else {
				carry = 0;
			}
			res.append(sum);
		}
		if(carry != 0) {
			res.append(carry);
		}
		return res;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.multiply("123456789", "987654321"));

	}

}
