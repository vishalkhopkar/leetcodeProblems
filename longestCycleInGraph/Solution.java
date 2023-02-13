package longestCycleInGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	int maxCycleLength = -1;
	int noOfVerticesRem;
	Set<Integer> verticesRem;
	public int longestCycle(int[] edges) {
        /*
         * edges is the adj list
         */
		int n = edges.length;
		boolean[] visited = new boolean[n];
		noOfVerticesRem = n;
		verticesRem = new HashSet<>(n);
		for(int u = 0; u < n; u++)
			verticesRem.add(u);
		int vertex;
		while(noOfVerticesRem > 0) {
			vertex = verticesRem.iterator().next();
			dfs(vertex, new ArrayList<>(), visited, edges);
		}
		return maxCycleLength;
    }

	private void dfs(int i, List<Integer> ancestors, boolean[] visited, int[] edges) {
		noOfVerticesRem--;
		verticesRem.remove(i);
		visited[i] = true;
		if(edges[i] != -1) {
			int ind = ancestors.indexOf(edges[i]);
			
			if(ind != -1) {
				int lengthOfCycle = ancestors.size() - ind + 1;
				maxCycleLength = Math.max(lengthOfCycle, maxCycleLength);
			}
			if(!visited[edges[i]]) {
				List<Integer> newAncestors = new ArrayList<>(ancestors);
				newAncestors.add(i);
				dfs(edges[i], newAncestors, visited, edges);
			}
		}
		
		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] edges = {2,-1,3,1};
		System.out.println(s.longestCycle(edges));

	}

}
