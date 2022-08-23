package myAToI;

public class Solution {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.myAtoi("-345"));
	}
	
	public int myAtoi(String s) {
		s = s.trim();
		if(s.isEmpty()) return 0;
		boolean isNegative = false;
		if(s.charAt(0) == '-') isNegative = true;
        if(s.charAt(0) == '+' || s.charAt(0) == '-' || (s.charAt(0) >= '0' && s.charAt(0) <= '9')){
            int n = s.length();
		long ret = 0;
		for(int i = 0; i < n; i++) {
			char a = s.charAt(i);
			if(a >= '0' && a <= '9'){
                ret *= 10;
                if(!isNegative && ret > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                else if(isNegative && ret > ((long)Integer.MAX_VALUE + 1)) {
                    return Integer.MIN_VALUE;
                }
				ret += (a - '0');
				
			}
            else{
                if(i != 0) break;
            }
		}
		
		if(isNegative) ret *= (-1);
		if(ret > Integer.MAX_VALUE) ret = Integer.MAX_VALUE;
		else if(ret < Integer.MIN_VALUE) ret = Integer.MIN_VALUE;
		return (int) ret;
        }
        
        return 0;
		
	}
}
