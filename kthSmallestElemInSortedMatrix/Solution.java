package kthSmallestElemInSortedMatrix;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Location {
	int r, c, elem;

	public Location(int r, int c, int elem) {
		super();
		this.r = r;
		this.c = c;
		this.elem = elem;
	}
	
	
	
}
public class Solution {

	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
        if(k == n*n) return matrix[n - 1][n - 1];
        if(k == 1) return matrix[0][0];
        
        Queue<Location> pq = new PriorityQueue<>(new Comparator<Location>() {

			@Override
			public int compare(Location o1, Location o2) {
				return o1.elem - o2.elem;
			}
        	
        });
        int noOfElemsEncountered = 0;       
        
        int currX = 0, currY = 0;
        pq.offer(new Location(0, 0, matrix[0][0]));
        Location l;
        while(noOfElemsEncountered < k) {
        	
        	/*
        	 * add the candidates to pq
        	 */
        	l = pq.poll();
        	currX = l.r;
        	currY = l.c;
        	System.out.println("popped "+l.elem);
        	if(currX + 1 < n) {
        		pq.offer(new Location(currX + 1, currY, matrix[currX + 1][currY]));
        		System.out.println("offered "+matrix[currX + 1][currY]);
        	}
        	if(currX == 0 && currY + 1 < n) {
        		pq.offer(new Location(currX, currY + 1, matrix[currX][currY + 1]));
        		System.out.println("offered "+matrix[currX][currY + 1]);
        	}
        	noOfElemsEncountered++;
        }
        return matrix[currX][currY];
        
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] mat = {{1,5,9},{10,11,13},{12,13,15}};
		System.out.println(s.kthSmallest(mat, 8));

	}

}
