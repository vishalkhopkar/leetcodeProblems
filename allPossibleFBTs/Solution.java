package allPossibleFBTs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
	
	
}

class TreeNodeWrapper {
	TreeNode tree;
	
	public TreeNodeWrapper(TreeNode tree) {
		super();
		this.tree = tree;
	}

	
	List<TreeNode> getChildNodes(){
		List<TreeNode> childNodes = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		st.push(tree);
		TreeNode t;
		while(!st.isEmpty()) {
			t = st.pop();
			/*
			 * since this is a FBT, if it has a left child,
			 * it also has a right child
			 */
			if(t.left != null) {
				st.push(t.left);
				st.push(t.right);
			}
			else {
				childNodes.add(t);
			}
			
		}
		return childNodes;
	}
	
	@Override
	public boolean equals(Object t) {
		if(t.getClass() != TreeNodeWrapper.class) return false;
		TreeNode t1 = ((TreeNodeWrapper) t).tree;
		TreeNode thisLeft, thisRight, t1Left, t1Right;
		Stack<TreeNode> thisStack = new Stack<>();
		Stack<TreeNode> t1Stack = new Stack<>();
		thisStack.push(tree);
		t1Stack.push(t1);
		TreeNode thisPopped, t1Popped;
		while(!thisStack.isEmpty() && !t1Stack.isEmpty()) {
			thisPopped = thisStack.pop();
			t1Popped = t1Stack.pop();
			if(thisPopped.val != t1Popped.val) return false;
			
			thisLeft = thisPopped.left;
			t1Left = t1Popped.left;
			if((thisLeft == null && t1Left != null) || (thisLeft != null && t1Left == null)) {
				return false;
			}
			
			thisRight = thisPopped.right;
			t1Right = t1Popped.right;
			
			if((thisRight == null && t1Right != null) || (thisRight != null && t1Right == null)) {
				return false;
			}
			
			/*
			 * clear until now
			 */
			if(thisLeft != null) {
				thisStack.push(thisLeft);
				t1Stack.push(t1Left);
			}
				
			if(thisRight != null) {
				thisStack.push(thisRight);
				t1Stack.push(t1Right);
			}		
			
			
		}
		if((!t1Stack.isEmpty() && thisStack.isEmpty()) || 
				(!thisStack.isEmpty() && t1Stack.isEmpty())) {
			return false;
		}
		return true;
		
	}
	
	@Override
	public int hashCode() {
		return tree.val;		
	}
}
public class Solution {
	
	List<List<TreeNode>> dpTable = new ArrayList<>();
	
	public List<TreeNode> allPossibleFBT(int n) {
		if(n % 2 == 0) {
			return new ArrayList<>();
		}
		List<TreeNode> first = new ArrayList<>();
		first.add(new TreeNode(0));
		dpTable.add(first);
		for(int i = 2; i < n; i+=2) {
			
		}
		return null;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		
		TreeNode t1 = new TreeNode(0);
		t1.left = new TreeNode(0);
		t1.right = new TreeNode(0);
		
		TreeNode t2 = new TreeNode(0);
		t2.left = new TreeNode(0);
		t2.right = new TreeNode(0);
		t2.left.left = new TreeNode(0);
		
		TreeNodeWrapper t1Wrapper = new TreeNodeWrapper(t1);
		
		System.out.println(t1Wrapper.getChildNodes());

	}

}
