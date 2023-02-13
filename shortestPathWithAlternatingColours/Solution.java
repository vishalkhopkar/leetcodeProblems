package shortestPathWithAlternatingColours;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

enum Colour {
	RED, BLUE;
}
class AdjListEntry {
	int vertex;
	Colour colour;
	public AdjListEntry(int vertex, Colour colour) {
		super();
		this.vertex = vertex;
		this.colour = colour;
	}
	@Override
	public String toString() {
		return "(" + vertex + ", " + colour.toString().charAt(0) + ")";
	}
	
}
public class Solution {

	public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        /*
         * build an adjacency list first
         */
		List<List<AdjListEntry>> adjList = new ArrayList<>();
		boolean[][] visited = new boolean[n][2];
		for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());
		AdjListEntry v;
		for(int[] x : redEdges) {
			v = new AdjListEntry(x[1], Colour.RED);
			adjList.get(x[0]).add(v);
			
		}
		for(int[] x : blueEdges) {
			adjList.get(x[0]).add(new AdjListEntry(x[1], Colour.BLUE));
		}
		
		for(List<AdjListEntry> x : adjList) {
			System.out.println(x);
		}
		
		int[][] ret = new int[n][2];
		for(int i = 0; i < n; i++)
			Arrays.fill(ret[i],  -1);
		ret[0][Colour.RED.ordinal()] = 0;
		ret[0][Colour.BLUE.ordinal()] = 0;
 		/*
		 * ret[i] will contain the shortest alternating colour path
		 * from vertex 0 to i
		 */
		Queue<AdjListEntry> queue = new LinkedList<>();
		for(AdjListEntry e : adjList.get(0)) {
			queue.offer(e);
			visited[e.vertex][e.colour.ordinal()] = true;
			ret[e.vertex][e.colour.ordinal()] = 1;
		}
		for(int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(ret[i]));
		}
		System.out.println("*************");
		AdjListEntry popped;
		while(!queue.isEmpty()) {
			popped = queue.poll();
			for(AdjListEntry e : adjList.get(popped.vertex)) {
				if(!visited[e.vertex][e.colour.ordinal()] && e.colour != popped.colour) {
					queue.offer(e);
					visited[e.vertex][e.colour.ordinal()] = true;
					if(ret[e.vertex][e.colour.ordinal()] == -1)
						ret[e.vertex][e.colour.ordinal()] = ret[popped.vertex][popped.colour.ordinal()] + 1; 
				}
			}
		}
		int[] newRet = new int[n];
		for(int i = 0; i < n; i++) {
			if(ret[i][0] == -1) {
				newRet[i] = ret[i][1];
			}
			else if(ret[i][1] == -1) {
				newRet[i] = ret[i][0];
			}
			else {
				newRet[i] = Math.min(ret[i][0], ret[i][1]);
			}
		}
			
		return newRet;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] redEdges = {{0,1},{1,2},{2,3},{3,4}};
		int[][] blueEdges = {{1,2},{2,3},{3,1}};
		System.out.println(Colour.BLUE.ordinal());
		System.out.println(Arrays.toString(s.shortestAlternatingPaths(5, redEdges, blueEdges)));

	}

}
