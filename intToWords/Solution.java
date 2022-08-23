package intToWords;

public class Solution {
	String[] powInWords = {null, null, "Hundred", "Thousand", null, null, "Million", null, null, "Billion"};
    String[] basic = {
    	"One",
    	"Two",
    	"Three",
    	"Four",
    	"Five",
    	"Six",
    	"Seven",
    	"Eight",
    	"Nine"    	
    };
    String[] uncommon = {
    		"Eleven",
    		"Twelve",
    		"Thirteen",
    		"Fourteen",
    		"Fifteen",
    		"Sixteen",
    		"Seventeen",
    		"Eighteen",
    		"Ninteen"
    		
    };
    String[] base10 = {
    		"Ten",
    		"Twenty",
    		"Thirty",
    		"Forty",
    		"Fifty",
    		"Sixty",
    		"Seventy",
    		"Eighty",
    		"Ninety"
    };
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.numberToWords(10));
	}
	
	public String numberToWords(int num) {
		if(num == 0) return "Zero";
	    return determineWord(num, powInWords.length - 1);  
	}
	
	private String determineWord(int num, int ptr) {
		/**
		 * When this function is called internally, ptr can be max 2
		 * otherwise max 9
		 */
		System.out.println("numToWords("+num+","+ptr+")");
		int divisor, quo;
	    StringBuilder ret = new StringBuilder();
	    while(num != 0) {
	    	System.out.println("ptr "+ptr);
	    	System.out.println("number "+ num);
	    	divisor = (int) Math.pow(10, ptr);
	    	System.out.println("divisor "+divisor);
	    	quo = num / divisor;
	    	if(quo != 0) {
	    		System.out.println("quotient "+quo);
	    		if(powInWords[ptr] != null) {
		    		System.out.println(powInWords[ptr]);
		    		/*
		    		 * divisor is hundred, thousand, million or billion
		    		 */
		    		
		    		if(quo < 10) {
		    			ret.append(basic[quo - 1]);	    			
		    		}
		    		else if(quo > 10 && quo < 20) {
		    			// append uncommon words
		    			ret.append(uncommon[quo % 10 - 1]);	    			
		    		}
		    		else if(quo % 10 == 0 && quo < 100) {
		    			// quo is something like 30, 40, etc.
		    			ret.append(base10[quo/10 - 1]);	    			
		    		}
		    		else {
		    			ret.append(determineWord(quo, 2));	    			
		    		}
		    		ret.append(" ");
	    			ret.append(powInWords[ptr]);
	    			ret.append(" ");
		    	}
		    	else {
		    		// if ptr == 1 or 0
		    		if(quo < 10) {
		    			ret.append(basic[quo - 1]);	    			
		    		}
		    		else if(quo > 10 && quo < 20) {
		    			// append uncommon words
		    			ret.append(uncommon[quo % 10 - 1]);	    			
		    		}
		    		else {
		    			// ex: 45
		    			ret.append(base10[quo/10 - 1]);
		    			ret.append(" ");
		    			ret.append(basic[quo % 10 - 1]);
		    		}
		    	}
	    	}
	    	
	    	
	    	
	    	if(ptr == 6 || ptr == 9) {
	    		ptr -= 3;
	    	}
	    	else if(ptr == 3){
	    		// if ptr == 3
	    		ptr--;
	    	}
	    	else {
	    		// ptr == 2
	    		num %= divisor;
	    		quo = num % 100;
	    		System.out.println("Quo here "+quo);
	    		if(quo < 10) {
	    			ret.append(basic[quo - 1]);	    			
	    		}
	    		else if(quo > 10 && quo < 20) {
	    			// append uncommon words
	    			ret.append(uncommon[quo % 10 - 1]);	    			
	    		}
	    		else if(quo == 0){
                    
                }
	    		else {
	    			// ex: 45
	    			ret.append(base10[quo/10 - 1]);
	    			ret.append(" ");
	    			if(quo % 10 != 0)
	    				ret.append(basic[quo % 10 - 1]);
	    		}
	    		break;
	    	}
	    	num %= divisor;
	    }
	    
	    return ret.toString().trim();
	}
}
