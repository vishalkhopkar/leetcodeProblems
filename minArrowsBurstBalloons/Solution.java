package minArrowsBurstBalloons;

import java.util.Arrays;

public class Solution {

	public int findMinArrowShots(int[][] points) {
		/*
		 * Sort the points as per their end point
		 */
		Arrays.sort(points, (o1, o2) -> (o2[1] > o1[1]) ? -1 : 1);
		
		for(int[] x : points)
			System.out.println(Arrays.toString(x));
		
		int numArrows = 1;
		int currEnd = points[0][1];
		for(int i = 1; i < points.length; i++) {
			/*
			 * check whether current arrows kill
			 * points[i]
			 */
			if(points[i][0] <= currEnd) {
				/*
				 * this arrow kills points[i]
				 * do not increment numArrows
				 */
			}
			else {
				/*
				 * this arrow does not kill points[i]
				 * increment numArrows
				 */
				numArrows++;
				currEnd = points[i][1];
			}
		}
		return numArrows;
        
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
		System.out.println(2147483647 > (-2147483645));
		System.out.println(s.findMinArrowShots(points));

	}

}
