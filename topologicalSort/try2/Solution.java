package topologicalSort.try2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum Colour {
	WHITE, GREY, BLACK;
}
public class Solution {

	boolean cycleFlag = false;
	int[] order;
	int ctr;
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adjList.add(new ArrayList<>());
        for(int[] x : prerequisites) {
        	if(x[0] == x[1]) return new int[0];
        	adjList.get(x[1]).add(x[0]);
        }
        
        Colour[] visited = new Colour[numCourses];
        Arrays.fill(visited, Colour.WHITE);
        order = new int[numCourses];
        ctr = numCourses - 1;
        for(int i = 0; i < numCourses; i++) {
        	if(visited[i] == Colour.WHITE) {        		
        		dfs(i, visited, adjList);
        		if(cycleFlag) return new int[0];
        	}
        }
        return order;
	}
	
	private void dfs(int u, Colour[] visited, List<List<Integer>> adjList) {
		System.out.println("DFS("+u+")");
		visited[u] = Colour.GREY;
		for(int v : adjList.get(u)) {
			if(visited[v] == Colour.GREY) {
				/*
				 * cycle
				 */
				cycleFlag = true;
				return;
			}
			else {
				if(visited[v] == Colour.WHITE)
					dfs(v, visited, adjList);
			}
			
		}
		visited[u] = Colour.BLACK;
		order[ctr--] = u;
		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] prereqs = {{1,0},{2,0},{3,1},{3,2}};
		System.out.println(Arrays.toString(s.findOrder(4, prereqs)));
		Colour[] t = new Colour[5];
		System.out.println(t[0]);

	}

}
