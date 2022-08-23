package intToRoman;

class Solution {

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.intToRoman(1));

	}
	
	public String intToRoman(int num) {
		char[] romans = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
		int divisor = 1000, quo = 0, ptr = 6;
		StringBuilder ret = new StringBuilder();
		while(num != 0) {
			divisor = (int) Math.pow(10, ptr/2);
			quo = num / divisor;
			if( quo < 4) {
				/**
				 * If divisor == 1000, quo = 3, ex: 3999, append 'MMM'
				 */
				for(int i = 0; i < quo; i++)
					ret.append(romans[ptr]);			
			}
			else if (quo >= 5 && quo < 9){
				/**
				 * If divisor == 100, quo = 8, ex: 800,
				 * subtract 500, append 'D', try again with 300
				 */
				
				ret.append(romans[ptr + 1]);
				quo -= 5;
				for(int i = 0; i < quo; i++)
					ret.append(romans[ptr]);
			}
			else if(quo == 4){
				/**
				 * If divisor == 100, ex: 485
				 * append 'CD'
				 */
				ret.append(romans[ptr]);
				ret.append(romans[ptr + 1]);
			}
			else {
				// quo == 9
				/**
				 * If divisor == 100, ex: 978
				 * append 'CM'
				 */
				ret.append(romans[ptr]);
				ret.append(romans[ptr + 2]);
			}
			num %= divisor;
			ptr -= 2;
		}
        return ret.toString();
    }

}
