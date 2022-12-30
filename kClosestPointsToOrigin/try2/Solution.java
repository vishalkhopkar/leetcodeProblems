package kClosestPointsToOrigin.try2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	public int[][] kClosest(int[][] points, int k) {
		Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				double d1 = Math.sqrt(o1[0]*o1[0] + o1[1]*o1[1]);
				double d2 = Math.sqrt(o2[0]*o2[0] + o2[1]*o2[1]);
				if(d1 == d2) return 0;
				return (d1 > d2) ? 1 : -1;
			}
			
		});
		for(int[] x : points) {
			pq.offer(x);
		}
		
		int[][] ret = new int[k][2];
		for(int i = 0; i < k; i++) {
			ret[i] = pq.poll();
		}
		return ret;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
