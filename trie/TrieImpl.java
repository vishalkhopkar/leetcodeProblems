package trie;

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

public class TrieImpl {
	
	public static void main(String[] args) {
		TrieNode tn = new TrieNode('~');
		tn.addToTrie("time", 0);
		tn.addToTrie("thing", 0);
		tn.addToTrie("timing", 0);
		tn.addToTrie("timer", 0);
		tn.print();

	}

}
