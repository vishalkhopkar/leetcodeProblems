package uniquePathsIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

class Location {
	int x, y;

	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
	
	
	
	
	
}
class StackNode {
	Location loc;
	List<Location> path;
	public StackNode(Location loc, List<Location> path) {
		super();
		this.loc = loc;
		this.path = path;
	}
	@Override
	public String toString() {
		return "[loc=" + loc + ", path=" + path + "]";
	}
	
	
	
}
public class Solution {

	public int uniquePathsIII(int[][] grid) {
		/*
		 * 1 representing the starting square. There is exactly one starting square. 
		 * 2 representing the ending square. There is exactly one ending square. 
		 * 0 representing empty squares we can walk over. -1 representing obstacles that
		 * we cannot walk over.
		 */
		
		/*
		 * find the start
		 */
		Stack<StackNode> st = new Stack<>();
		List<Location> initList = new ArrayList<>();
		Location start = null;
		boolean hasBroken = false;
		int noOfValidLocations = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == 1) {
					start = new Location(i, j);
					initList.add(start);
					st.push(new StackNode(start, initList));
					
				}
				if(grid[i][j] != -1) noOfValidLocations++;
				
			}
		}
		System.out.println("no of valid locations "+noOfValidLocations);
		StackNode popped;
		Location pLoc, newLoc;
		List<Location> newList;
		int ret = 0;
		boolean visitationToBeInitialized = false;
		while(!st.isEmpty()) {
			popped = st.pop();
			System.out.println(popped);
			pLoc = popped.loc;
			visited[pLoc.x][pLoc.y] = true;
			//printVisited(visited);
			if(visitationToBeInitialized) {
				Set<Location> notToBeInitialized = new HashSet<>(popped.path);
				for(int i = 0; i < grid.length; i++) {
					for(int j = 0; j < grid[i].length; j++) {
						if(!notToBeInitialized.contains(new Location(i, j))) {
							visited[i][j] = false;
						}
					}
				}
				visitationToBeInitialized = false;
			}
			
			/*
			 * for all neighbours of popped,
			 * if it is unvisited, push onto the stack
			 */
			if(grid[pLoc.x][pLoc.y] == 2) {
				if(popped.path.size() == noOfValidLocations ) {
					System.out.println(popped.path);
					ret++;
					visitationToBeInitialized = true;
				}
				else {
					visited[pLoc.x][pLoc.y] = false;
				}
				continue;
			}
			
			/*
			 * The neighbours are:
			 * popped.loc.x - 1, popped.loc.y
			 * popped.loc.x 
			 */
			if(pLoc.x - 1 >= 0) {
				if(grid[pLoc.x - 1][pLoc.y] != -1 && !visited[pLoc.x - 1][pLoc.y]) {
					newLoc = new Location(pLoc.x - 1, pLoc.y);
					newList = new ArrayList<>();
					newList.addAll(popped.path);
					newList.add(newLoc);
					st.push(new StackNode(newLoc, newList));
				}
			}
			
			if(pLoc.y - 1 >= 0) {
				if(grid[pLoc.x][pLoc.y - 1] != -1 && !visited[pLoc.x][pLoc.y - 1]) {
					newLoc = new Location(pLoc.x, pLoc.y - 1);
					newList = new ArrayList<>();
					newList.addAll(popped.path);
					newList.add(newLoc);
					st.push(new StackNode(newLoc, newList));
				}
			}
			
			if(pLoc.x + 1 < grid.length) {
				if(grid[pLoc.x + 1][pLoc.y] != -1 && !visited[pLoc.x + 1][pLoc.y]) {
					newLoc = new Location(pLoc.x + 1, pLoc.y);
					newList = new ArrayList<>();
					newList.addAll(popped.path);
					newList.add(newLoc);
					st.push(new StackNode(newLoc, newList));
				}
			}
			
			if(pLoc.y + 1 < grid[0].length) {
				if(grid[pLoc.x][pLoc.y + 1] != -1 && !visited[pLoc.x][pLoc.y + 1]) {
					newLoc = new Location(pLoc.x, pLoc.y + 1);
					newList = new ArrayList<>();
					newList.addAll(popped.path);
					newList.add(newLoc);
					st.push(new StackNode(newLoc, newList));
				}
			}
			visited[pLoc.x][pLoc.y]= false; 
		}
		
		return ret;
	}
	
	private void printVisited(boolean[][] visited) {
		for(int i = 0; i < visited.length; i++) {
			System.out.println(Arrays.toString(visited[i]));
		}
		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
		System.out.println(s.uniquePathsIII(grid));

	}

}
