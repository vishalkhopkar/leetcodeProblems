package cycleDetection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adjList.add(new ArrayList<>());
        int[] outDegree = new int[numCourses];
        int[] inDegree = new int[numCourses];
        for(int[] x : prerequisites) {
        	if(x[0] == x[1]) return false;
        	adjList.get(x[0]).add(x[1]);
        	outDegree[x[0]]++;
        	inDegree[x[1]]++;
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
        if(!vertexWithOutDegreeZeroExists || !vertexWithInDegreeZeroExists) return false;
        System.out.println("all out degree "+allOutDegreeVertices);
        boolean cycleExists = false;
        boolean[] visited = new boolean[numCourses];
        for(int v : allOutDegreeVertices) {
        	cycleExists = dfs(v, new HashSet<>(), visited, adjList);
        	if(cycleExists) return false;
        }
        /*
         * count the unvisited
         */
        boolean allVisited = true;
        for(int i = 0; i < numCourses; i++) {
        	allVisited &= (visited[i]);
        	if(!allVisited) return false;
        }
        return true;
        
    }
	
	private boolean dfs(int v, Set<Integer> ancestors, boolean[] visited, List<List<Integer>> adjList) {
		boolean ret = false;
		visited[v] = true;
		for(int neighbour : adjList.get(v)) {
			if(ancestors.contains(neighbour)) {
				return true;
			}
			if(!visited[neighbour]) {
				Set<Integer> newAncestors = new HashSet<>(ancestors);
				newAncestors.add(v);
				ret |= dfs(neighbour, newAncestors, visited, adjList);
				if(ret) return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] prereqs = {
				{0, 1}, {1, 3}, {3, 5}, {5, 4}, {2, 4}, {0, 2}, {3, 2}
		};
		System.out.println(s.canFinish(6, prereqs));

	}

}
