package validNumber;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isNumber("-."));

	}
	
	public boolean isNumber(String s) {
		char lastChar = s.charAt(s.length() - 1);
		if(lastChar == 'e' || lastChar == 'E') return false;
		String[] parts = s.split("e");
		if(s.charAt(s.length() - 1) == 'e')
		if(parts.length > 2) return false;
		if(parts.length == 1) parts = s.split("E");
		if(parts.length > 2) return false;
		if(parts.length == 1) {
			// no e or E present
			return isNumber(s, false);
		}
		// e or E present once
		if(parts[0].isBlank() || parts[1].isBlank()) return false;
		return isNumber(parts[0], false) && isNumber(parts[1], true);
	}
	
	private boolean isNumber(String s, boolean type) {
		/**
		 * if type == false, float + ints
		 * else only ints 
		 */
		char starting = s.charAt(0);
		char a;
		int start = 0;
		boolean pointDone = false;
		boolean atLeastOneNoEnc = false;
		if(type && starting == '.') return false;
		if(starting != '+' && starting != '-' && starting != '.' && (starting < '0' || starting > '9')) return false;
		if(starting == '+' || starting == '-') start++;
		int n = s.length();
		if(n == 1 && (starting == '.' || starting == '-' || starting == '+')) return false;
		for(int i = start; i < n; i ++) {
			a = s.charAt(i);
			if(type) {
				// only integers
				if(a < '0' || a > '9') return false;
				else atLeastOneNoEnc = true;
			}
			else {
				// floats and integers
				if(a == '.') {
					if(!pointDone) pointDone = true;
					else return false;
				}
				else if(a < '0' || a > '9') return false;
				else atLeastOneNoEnc = true;
			}
		}
		if(atLeastOneNoEnc) return true;
		return false;
	}

}
