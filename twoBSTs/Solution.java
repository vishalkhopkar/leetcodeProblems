package twoBSTs;

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

class Solution {

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> inorder1, inorder2, merged;
		inorder1 = new ArrayList<>();
		inorder2 = new ArrayList<>();

		inorder(root1, inorder1);
		inorder(root2, inorder2);

		int totalElems = inorder1.size() + inorder2.size();

		merged = new ArrayList<>(totalElems);

		inorder1.add(Integer.MAX_VALUE);
		inorder2.add(Integer.MAX_VALUE);

		int i = 0, j = 0;
		for (int c = 0; c < totalElems; c++) {
			if (inorder1.get(i) <= inorder2.get(j)) {
				merged.add(inorder1.get(i++));
			} else {
				merged.add(inorder2.get(j++));
			}
		}
		return merged;

	}

	private void inorder(TreeNode t, List<Integer> outList) {
		if (t != null) {
			inorder(t.left, outList);
			outList.add(t.val);
			inorder(t.right, outList);
		}
	}
}