package minimizeXOR;

import java.util.Arrays;

public class Solution {

	public int minimizeXor(int num1, int num2) {
        StringBuilder num1SB = new StringBuilder();
        int[] noOfDigits = new int[2];
        
        while(num1 != 0) {
        	num1SB.append(num1 % 2);
        	num1 >>= 1;
        }
        System.out.println(num1SB.toString());
        // num1SB is binary of num1 in reverse
        
        // count the number of zeroes and 1s in num2 upto num1SB.length
        int bit;
        while(num2 != 0) {
        	bit = num2 % 2;
        	noOfDigits[bit]++;
        	num2 >>= 1;
        }
        System.out.println(Arrays.toString(noOfDigits));
        /*
         * if num2 length is higher than num1,
         * append those many zeroes to num1
         */
        int diff = (noOfDigits[0] + noOfDigits[1]) - num1SB.length();
        if(diff > 0) {
        	for(int i = 0; i < diff; i++) {
        		num1SB.append('0');
        	}
        }
        else if(diff < 0) {
        	// if num2 has lower length
        	noOfDigits[0] += (-1)*diff;
        }
        System.out.println("num1 now "+num1SB);
        int ret = 0;
        for(int i = num1SB.length() - 1; i >= 0; i--) {
        	if(num1SB.charAt(i) == '1') {
        		if(noOfDigits[1] > 0) {
        			ret += 1;
            		noOfDigits[1]--;
        		}
        		else {
        			ret += 0;
        			noOfDigits[0]--;
        		}
        		
        	}
        	else {
        		// num1SB.charAt(i) == 0
        		if(noOfDigits[0] > 0) {
        			ret += 0;
            		noOfDigits[0]--;
        		}
        		else {
        			ret += 1;
        			noOfDigits[1]--;
        		}
        	}
        	ret *= 2;
        	
        }
        return ret/2;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.log(15)/Math.log(2));
		Solution s = new Solution();
		System.out.println(s.minimizeXor(33, 17));
	}

}
