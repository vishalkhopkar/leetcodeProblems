package subsetSum;

public class Main {

	boolean[][] dpTable;
	public boolean subsetSum(int[] vals, int remCap, int n) {
		//System.out.println("subsetsum("+remCap+", "+n+")");
		if(n == 0) return false;
		if(vals[n - 1] == remCap) return true;
		if(vals[n - 1] > remCap) {
			
			dpTable[n - 1][remCap] = subsetSum(vals, remCap, n - 1);
			return dpTable[n - 1][remCap];
		}	
				
		dpTable[n - 1][remCap - vals[n - 1]] = subsetSum(vals, remCap - vals[n - 1], n - 1);
		dpTable[n - 1][remCap] = subsetSum(vals, remCap, n - 1);
		return dpTable[n - 1][remCap - vals[n - 1]] || dpTable[n - 1][remCap];
	}
	public boolean subsetSumOuter(int[] vals, int k) {
		dpTable = new boolean[vals.length + 1][k + 1];
		
		return subsetSum(vals, k, vals.length);
	}
	public static void main(String[] args) {
		Main m = new Main();
		int[] vals = {3, 34, 4, 12, 5, 2};
		System.out.println(m.subsetSumOuter(vals, 30));

	}

}
