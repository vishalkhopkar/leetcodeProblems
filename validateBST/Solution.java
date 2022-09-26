package validateBST;

import java.util.ArrayList;
import java.util.List;

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
public class Solution {
	List<Integer> traversal;
	boolean traversalFlag = false;
	public boolean isValidBST(TreeNode root) {
		/*
		 * Traverse in inorder
		 * Whenever we get an element which is less than equal to previous,
		 * return false
		 * 
		 */
		traversal = new ArrayList<>();
		inorder(root);
		return !traversalFlag;
	}
	
	void inorder(TreeNode x) {
		if(x != null && !traversalFlag) {
			inorder(x.left);
			if(!traversal.isEmpty() && x.val <= traversal.get(traversal.size() - 1)) {
				traversalFlag = true;
				return;
			}
			traversal.add(x.val);
			inorder(x.right);
			
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode x1 = new TreeNode(5);
		TreeNode x2 = new TreeNode(15);
		root.left = x2;
		root.right = x1;
		Solution s = new Solution();
		System.out.println(s.isValidBST(root));
	}

}
