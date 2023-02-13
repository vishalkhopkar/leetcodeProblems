package minPetrol.try2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	int[] lengthOfSubtree;
	int[] carsRequired;
	long petrol = 0;
	public long minimumFuelCost(int[][] roads, int seats) {
		if(roads.length == 0) return 0;
		List<List<Integer>> adjList = new ArrayList<>();
		int n = roads.length + 1;
		
		for(int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int[] x : roads) {
			adjList.get(x[0]).add(x[1]);
			adjList.get(x[1]).add(x[0]);
			
		}
		boolean[] visited = new boolean[n];
		lengthOfSubtree = new int[n];
		carsRequired = new int[n];
		dfs(0, visited, adjList, seats);
		System.out.println(Arrays.toString(lengthOfSubtree));
		System.out.println(Arrays.toString(carsRequired));
		return petrol;
	}
	
	/*
	 * returns the length of the subtree
	 */
	private int dfs(int u, boolean[] visited, List<List<Integer>> adjList, int seats) {
		visited[u] = true;
		lengthOfSubtree[u] = 1;
		for(int v : adjList.get(u)) {
			if(!visited[v]) {
				lengthOfSubtree[u] += dfs(v, visited, adjList, seats);
			}
		}
		carsRequired[u] = (int) Math.ceil((double)lengthOfSubtree[u]/seats);
		if(u != 0)
			petrol += carsRequired[u];
		return lengthOfSubtree[u];
	}

	public static void main(String[] args) {
		int[][] roads = {{0,1},{1,2},{1,3},{4,2},{5,3},{6,3},{6,7},{8,6},{9,0},{5,10},{11,9},{12,5},{5,13},{8,14},{11,15},{8,16},{17,0},{18,7}};
		Solution s = new Solution();
		System.out.println(s.minimumFuelCost(roads, 13));

	}

}
