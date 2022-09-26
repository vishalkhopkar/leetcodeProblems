package noOfIslands;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

class Position {
	int x, y;

	public Position(int x, int y) {
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
		Position other = (Position) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
	
	
}
public class Solution {
	
	public int numIslands(char[][] grid) {
		/*
		 * Steps:
		 * 1. Find the positions of all 1s
		 * 2. If no of 1s == 0, return 0
		 * 3. Select one position with 1, apply DFS
		 * 4. Cover all possible 1s you can
		 * 5. Mark them visited in a visited matrix
		 * 6. If all are visited, stop and return 1
		 * 7. Else, pick another 1, repeat the same process and
		 * 	  keep incrementing the number of islands
		 */
		Set<Position> onesPositions = new HashSet<>();
		int[][] neighbourPos = {
				{-1, 0}, {1, 0}, {0, -1}, {0, 1}	
		};
		int newX, newY, noOfIslands = 0;
		Position newPos;
		Position popped;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		// initially visited shall be false
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == '1') {
					onesPositions.add(new Position(i, j));
				}
			}
		}
		
		if(onesPositions.size() == 0) {
			// 0 1s
			return 0;
		}
		//now start the DFS
		Stack<Position> stack = new Stack<>();
		Position toBeAdded;
		while(onesPositions.size() > 0) {
			System.out.println(onesPositions);
			toBeAdded = getRandomPos(onesPositions);		
			stack.push(toBeAdded);
			while(!stack.isEmpty()) {
				popped = stack.pop();
				System.out.println("popped "+popped.x+", "+popped.y);
				visited[popped.x][popped.y] = true;
				onesPositions.remove(popped);
				for(int c = 0; c < neighbourPos.length; c++) {
					newX = popped.x + neighbourPos[c][0];
					newY = popped.y + neighbourPos[c][1];
					newPos = new Position(newX, newY);
					if(onesPositions.contains(newPos)) {
						stack.push(newPos);
					}				
				}
			}
			noOfIslands++;
		}
		return noOfIslands;
	}

	private Position getRandomPos(Set<Position> onesPositions) {
		Iterator<Position> it = onesPositions.iterator();
		return it.next();
	}

	public static void main(String[] args) {
		int[][] grid = {
				{1, 1, 0, 0, 0},
				{1, 1, 0, 1, 0},
				{1, 1, 1, 0, 1}
		};
		Solution s = new Solution();
		System.out.println(s.numIslands(charGrid(grid)));

	}

	private static char[][] charGrid(int[][] grid) {
		char[][] ret = new char[grid.length][grid[0].length];
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 1) {
					ret[i][j] = '1';
				}
				else ret[i][j] = '0';
			}
		}
		return ret;
	}

}
