package reachableNodesWithRestrictions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	int nodesReachable = 0;
	public int reachableNodes(int n, int[][] edges, int[] restricted) {
		List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        boolean[] restrictedArr = new boolean[n];
        for(int y : restricted)
        	restrictedArr[y] = true;
        for(int[] x : edges) {
        	if(restrictedArr[x[1]] || restrictedArr[x[0]]) continue;
        	adjList.get(x[0]).add(x[1]);
        	adjList.get(x[1]).add(x[0]);
        }
        boolean[] visited = new boolean[n];
        
        dfs(0, adjList, visited);
        return nodesReachable;
    }
	
	private void dfs(int u, List<List<Integer>> adjList, boolean[] visited) {
		visited[u] = true;
		nodesReachable++;
		for(int v : adjList.get(u)) {
			if(!visited[u]) {
				dfs(v, adjList, visited);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
