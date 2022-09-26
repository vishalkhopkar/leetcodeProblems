package binaryTreePruning;

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
	@Override
	public String toString() {
		return "TreeNode [" + val + ", left=" + ((left == null) ? null : left.val) + ", right=" + ((right == null) ? null :right.val) + "]";
	}
    
}

public class Solution {
	
	public TreeNode pruneTree(TreeNode root) {
        prune(root);
        if(root.left == null && root.right == null && root.val == 0)
        	return null;
        return root;
    }
	
	private boolean prune(TreeNode x) {
		if(x == null)
			return false;
		boolean leftContains = prune(x.left);
		if(!leftContains)
			x.left = null;
		boolean rightContains = prune(x.right);
		if(!rightContains)
			x.right = null;
		if(x.val == 1)
			return true;
		// x.val == 0
		return leftContains | rightContains;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode root = new TreeNode(0);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(1);
		TreeNode t4 = new TreeNode(0);
		TreeNode t5 = new TreeNode(0);
		TreeNode t6 = new TreeNode(0);
		TreeNode t7 = new TreeNode(0);
		TreeNode t8 = new TreeNode(1);
		TreeNode t9 = new TreeNode(1);
		TreeNode t10 = new TreeNode(0);
		
		root.left = t2;
		root.right = t3;
		
		t2.left = t4;
		t2.right = t5;
		
		t3.left = t6;
		t3.right = t7;
		
		t4.left = t8;
		t4.right = t9;
		
		t5.left = t10;
		
		s.prune(root);
		System.out.println(t2);
		System.out.println(t3);

	}

}
