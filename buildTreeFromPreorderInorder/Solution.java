package buildTreeFromPreorderInorder;

import java.util.Arrays;

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

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder,
			int inorderStart, int inorderEnd) {
		System.out.printf("BT(IS = %d, IE = %d, PS = %d, PE = %d)\n", inorderStart, inorderEnd,
				preorderStart, preorderEnd);
		/*
		 * preorder[preorderStart] is the root
		 */
		int rootVal = preorder[preorderStart];
		TreeNode root = new TreeNode(rootVal);
		if(inorderStart == inorderEnd) {
			System.out.println("leaf node for "+preorder[preorderStart]);
			return root;
		}
		/*
		 * find this root in inorder
		 */
		int leftInorderEnd, rightInorderStart;
		int leftPreorderStart, leftPreorderEnd = 0, rightPreorderStart, rightPreorderEnd;
		int inorderRootIndex = find(inorder, inorderStart, inorderEnd, rootVal);
		System.out.println("inorder root index "+inorderRootIndex+" for rootval "+rootVal);
		/*
		 * root found
		 * left of this upto inorderStart is the left subtree
		 * right of this upto inorderEnd is the right subtree
		 */
		leftInorderEnd = inorderRootIndex - 1;
		rightInorderStart = inorderRootIndex + 1;
		/*
		 * find the preorder start and end for these subtrees
		 */
		int maxIndex = preorderStart + 1;
		if(leftInorderEnd >= inorderStart) {
			for(int i = inorderStart; i < inorderRootIndex; i++) {
				maxIndex = Math.max(maxIndex, find(preorder, preorderStart + 1, preorderEnd, inorder[i]));
			}
			leftPreorderEnd = maxIndex;
			leftPreorderStart = preorderStart + 1;
			root.left = buildTree(preorder, leftPreorderStart, leftPreorderEnd, inorder,
					inorderStart, leftInorderEnd);
		}					
		else {
			root.left = null;
		}
		
		if(rightInorderStart <= inorderEnd) {
			/*
			 * right subtree exists
			 */
			if(leftInorderEnd >= inorderStart) {
				rightPreorderStart = leftPreorderEnd + 1;				
			}
			else {
				rightPreorderStart = preorderStart + 1;
			}
			
			rightPreorderEnd = preorderEnd;
			root.right = buildTree(preorder, rightPreorderStart, rightPreorderEnd, inorder,
					rightInorderStart, inorderEnd);
			
		}
		else {
			root.right = null;
		}
		return root;
		
	}

	private int find(int[] arr, int start, int end, int key) {
		
		for(int i = start; i <= end; i++) {
			if(arr[i] == key) return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] preorder = {3,2,1,4};
		int[] inorder = {1,2,3,4};
		Solution s = new Solution();
		s.buildTree(preorder, inorder);
		int[] y = Arrays.copyOf(inorder, inorder.length);
		System.out.println(Arrays.toString(y));

	}

}
