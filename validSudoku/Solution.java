package validSudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public boolean isValidSudoku(char[][] board) {
		
		Set<Character> elems = new HashSet<>();
		
        // check in the rows first
		for(int i = 0; i < board.length; i++) {
			
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] >= '0' && board[i][j] <= '9')
					if(!elems.add(board[i][j])) return false;
			}
			elems.clear();
		}
		System.out.println("row done");	
		System.out.println(elems);
		// check in the columns now
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[j][i] >= '0' && board[j][i] <= '9')
					if(!elems.add(board[j][i])) return false;
			}
			elems.clear();
		}
		System.out.println("col done");	
		// now check the 3x3 grids
		int currRow = 0, currCol = 0;
		for(int i = 0; i < board.length; i++) {
			if(duplicatesFound(board, currRow, currCol, elems)) return false;
			currCol += 3;
			if(currCol == board.length) {
				currCol = 0;
				currRow += 3;
			}
		}
		return true;
    }
	private boolean duplicatesFound(char[][] board, int currRow, int currCol, Set<Character> elems) {
		elems.clear();
		for(int i = currRow; i < currRow + 3; i++) {
			for(int j = currCol; j < currCol + 3; j++) {
				if(board[i][j] >= '0' && board[i][j] <= '9')
					if(!elems.add(board[i][j])) return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		
		Solution s = new Solution();
		char[][] board = 
			{
					{'5','3','.','.','7','.','.','.','.'},
					{'6','.','.','1','9','5','.','.','.'},
					{'.','9','8','.','.','.','.','6','.'},
					{'8','.','.','.','6','.','.','.','3'},
					{'4','.','.','8','.','3','.','.','1'},
					{'7','.','.','.','2','.','.','.','6'},
					{'.','6','.','.','.','.','2','8','.'},
					{'.','.','.','4','1','9','.','.','5'},
					{'.','.','.','.','8','.','.','7','9'}
			};
		System.out.println(s.isValidSudoku(board));
	}

}
