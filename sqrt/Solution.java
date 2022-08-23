package sqrt;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.mySqrt(2147395599));
	}
	
	public int mySqrt(int x) {
		if(x == 1) return 1;
		long s = 0, e = x, mid = 1, prod;
		boolean perfectSq = false;
		while((e - s) > 1) {
			System.out.printf("s %d e %d mid %d\n", s, e, mid);
			mid = (s + e)/2;
			prod = mid*mid;
			if(prod == x) {
				perfectSq = true;
				break;
			}
			if(prod < x) s = mid;
			else e = mid;
		}
		if(perfectSq) return (int) mid;
		return (int)s;
	}

}
