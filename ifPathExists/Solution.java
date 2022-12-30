package ifPathExists;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	
	public boolean validPath(int n, int[][] edges, int source, int destination) {
		source--;
		destination--;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
        	adjList.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++) {
        	adjList.get(edges[i][0] - 1).add(edges[i][1] - 1);
        	adjList.get(edges[i][1] - 1).add(edges[i][0] - 1);
        }
        
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[n];
        
        st.push(source);
        int popped;
        while(!st.isEmpty()) {
        	popped = st.pop();
        	visited[popped] = true;
        	
        	for(Integer x : adjList.get(popped)) {
        		if(!visited[x]) {
        			if(x == destination) return true;
        			st.push(x);
        		}
        			
        	}
        }
        return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
