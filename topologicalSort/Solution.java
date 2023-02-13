package topologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	int[] time;
	
	int currTime = 0;
	boolean cycleFlag = false;
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adjList.add(new ArrayList<>());
        int[] outDegree = new int[numCourses];
        int[] inDegree = new int[numCourses];
        for(int[] x : prerequisites) {
        	if(x[0] == x[1]) return new int[0];
        	adjList.get(x[1]).add(x[0]);
        	outDegree[x[1]]++;
        	inDegree[x[0]]++;
        }
        boolean vertexWithOutDegreeZeroExists = false;
        boolean vertexWithInDegreeZeroExists = false;
        Set<Integer> allOutDegreeVertices = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
        	vertexWithOutDegreeZeroExists |= (outDegree[i] == 0);
        	vertexWithInDegreeZeroExists |= (inDegree[i] == 0);
        	if(inDegree[i] == 0) {
        		allOutDegreeVertices.add(i);
        	}
        }
        if(!vertexWithOutDegreeZeroExists || !vertexWithInDegreeZeroExists) return new int[0];
        System.out.println("all out degree "+allOutDegreeVertices);
        time = new int[numCourses];
        for(Integer v : allOutDegreeVertices) {
        	time[v] = 1;
        	dfs(v, new HashSet<>(), adjList);
        	if(cycleFlag) return new int[0];
        }
        /*
         * count the number of unvisited
         */
        boolean allVisited = true;
        for(int i = 0; i < numCourses; i++) {
        	allVisited &= (time[i] != 0);
        	if(!allVisited) return new int[0];
        }
        
        System.out.println(Arrays.toString(time));
        
        Integer[] vertices = new Integer[numCourses];
        for(int i = 0; i < numCourses; i++) vertices[i] = i;
        Arrays.sort(vertices, new Comparator<>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return time[o1] - time[o2];
			}
        	
		});
        System.out.println(Arrays.toString(vertices));
        int[] ret = new int[numCourses];
        for(int i = 0; i < numCourses; i++) ret[i] = vertices[i];
        return ret;
    }

	private void dfs(int v, Set<Integer> ancestors, List<List<Integer>> adjList) {
		System.out.println("DFS("+v+", "+ancestors+", time["+v+"] = "+time[v]+")");
		for(int neighbour : adjList.get(v)) {
			if(ancestors.contains(neighbour)) {
				cycleFlag = true;
				return;
			}
			Set<Integer> newAnc = new HashSet<>(ancestors);
			newAnc.add(v);
			time[neighbour] = Math.max(time[neighbour], time[v] + 1);
			dfs(neighbour, newAnc, adjList);
		}
		
		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		/*
		int[][] prereqs = {
				{0, 1}, {0, 2},
				{1, 3},
				{2, 4},
				{3, 2}, {3, 5},
				{5, 4}
		};*/
		int[][] prereqs = {{1,0},{2,6},{1,7},{5,1},{6,4},{7,0},{0,5}};
		System.out.println(s.findOrder(8, prereqs));

	}

}
