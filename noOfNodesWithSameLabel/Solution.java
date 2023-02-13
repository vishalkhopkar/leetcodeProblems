package noOfNodesWithSameLabel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	int[] res;
	boolean[] visited;
	List<List<Integer>> adjList;
	public int[] countSubTrees(int n, int[][] edges, String labels) {
        /*
         * first, let us make the adjacency list
         */
		adjList = new ArrayList<>();
		for(int i = 0; i < n; i++) adjList.add(new ArrayList<>());
		
		for(int i = 0; i < edges.length; i++) {
			adjList.get(edges[i][0]).add(edges[i][1]);
			adjList.get(edges[i][1]).add(edges[i][0]);
		}
		
		Map<Character, List<Integer>> charMapping = new HashMap<>();
		res = new int[n];
		visited = new boolean[n];
		recursiveCall(charMapping, 0, labels);
		return res;
    }
	
	private void recursiveCall(Map<Character, List<Integer>> charMapping, int nodeNo, String labels) {
		System.out.println(nodeNo+" : "+charMapping);
		/*
		 * for this node, first set to 1
		 */
		res[nodeNo]++;
		visited[nodeNo] = true;
		Map<Character, List<Integer>> charMappingNew = new HashMap<>();
		for(char k : charMapping.keySet()) {
			charMappingNew.put(k, new ArrayList<>(charMapping.get(k)));
		}
		List<Integer> l = charMappingNew.get(labels.charAt(nodeNo));
		if(l == null) {
			/*
			 * character appearing for the first time
			 */
			l = new ArrayList<>();
		}
		else {
			for(int x : l) {
				res[x]++;
			}
		}
		l.add(nodeNo);
		charMappingNew.put(labels.charAt(nodeNo), l);
		for(int y : adjList.get(nodeNo)) {
			//System.out.println("at node "+nodeNo+ " calling for nodeno "+y+" with "+charMappingNew);
			if(!visited[y])
				recursiveCall(charMappingNew, y, labels);
		}
		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		
		/*
		int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
		System.out.println(Arrays.toString(s.countSubTrees(7, edges, "abaedcd")));
		*/
		
		/*
		int[][] edges = {{0,1},{1,2},{0,3}};
		System.out.println(Arrays.toString(s.countSubTrees(4, edges, "bbbb")));
		
		*/
		
		int[][] edges = {{0,2},{0,3},{1,2}};
		System.out.println(Arrays.toString(s.countSubTrees(4, edges, "aeed")));

	}

}
