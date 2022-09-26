package naryLevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class QueueNode {
	Node n;
	int level;
	public QueueNode(Node n, int level) {
		super();
		this.n = n;
		this.level = level;
	}
	
}

public class Solution {
	
	public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<>(1000);
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 0));
        QueueNode polled;
        int levelOfPolled;
        List<Integer> listAtLevel;
        while(!queue.isEmpty()) {
        	polled = queue.poll();
        	levelOfPolled = polled.level;
        	
        	// add polled at levelOfPolled location in the ret list
        	if(ret.size() <= levelOfPolled) {
        		listAtLevel = new ArrayList<>();
        		ret.add(levelOfPolled, listAtLevel);
        	}
        	else {
        		listAtLevel = ret.get(levelOfPolled);
        	}
        	
        	listAtLevel.add(polled.n.val);
        	
        	// add all the children of listAtLevel to the queue
        	for(Node x : polled.n.children) {
        		queue.offer(new QueueNode(x, levelOfPolled + 1));
        	}
        }
        return ret;
	}
	

	public static void main(String[] args) {
		Solution s = new Solution();
		
	}
	

}
