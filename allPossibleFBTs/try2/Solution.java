package allPossibleFBTs.try2;

import java.util.ArrayList;
import java.util.List;

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

public class Solution {
	
	
	public List<TreeNode> allPossibleFBT(int n) {
		
		List<TreeNode> ret = new ArrayList<>();
		if(n % 2 == 0) return ret;
		
		if(n == 1) {
			ret.add(new TreeNode(0));
			return ret;
		}
		
		for(int i = 1; i < n; i += 2) {
			/*
			 * The left subtree will have i nodes
			 * right subtree will have n - i - 1 nodes
			 */
			List<TreeNode> left = allPossibleFBT(i);
			List<TreeNode> right = allPossibleFBT(n - i - 1);
			for(TreeNode x : left) {
				for(TreeNode y : right) {
					TreeNode t = new TreeNode(0);
					t.left = x;
					t.right = y;
					ret.add(t);
				}
			}
		}
		
		return ret;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
