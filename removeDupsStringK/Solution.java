package removeDupsStringK;

import java.util.ArrayList;
import java.util.List;

class LLNode {
	char val;
	LLNode next;
	public LLNode(char val) {
		super();
		this.val = val;
	}
	
}

class MyLinkedList {
	LLNode head;
	
	LLNode insert(char x) {
		LLNode node = new LLNode(x);
		
		node.next = head;
		head = node;
		
		return node;
	}
	
	char peek() {
		return head.val;
	}
	
	boolean isEmpty() {
		return (head == null);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		LLNode curr = head;
		while(curr != null) {
			sb.insert(0, curr.val);
			curr = curr.next;
		}
		return sb.toString();
	}
}
public class Solution {

	public String removeDuplicates(String s, int k) {
		MyLinkedList ll = new MyLinkedList();
		List<LLNode> positions = new ArrayList<>();
		List<Integer> ctr = new ArrayList<>();
		char x;
		int count;
		int n;
		LLNode node;
		for(int i = 0; i < s.length(); i++) {
			x = s.charAt(i);
			//System.out.println(ll);
			//System.out.println("encountered "+x);
			if(ll.isEmpty() || x != ll.peek()) {
				// add a new entry
				node = ll.insert(x);
				positions.add(node);
				ctr.add(1);
			}
			else {
				// x == ll.peek()
				n = ctr.size();
				count = ctr.get(n - 1) + 1;
				if(count == k) {
					// remove these
					if(n == 1) {
						ll.head = null;
						
					}
					else {
						ll.head = positions.get(n - 2);
					}
					positions.remove(n - 1);
					ctr.remove(n - 1);
				}
				else {
					node = ll.insert(x);
					positions.set(n - 1, node);
					ctr.set(n - 1, count);
				}
					
				
			}
		}
		
		/*
		 * check what's remaining on the linkedlist
		 * add in reverse order
		 */
		StringBuilder sb = new StringBuilder();
		LLNode curr = ll.head;
		while(curr != null) {
			sb.insert(0, curr.val);
			curr = curr.next;
		}
		return sb.toString();
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.removeDuplicates("iiiixxxxxiiccccczzffffflllllllllfffffllyyyyyuuuuuz", 5));

	}

}
