package nosWithConsecutiveDiff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
	
	public int[] numsSameConsecDiff(int n, int k) {
		List<Integer> ret = new ArrayList<>();
		Stack<List<Byte>> stack = new Stack<>();
		List<Byte> toBePushed;
		for(byte i = 1; i < 10; i++) {
			toBePushed = new ArrayList<>();
			toBePushed.add(i);
			stack.push(toBePushed);
		}
		List<Byte> popped;
		byte lastDigit;
		while(!stack.isEmpty()) {
			popped = stack.pop();
			if(popped.size() == n) {
				// we have reached the level
				ret.add(convertToInt(popped));
			}
			else {
				// add its children to the stack
				lastDigit = popped.get(popped.size() - 1);
				if(k == 0) {
					toBePushed = new ArrayList<>();
					toBePushed.addAll(popped);
					toBePushed.add((byte)(lastDigit + k));
					stack.push(toBePushed);
				}
				else {
					if(lastDigit + k < 10) {
						toBePushed = new ArrayList<>();
						toBePushed.addAll(popped);
						toBePushed.add((byte)(lastDigit + k));
						stack.push(toBePushed);
					}
					if(lastDigit - k >= 0) {
						toBePushed = new ArrayList<>();
						toBePushed.addAll(popped);
						toBePushed.add((byte)(lastDigit - k));
						stack.push(toBePushed);
					}
				}
				
			}
			
		}
		int[] retArray = new int[ret.size()];
		for(int i = 0; i < retArray.length; i++) {
			retArray[i] = ret.get(i);
		}
		return retArray;
			
    }
	private int convertToInt(List<Byte> popped) {
		int ret = 0;
		for(byte b : popped) {
			ret = ret*10 + b;
		}
		return ret;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.numsSameConsecDiff(5, 1)));

	}

}
