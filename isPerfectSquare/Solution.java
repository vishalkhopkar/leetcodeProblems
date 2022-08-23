package isPerfectSquare;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.isPerfectSquare(65));
	}
	
	public boolean isPerfectSquare(int x) {
		if(x == 0 || x == 1) return true;
		long s = 0, e = x, mid = 1, prod;
		while((e - s) > 1) {
			System.out.printf("s %d e %d mid %d\n", s, e, mid);
			mid = (s + e)/2;
			prod = mid*mid;
			if(prod == x) {
				return true;
			}
			if(prod < x) s = mid;
			else e = mid;
		}
		
		return false;
    }

}
