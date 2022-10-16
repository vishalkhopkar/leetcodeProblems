package bstNew;

import java.util.ArrayList;
import java.util.List;

class BSTNode {
	int val;
	BSTNode left, right, par;
	ChildType childType;
	public BSTNode(int val) {
		super();
		this.val = val;
	}
	
	void insertNode(BSTNode newNode) {
		if(newNode.val <= this.val) {
			// add in the left subtree
			if(this.left == null) {
				
				this.left = newNode;
				newNode.par = this;
				newNode.childType = ChildType.LEFT;
			}
			else {
				this.left.insertNode(newNode);
			}
		}
		else {
			// add in the right subtree
			if(this.right == null) {
				this.right = newNode;
				newNode.par = this;
				newNode.childType = ChildType.RIGHT;
			}
			else {
				this.right.insertNode(newNode);
			}
		}
	}

	@Override
	public String toString() {
		return "[" + val + ", left=" + ((left == null) ? " null" : left.val) +
				", right=" + ((right == null) ? " null" : right.val) + ", par=" + 
				((par == null) ? " null" : par.val) + ", childType="
				+ childType + "]";
	}
	
	
	
}
enum ChildType {
	LEFT, RIGHT;
	
}
class BST {
	BSTNode root;
	BSTNode min, max;
	public BST(BSTNode root) {
		super();
		this.root = root;
		this.min = root;
		this.max = root;
	}
	void insertNode(BSTNode x) {
		root.insertNode(x);
		if(x.val > max.val) max = x;
		else if(x.val < min.val) min = x;
	}
	
	BSTNode inOrderSuccessor(BSTNode t) {
		if(t == max) return null;
		if(t.right != null) {
			BSTNode curr = t.right;
			while(curr.left != null) {
				curr = curr.left;
			}
			return curr;
		}
		if(t.childType == ChildType.LEFT) {
			/*
			 * t's right child is null
			 * but t is somebody's left child
			 * in this case, the IOS is
			 * t's parent
			 */
			return t.par;
		}
		else {
			/*
			 * t's right child is null
			 * and t is somebody's right child
			 * in this case, the IOS is
			 * an ancestor who id just larger than t
			 * i.e. some ancestor in which left subtree
			 * you fall
			 * 
			 * Note: there cannot be a case that here t does
			 * not have a parent, because if that is the case then
			 * t is the root node, but that is also the maximum
			 * hence we would never come here
			 * 
			 * That is also the reason we don't need to check for
			 * curr != null in the while loop below
			 */
			BSTNode curr = t.par;
			while(curr.val < t.val) {
				curr = curr.par;
			}
			return curr;
		}
	}
	
	BSTNode inOrderPredecessor(BSTNode t) {
		if(t == min) return null;
		if(t.left != null) {
			BSTNode curr = t.left;
			while(curr.right != null) {
				curr = curr.right;
			}
			return curr;
		}
		if(t.childType == ChildType.RIGHT) {
			
			return t.par;
		}
		else {
			BSTNode curr = t.par;
			while(curr.val > t.val) {
				curr = curr.par;
			}
			return curr;
		}
	}
	
}


public class Main {
	
	public static void main(String[] args) {
		BSTNode a = new BSTNode(10);
		BST tree = new BST(a);
		List<BSTNode> children = new ArrayList<>();
		int[] childrenVals = {2, 20, 0, 5, 17, 12, 13, 19, 18, 25};
		for(int x : childrenVals) {
			BSTNode t = new BSTNode(x);
			children.add(t);
			tree.insertNode(t);
		}
		
		System.out.println(tree.inOrderPredecessor(a));
		
	}
}
