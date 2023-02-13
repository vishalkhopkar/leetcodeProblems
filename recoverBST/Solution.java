package recoverBST;

import java.util.ArrayList;
import java.util.Arrays;
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

	@Override
	public String toString() {
		return String.valueOf(val);
	}
	
	
}

public class Solution {

	List<TreeNode> inOrderList;
	List<TreeNode> parentList;
	public void recoverTree(TreeNode root) {
		inOrderList = new ArrayList<>();
		parentList = new ArrayList<>();
        inorder(root, null);
        System.out.println(inOrderList);
        System.out.println(parentList);
        int[] vals = new int[inOrderList.size()];
        for(int i = 0; i < vals.length; i++) {
        	vals[i] = inOrderList.get(i).val;
        }
        Arrays.sort(vals);
        for(int i = 0; i < vals.length; i++) {
        	inOrderList.get(i).val = vals[i];
        }
    }
	
	

	private void inorder(TreeNode root, TreeNode par) {
		if(root != null) {
			inorder(root.left, root);
			inOrderList.add(root);
			parentList.add(par);
			inorder(root.right, root);
		}
		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(-1);
		root.left.right = new TreeNode(2);
		root.left.left = new TreeNode(-3);
		
		root.right = new TreeNode(10);
		root.right.left = new TreeNode(7);
		
		s.recoverTree(root);

	}

}
