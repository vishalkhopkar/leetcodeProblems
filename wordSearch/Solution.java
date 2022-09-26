package wordSearch;

public class Solution {

	public boolean exist(char[][] board, String word) {
		char firstChar = word.charAt(0);
		boolean[][] visited = new boolean[board.length][board[0].length];
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[0].length; j++) {
				if(board[i][j] == firstChar) {
					System.out.println("board["+i+"]["+j+"] = vo");
					if(search(board, visited, i, j, word)) return true;
					visited = new boolean[board.length][board[0].length];
				}
			}
		}
		return false;
	}
	
	
	/**
	 * Check if word exists by doing a DFS from (i, j) in board
	 * @param board
	 * @param visited 
	 * @param i
	 * @param j
	 * @param word
	 * @return
	 */
	private boolean search(char[][] board, boolean[][] visited, int i, int j, String word) {
		System.out.println("i = "+i+", j = "+j+" word = "+word);
		boolean res = false;
		if(board[i][j] == word.charAt(0)) {
			visited[i][j] = true;
			if(word.length() == 1) return true;
			String substr = word.substring(1);
			if(i + 1 < board.length && !visited[i + 1][j]) {
				res |= search(board, visited, i + 1, j, substr);
				if(res) return true;
			}
			if(i - 1 >= 0 && !visited[i - 1][j]) {
				res |= search(board, visited, i - 1, j, substr);
				if(res) return true;
			}
			if(j + 1 < board[0].length && !visited[i][j + 1]) {
				res |= search(board, visited, i, j + 1, substr);
				if(res) return true;
			}
			if(j - 1 >= 0 && !visited[i][j - 1]) {
				res |= search(board, visited, i, j - 1, substr);
				if(res) return true;
			}
			visited[i][j] = false;
		}
		
		return false;
	}

	public static void main(String[] args) {
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','E','S'},
				{'A','D','E','E'}
		};
		Solution s = new Solution();
		System.out.println(s.exist(board, "ABCB"));

	}

}
