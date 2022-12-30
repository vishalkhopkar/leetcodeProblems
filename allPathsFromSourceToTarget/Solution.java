package allPathsFromSourceToTarget;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StackNode {
	int vertex;
	List<Integer> path;
	public StackNode(int vertex, List<Integer> path) {
		super();
		this.vertex = vertex;
		this.path = path;
	}
	
}

public class Solution {

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        /*
         * We have been given the adjacency list
         */
		int n = graph.length;
		Stack<StackNode> stack = new Stack<>();
		List<Integer> currPath = new ArrayList<>();
		currPath.add(0);
		stack.push(new StackNode(0, currPath));
		List<List<Integer>> ret = new ArrayList<>();
		StackNode x;
		List<Integer> l;
		while(!stack.isEmpty()) {
			x = stack.pop();
			if(x.vertex == n - 1) {
				ret.add(x.path);
			}
			for(int v : graph[x.vertex]) {
				l = new ArrayList<>();
				l.addAll(x.path);
				l.add(v);
				stack.push(new StackNode(v, l));
			}
		}
		return ret;
    }
	
	public static void main(String[] args) {
		int[][] adjList = {
				{1, 2, 3},
				{4, 5, 6, 8},
				{6, 7},
				{6, 8},
				{},
				{8},
				{},
				{8},
				{}
		};
		Solution s = new Solution();
		System.out.println(s.allPathsSourceTarget(adjList));

	}

}
