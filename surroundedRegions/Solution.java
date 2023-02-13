package surroundedRegions;

import java.util.Arrays;
import java.util.Stack;

class Location {
	int x, y;

	public Location(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "("+ x + ", "+ y+ ")";
	}
	
	
}
public class Solution {

	public void solve(char[][] board) {
		int m = board.length;
		int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        Stack<Location> st = new Stack<>();
        for(int i = 0; i < n; i++) {
        	if(board[0][i] == 'O' && !visited[0][i]) {
        		st.push(new Location(0, i));
        		visited[0][i] = true;
        	}
        }
        for(int i = 0; i < n; i++) {
        	if(board[m - 1][i] == 'O' && !visited[m - 1][i]) {
        		st.push(new Location(m - 1, i));
        		visited[m - 1][i] = true;
        	}
        }
        for(int i = 0; i < m; i++) {
        	if(board[i][0] == 'O' && !visited[i][0]) {
        		st.push(new Location(i, 0));
        		visited[i][0] = true;
        	}
        }
        for(int i = 0; i < m; i++) {
        	if(board[i][n - 1] == 'O' && !visited[i][n - 1]) {
        		st.push(new Location(i, n - 1));
        		visited[i][n - 1] = true;
        	}
        }
        
        Location popped;
        while(!st.isEmpty()) {
        	popped = st.pop();
        	
        	if(popped.x - 1 >= 0) {
        		if(board[popped.x - 1][popped.y] == 'O' && !visited[popped.x - 1][popped.y]) {
        			st.push(new Location(popped.x - 1, popped.y));
        			visited[popped.x - 1][popped.y] = true;
        		}
        	}
        	
        	if(popped.x + 1 < m) {
        		if(board[popped.x + 1][popped.y] == 'O' && !visited[popped.x + 1][popped.y]) {
        			st.push(new Location(popped.x + 1, popped.y));
        			visited[popped.x + 1][popped.y] = true;
        		}
        	}
        	
        	if(popped.y - 1 >= 0) {
        		if(board[popped.x][popped.y - 1] == 'O' && !visited[popped.x][popped.y - 1]) {
        			st.push(new Location(popped.x, popped.y - 1));
        			visited[popped.x][popped.y - 1] = true;
        		}
        	}
        	
        	if(popped.y + 1 < n) {
        		if(board[popped.x][popped.y + 1] == 'O' && !visited[popped.x][popped.y + 1]) {
        			st.push(new Location(popped.x, popped.y + 1));
        			visited[popped.x][popped.y + 1] = true;
        		}
        	}
        }
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(board[i][j] == 'O' && !visited[i][j]) {
        			board[i][j] = 'X';
        		}
        	}
        }
        
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		char[][] board = {{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}};
		s.solve(board);
		
		for(int i = 0; i < board.length; i++)
			System.out.println(Arrays.toString(board[i]));

	}

}
