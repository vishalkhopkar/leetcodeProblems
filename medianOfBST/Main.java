package medianOfBST;

class BSTNode {
	int val;
	BSTNode left, right;
	public BSTNode(int val) {
		super();
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
}
class BST {
	BSTNode root;
	int length = 0;
	int currInorderPos = 0;
	int inorderRes1 = Integer.MAX_VALUE;
	int inorderRes2 = Integer.MAX_VALUE;
	boolean inorderRes1Set = false;
	boolean inorderRes2Set = false;

	public BST(BSTNode root) {
		super();
		this.root = root;
		length++;
	}
	
	void insert(int x) {
		insertInner(x, root);
	}
	
	void insertInner(int x, BSTNode node) {
		
		if(x <= node.val) {
			if(node.left == null) {
				node.left = new BSTNode(x);
				length++;
			}				
			else
				insertInner(x, node.left);
		}
		else {
			if(node.right == null) {
				node.right = new BSTNode(x);
				length++;
			}				
			else
				insertInner(x, node.right);
		}
		
	}
	
	double median() {
		if(length % 2 != 0) {
			/*
			 * odd number of elems
			 * retrieve the middle
			 */
			inorder(length/2, false);
			return inorderRes1;
		}
		else {
			inorder(length/2 - 1, true);
			return (double)(inorderRes1 + inorderRes2)/2;
		}
	}
	
	void inorder(int n, boolean returnTwo) {
		currInorderPos = 0;
		inorderRes1Set = false;
		inorderRes2Set = false;
		inorderInner(n, root, returnTwo);
		
	}
	
	void inorderInner(int n, BSTNode node, boolean returnTwo) {
		if(node != null) {
			inorderInner(n, node.left, returnTwo);
			if(!inorderRes1Set && currInorderPos == n) {
				inorderRes1 = node.val;
				inorderRes1Set = true;
				if(!returnTwo) return;
			}
			else if(inorderRes1Set && !inorderRes2Set) {
				System.out.println("node.val "+node.val);
				inorderRes2 = node.val;
				inorderRes2Set = true;
				return;
			}
			else currInorderPos++;
			inorderInner(n, node.right, returnTwo);
			
		}
			
	}
	
	void fullInorder() {
		fullInorderInner(root);
		System.out.println();
	}
	
	void fullInorderInner(BSTNode node) {
		if(node != null) {
			fullInorderInner(node.left);
			System.out.print(node.val+" ");
			fullInorderInner(node.right);
		}
	}
}
public class Main {
	public static void main(String[] args) {
		BSTNode x = new BSTNode(10);
		BST tree = new BST(x);
		tree.fullInorder();
		
		System.out.println(tree.length);
		System.out.println(tree.median());
	}

}
