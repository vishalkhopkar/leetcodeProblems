package gs_problem1;

public class Main {

	public boolean isPrefix(String s1, String s2, boolean prevPrefix) {
		//System.out.println("isprefix("+s1+", "+s2+", prevprefix = "+prevPrefix);
		/*
		 * s2.length <= s1.length
		 */
		if(prevPrefix) {
			return s1.charAt(s2.length() - 1) == s2.charAt(s2.length() - 1);
		}
		else {
			return s1.charAt(0) == s2.charAt(0);
		}
	}
	
	public boolean isPrefix(String s, int x, int y, boolean prevPrefix) {
		if(prevPrefix) {
			return s.charAt(y - x ) == s.charAt(y);
		}
		else {
			return s.charAt(0) == s.charAt(x);
		}
	}
	
	public int compress(String s) {
		
		int sLen = s.length();
		if(sLen == 1) return 1;
		StringBuilder res = new StringBuilder();
		res.append(s.charAt(0));
		boolean prevPrefix = false;
		int currStart = 1, currEnd = 1;
		while(currEnd < sLen) {
			if(currEnd - currStart + 1 == currStart) {
				if(s.substring(0, currStart).equals(s.substring(currStart, currEnd + 1))) {
					res.append('*');
				}
				else {
					res.append(s.substring(currStart, currEnd + 1));
				}
				
				currStart = ++currEnd;
				prevPrefix = false;
			}
			// else if(isPrefix(s.substring(0, currStart), s.substring(currStart, currEnd + 1), prevPrefix)){
			else if(isPrefix(s, currStart, currEnd, prevPrefix)) {
				currEnd++;
				prevPrefix = true;
			}
			else {
				res.append(s.substring(currStart, currEnd + 1));
				currStart++;
				currEnd++;
				prevPrefix = false;
			}
		}
		if(currStart != currEnd) {
			res.append(s.substring(currStart, currEnd));
		}
		System.out.println(res);
		return res.length();
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		System.out.println(m.compress("AAA"));
	}

}
