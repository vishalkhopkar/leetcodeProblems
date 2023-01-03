package uniquePathsIII.try3;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	List<List<Integer>> adjList;
	boolean[] visited;
	int ret = 0;
	private void dfs(int vertex, int pathLen, int end, int noOfValidLocations) {
		if(vertex == end && pathLen == noOfValidLocations) {
			//System.out.println(path);
			ret++;
		}
		visited[vertex] = true;
		//System.out.println("visited "+vertex);
		for(int v : adjList.get(vertex)) {
			if(!visited[v]) {
				//List<Integer> newPath = new ArrayList<>(path);
				dfs(v, pathLen + 1, end, noOfValidLocations);
			}
		}
		//System.out.println("all children of "+vertex+" visited");
		visited[vertex] = false;
	}
	
	public int uniquePathsIII(int[][] grid) {
        /*
         * make an adjacency list from the grid
         */
		int noOfValidLocations = 0;
		int m = grid.length;
		int n = grid[0].length;
		int start = -1, end = -1;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(grid[i][j] == 1) {
					start = n*i + j;
				}
				else if(grid[i][j] == 2) {
					end = n*i + j;
				}
				if(grid[i][j] != -1) {
					noOfValidLocations++;
				}
			}
		}
		adjList = new ArrayList<>(noOfValidLocations);
		visited = new boolean[m*n];
		for(int i = 0; i < m*n; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				//System.out.println("i = "+i+" j = "+j);
				if(grid[i][j] != -1) {
					if(i - 1 >= 0 && grid[i - 1][j] != -1) {
						adjList.get(n*i + j).add(n* (i - 1) + j);
					}
					
					if(j - 1 >= 0 && grid[i][j - 1] != -1) {
						adjList.get(n*i + j).add(n* i + j - 1);
					}
					
					if(i + 1 < m && grid[i + 1][j] != -1) {
						adjList.get(n*i + j).add(n* (i + 1) + j);
					}
					
					if(j + 1 < n && grid[i][j + 1] != -1) {
						adjList.get(n*i + j).add(n* i + j + 1);
					}
				}
				
				
			}
		}
		
		
		dfs(start, 1, end, noOfValidLocations);
		return ret;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
		System.out.println(s.uniquePathsIII(grid));

	}

}
