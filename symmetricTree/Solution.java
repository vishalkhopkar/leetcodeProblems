package symmetricTree;

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

	public boolean isSymmetric(TreeNode root) {
		return isSameTree(root.left, root.right);
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null) {
            if(q == null) return true;
            return false;
        }
        if(q == null) {
            return false;
        }
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
