package longestCycleInGraph.try2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Solution {

	int maxCycleLen = -1;
	int[] cycleSource;
	public int longestCycle(int[] edges) {
		/*
		 * check on every node if it is a part of any cycle
		 */
		int n = edges.length;
		boolean[] visited = new boolean[n];
		cycleSource = new int[n];
		Arrays.fill(cycleSource, -1);
		for(int i = 0; i < n; i++) {
			Arrays.fill(visited, false);
			if(cycleSource[i] == -1)
				dfs(i, i, new HashSet<>(), 0, visited, edges);
		}
		return maxCycleLen;
	}
	
	private void dfs(int source, int v, Set<Integer> ancestors, int currLen, boolean[] visited, int[] edges) {
		visited[v] = true;
		if(edges[v] != -1) {
			if(edges[v] == source) {
				/*
				 * cycle detected
				 */
				cycleSource[source] = source;
				cycleSource[edges[v]] = source;
				cycleSource[v] = source;
				
				for(Integer r : ancestors) cycleSource[r] = source;
				maxCycleLen = Math.max(maxCycleLen, currLen + 1);
			}
			else if(!visited[edges[v]]){
				Set<Integer> newAnc = new HashSet<>(ancestors);
				newAnc.add(v);
				dfs(source, edges[v], newAnc, currLen + 1, visited, edges);
			}
		}
		
		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] edges = {3,3,4,2,3};
		System.out.println(s.longestCycle(edges));

	}

}
