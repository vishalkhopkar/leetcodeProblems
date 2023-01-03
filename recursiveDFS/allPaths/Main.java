package recursiveDFS.allPaths;

import java.util.ArrayList;
import java.util.List;

public class Main {
	static boolean[] visited;
	static int[][] adjList = {
			{1, 2, 3},
			{4},
			{1, 3, 4},
			{1, 4},
			{0}
	};
	private static void dfs(int vertex, List<Integer> path, int end) {
		if(vertex == end) {
			System.out.println(path);
		}
		visited[vertex] = true;
		//System.out.println("visited "+vertex);
		for(int v : adjList[vertex]) {
			if(!visited[v]) {
				List<Integer> newPath = new ArrayList<>(path);
				newPath.add(v);
				dfs(v, newPath, end);
			}
		}
		//System.out.println("all children of "+vertex+" visited");
		visited[vertex] = false;
	}
	public static void main(String[] args) {
		
		visited = new boolean[adjList.length];
		List<Integer> path = new ArrayList<>();
		path.add(1);
		dfs(1, path, 3);
	}
}
