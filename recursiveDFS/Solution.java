package recursiveDFS;

public class Solution {

	static boolean[] visited;
	static int[][] adjList = {
			{1, 3, 4},
			{2, 3, 4},
			{3, 0},
			{1},
			{3}
	};
	private static void dfs(int vertex) {
		visited[vertex] = true;
		System.out.println("visited "+vertex);
		for(int v : adjList[vertex]) {
			if(!visited[v]) {
				dfs(v);
			}
		}
		System.out.println("all children of "+vertex+" visited");
		visited[vertex] = false;
	}
	public static void main(String[] args) {
		
		visited = new boolean[adjList.length];
		dfs(0);
	}

}
