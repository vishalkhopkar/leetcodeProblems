package noOfNodesWithSameLabel.try3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Solution {

	int[] res;
	boolean[] visited;
	String labelsGlobal;
	List<List<Integer>> adjList;
	Map<Character, List<Integer>> charMapping;
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
		
		res = new int[n];
		visited = new boolean[n];
		Arrays.fill(res, 1);
		charMapping = new HashMap<>();
		labelsGlobal = labels;
		getCounts(0);
		return res;
    }
	
	private char[] getCounts(int nodeNo) {
		visited[nodeNo] = true;
		char[] ret = new char[26];
		char[] x;
		for(int y : adjList.get(nodeNo)) {
			if(!visited[y]) {
				x = getCounts(y);
				addCountsToRet(x, ret);
			}
		}
		res[nodeNo] = ++ret[labelsGlobal.charAt(nodeNo) - 'a'];
		return ret;
	}

	private void addCountsToRet(char[] x, char[] ret) {
		for(int i = 0; i < 26; i++) {
			if(x[i] > 0) ret[i] += x[i];
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
