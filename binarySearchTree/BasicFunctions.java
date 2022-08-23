package binarySearchTree;

public class BasicFunctions {
	
	public static BSTNode deleteNode(BSTNode root, BSTNode x) {
		// delete x from the tree under root
		if(x == root) {
			if(x.left == null && x.right == null) {
				// root node is a leaf node
				root = null;
				if(x == BSTNode.min) BSTNode.min = null;
				return null;
			}
			else if(x.left == null) {
				// x only has 1 right child
				x.right.par = null;
				if(x == BSTNode.min) {
					// if x was the minimum, x's inorder succ is the new min
					BSTNode.min = inorderSuccessor(x);
				}
				return x.right;
			}
			else if(x.right == null) {
				x.left.par = null;
				return x.left;
			}
			else {
				// x has both the children
				// find the inorder successor
				BSTNode y = inorderSuccessor(x);
			}
			
			
		}
		else {
			// x is not the root so it has a non null parent
			if(x.left == null && x.right == null) {
				// x has no children, safe to remove as it is
				// x is a leaf node
				if(x.par.left == x) {
					// x is the left child of its parent
					x.par.left = null;
					if(x == BSTNode.min) {
						// if x was the minimum, x's parent is the new min
						BSTNode.min = x.par;
					}
				}
				else {
					// x is the right child of its parent
					x.par.right = null;
				}
			}
			else if(x.left == null) {
				// x only has 1 right child
				if(x.par.left == x) {
					// x is the left child of its parent
					x.par.left = x.right;
					if(x == BSTNode.min) {
						// if x was the minimum, x's inorder successor is the new min
						BSTNode.min = inorderSuccessor(x);
					}
				}
				else {
					// x is the right child of its parent
					x.par.right = x.right;
				}
				x.right.par = x.par;
			}
			else if(x.right == null) {
				// x has only 1 left child
				if(x.par.left == x) {
					// x is the left child of its parent
					x.par.left = x.left;
				}
				else {
					// x is the right child of its parent
					x.par.right = x.left;
				}
				x.left.par = x.par;
			}
			else {
				// x has both a left and right child
				// find the inorder successor of this node
				// this inorder successor will always be a node which does not have a left child
				BSTNode y = inorderSuccessor(x);
				// now y is the inorder successor
				// y.left is null so don't take care of it
				y.left = x.left;
				if(x.par.left == x) {
					// x is the left child of its parent
					x.par.left = y;
				}
				else {
					// x is the right child of its parent
					x.par.right = y;
				}
				x.left.par = y;
				x.right.par = y;
				y.par = x.par;
				
				
			}
		}
		return x;
		
	}
	
	private static BSTNode inorderSuccessor(BSTNode x) {
		BSTNode y = x.right;
		while(y.left != null) y = y.left;
		return y;
	}

	public static void main(String[] args) {
		BSTNode root = new BSTNode(100);
		BSTNode n = new BSTNode(0);
		root.insertNode(n);
		root.insertNode(new BSTNode(-100));
		root.insertNode(new BSTNode(-300));
		root.insertNode(new BSTNode(-400));
		root.insertNode(new BSTNode(-200));
		root.insertNode(new BSTNode(200));
		root.insertNode(new BSTNode(500));
		root.insertNode(new BSTNode(600));
		root.insertNode(new BSTNode(500));
		root.insertNode(new BSTNode(700));
		root.insertNode(new BSTNode(50));
		root.insertNode(new BSTNode(25));
		root.insertNode(new BSTNode(75));
		root.insertNode(new BSTNode(-50));
		root.print();
		
		deleteNode(root, n);
		System.out.println("\n");
		
		root.print();
	}

}
