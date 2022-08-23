package shortEncoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode {
	char x;
	List<TrieNode> children;
	TrieNode[] childExists;
	TrieNode par;
	boolean isEndNode;
	String fullStr;
	static int totalNodes = 0;
	static List<TrieNode> suffixNodes = new ArrayList<>();
	static Map<String, Integer> duplicateWords = new HashMap<>();
	public TrieNode(char x) {
		super();
		this.x = x;
		this.children = new ArrayList<>();
		this.isEndNode = false;
		this.childExists = new TrieNode[26];
		this.par = null;
	}
	
	void addToTrie(String s, int index) {
		TrieNode tNode;		
		// if this trienode already has a child of s.charAt(0), no need to create a new child
		tNode = childExists[s.charAt(index) - 'a'];
		
		if(tNode == null) {
			totalNodes++;
			tNode = new TrieNode(s.charAt(index));
			tNode.par = this;
			this.children.add(tNode);
			this.childExists[s.charAt(index) - 'a'] = tNode;
		}
		
		if(index == 0) {
			// end node
			if(tNode.isEndNode) {
				// was already an endnode
				// duplicate word
				Integer frequency = duplicateWords.get(s);
				if(frequency != null) {
					// was already duplicated earlier
					// this is atleast the third occurrence
					duplicateWords.put(s, ++frequency);
				}
				// we are putting the extra occurrence frequency, not the original one
				else duplicateWords.put(s, 1);
			}
			else {
				tNode.isEndNode = true;
				tNode.fullStr = s;
			}
			
		}
		else {
			tNode.addToTrie(s, index - 1);
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

	public int countLeafNodes() {
		if(this.isEndNode && this.children.size() == 0) return 1;
		int s = 0;
		for(TrieNode tn : children) {
			s += tn.countLeafNodes();
		}
		return s;
	}
	
	public void identifySuffixWords() {
		if(this.isEndNode && this.children.size() == 0) return;
		if(this.isEndNode) TrieNode.suffixNodes.add(this);
		for(TrieNode tn : children) {
			tn.identifySuffixWords();
		}
	}

	public List<String> identifySuffixWordStrs() {
		// iterate over TrieNode.suffixNodes
		List<String> ret = new ArrayList<String>();
		for(TrieNode suffixNode : TrieNode.suffixNodes) {
			ret.add(suffixNode.fullStr);
		}
		return ret;
	}

}

public class Solution {
	public int minimumLengthEncoding(String[] words) {
		TrieNode tn = new TrieNode('~');
		int totalLength = 0;
		int wordLen;
        for(String word : words) {
        	wordLen = word.length();
        	totalLength += wordLen;
        	tn.addToTrie(word, wordLen - 1);
        }
        int totalLeafNodes = tn.countLeafNodes();
        System.out.println("total leaf nodes "+totalLeafNodes);
        tn.identifySuffixWords();
        
        List<String> suffixWords = tn.identifySuffixWordStrs();
        System.out.println("total suffix words "+suffixWords);
        int suffixWordsLen = 0;
        for(String u : suffixWords) {
        	suffixWordsLen += u.length();
        }
        System.out.println("suffix words total len "+suffixWordsLen);
        
        // consider repeated words
        int reducedLength = 0;
        for(String w : TrieNode.duplicateWords.keySet()) {
        	reducedLength += w.length()*TrieNode.duplicateWords.get(w);
        	reducedLength += TrieNode.duplicateWords.get(w);
        }
        TrieNode.totalNodes = 0;
        TrieNode.suffixNodes = new ArrayList<>();
        TrieNode.duplicateWords.clear();
        return totalLength - suffixWordsLen + words.length - suffixWords.size() - reducedLength;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] words = {"time", "time", "time", "time"};
		System.out.println(s.minimumLengthEncoding(words));
		
	}

}
