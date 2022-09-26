package longestCommonPrefix;

import java.util.ArrayList;
import java.util.List;

class TrieNode {
	char x;
	List<TrieNode> children;
	TrieNode[] childExists;
	boolean isEndNode;
	public TrieNode(char x) {
		super();
		this.x = x;
		this.children = new ArrayList<>();
		this.isEndNode = false;
		this.childExists = new TrieNode[26];
	}
	
	void addToTrie(String s, int index) {
		TrieNode tNode;		
		// if this trienode already has a child of s.charAt(0), no need to create a new child
		tNode = childExists[s.charAt(index) - 'a'];
		
		if(tNode == null) {
			tNode = new TrieNode(s.charAt(index));
			this.children.add(tNode);
			this.childExists[s.charAt(index) - 'a'] = tNode;
		}
		
		if(index == s.length() - 1) {
			// end node
			tNode.isEndNode = true;
		}
		else {
			tNode.addToTrie(s, index + 1);
		}
		
	}
	
	@Override
	public String toString() {
		return "[" + x + "] isend = "+isEndNode;
	}

	void print() {
		System.out.println(this + " children: ");
		for(TrieNode n : children) {
			System.out.print(n.x);
			System.out.print(", ");
		}
		System.out.println();
		for(TrieNode n : children) {
			n.print();
		}
	}

}
public class Solution {
	
	public String longestCommonPrefix(String[] strs) {
		int minLen = Integer.MAX_VALUE;
		for(int i = 0; i < strs.length; i++) {
			minLen = Math.min(minLen, strs[i].length());
		}
		if(minLen == 0) return "";
		System.out.println("minLen "+minLen);
		boolean charEqual = true;
		char charComp;
		StringBuilder prefix = new StringBuilder();
		for(int i = 0; i < minLen; i++) {
			charComp = strs[0].charAt(i);
			for(int j = 1; j < strs.length; j++) {
				charEqual &= (strs[j].charAt(i) == charComp);
				if(!charEqual) return prefix.toString();
			}
			// charEqual is true
			// the chars are same
			prefix.append(charComp);
		}
		return prefix.toString();
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] words = {"flow","flow","flower"};
		System.out.println(s.longestCommonPrefix(words));

	}

}
