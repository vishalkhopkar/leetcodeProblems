package pushDominoes;

import java.util.ArrayList;
import java.util.List;

class Index {
	/*
	 * false = left, true = right
	 */
	boolean direction;
	int index;
	public Index(int index, boolean direction) {
		super();
		this.direction = direction;
		this.index = index;
	}
	@Override
	public String toString() {
		return "[" + (direction ? "R" : "L")+ ", " + index + "]";
	}
	
	
}
public class Solution {
	
	public String pushDominoes(String dominoes) {
		StringBuilder sb = new StringBuilder(dominoes);
        // find the indices of R and L first
		List<Index> pushIndices = new ArrayList<>();
		for(int i = 0; i < dominoes.length(); i++) {
			if(dominoes.charAt(i) == 'L') {
				pushIndices.add(new Index(i, false));
			}
			else if(dominoes.charAt(i) == 'R') {
				pushIndices.add(new Index(i, true));
			}
		}
		//System.out.println(pushIndices);
		int j, noOfMiddleElems;
		Index first, second;
		for(int i = 0; i < pushIndices.size() - 1; i++) {
			j = i + 1;
			first = pushIndices.get(i);
			second = pushIndices.get(j);
			if(first.direction == false && second.direction == true) {
				// L R, nothing to be done
				
			}
			else if(first.direction == true && second.direction == false) {
				// R....L case
				//System.out.println("here "+first+", "+second);
				noOfMiddleElems = second.index - first.index - 1;
				//System.out.println("no of middle elems "+noOfMiddleElems);
				// even elems and odd elems have the same formula		
				setCharsTo(true, sb, first.index + 1, first.index + noOfMiddleElems/2);
				setCharsTo(false, sb, second.index - noOfMiddleElems/2, second.index - 1);
				
			}
			else if(first.direction == true && second.direction == true) {
				setCharsTo(true, sb, first.index + 1, second.index - 1);
			}
			else {
				// L... L
				setCharsTo(false, sb, first.index + 1, second.index - 1);
			}
			
		}
		
		if(!pushIndices.isEmpty()) {
			// take care of the ends
			first = pushIndices.get(0);
			Index last = pushIndices.get(pushIndices.size() - 1);
			if(!first.direction) {
				// first elem is left
				setCharsTo(false, sb, 0, first.index - 1);
			}
			if(last.direction) {
				// last element is right
				setCharsTo(true, sb, last.index + 1, dominoes.length() - 1);
			}
		}
		
		return sb.toString();
    }
	
	
	private void setCharsTo(boolean direction, StringBuilder sb, int i, int j) {
		for(int c = i; c <= j; c++) {
			sb.setCharAt(c, (direction) ? 'R' : 'L');
		}
		
	}


	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.pushDominoes(".L.R...LR..L.."));

	}

}
