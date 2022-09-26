package binaryTreeLevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class QueueNode {
	TreeNode n;
	int level;
	public QueueNode(TreeNode n, int level) {
		super();
		this.n = n;
		this.level = level;
	}
	
}
public class Solution {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		if(root == null) return new ArrayList<>();
		List<List<Integer>> ret = new ArrayList<>(1000);
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 0));
        QueueNode polled;
        int levelOfPolled;
        List<Integer> listAtLevel;
        while(queue != null) {
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
        	queue.offer(new QueueNode(polled.n.left, levelOfPolled + 1));
        	queue.offer(new QueueNode(polled.n.right, levelOfPolled + 1));
        	
        }
        return ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
