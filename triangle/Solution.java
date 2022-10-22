package triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] dpTable = new int[n][n];
		dpTable[0][0] = triangle.get(0).get(0);
		for(int i = 1; i < n; i++) {
			dpTable[i][0] = dpTable[i - 1][0] + triangle.get(i).get(0);
			dpTable[0][i] = dpTable[0][i - 1] + triangle.get(i).get(i);
		}
		int x;
		int min = Math.min(dpTable[n - 1][0], dpTable[0][n - 1]);
		for(int i = 2; i < n; i++) {
			x = i - 1;
			while(x > 0) {
				//System.out.println("i = "+i+", filling ["+x+"]["+(i + 1 - x)+"]");
				
				dpTable[x][i - x] = Math.min(dpTable[x - 1][i - x], 
						dpTable[x][i - x - 1]) + triangle.get(i).get(i - x);
				if(i == n - 1) {
					min = Math.min(min, dpTable[x][i - x]);
				}
				x--;
			}
		}
		/*
		for(int i = 0; i < n; i++) {
			
			System.out.println(Arrays.toString(dpTable[i]));
			
		}
		*/
		return min;
        
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		List<List<Integer>> triangle = new ArrayList<>();
		
		List<Integer> a = new ArrayList<>();
		a.add(2);
		triangle.add(a);
		
		a = new ArrayList<>();
		a.add(3);
		a.add(4);
		triangle.add(a);
		
		a = new ArrayList<>();
		a.add(6);
		a.add(5);
		a.add(7);
		triangle.add(a);
		
		a = new ArrayList<>();
		a.add(4);
		a.add(1);
		a.add(8);
		a.add(3);
		triangle.add(a);
		
		System.out.println(s.minimumTotal(triangle));
	}

}
