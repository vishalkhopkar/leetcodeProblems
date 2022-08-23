package binarySearchTree;

class BSTNode {
	int val;
	BSTNode left, right, par;
	static BSTNode min = null;
	static int noOfNodes = 0;
	
	public BSTNode(int val, BSTNode left, BSTNode right) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
		this.par = null;
		if(noOfNodes++ == 0) {
			this.min = this;
		}
	}
	public BSTNode(int val) {
		super();
		this.val = val;
		this.left = null;
		this.right = null;
		this.par = null;
		if(noOfNodes++ == 0) {
			this.min = this;
		}
	}
	
	public void insertNode(BSTNode x) {
		if(x.val < this.val) {
			if(this.left == null) {
				this.left = x;
				x.par = this;
				if(x.val < BSTNode.min.val) {
					BSTNode.min = x;
				}
			}
			else this.left.insertNode(x);
		}
		else {
			// x.val >= this.val
			if(this.right == null) {
				this.right = x;
				x.par = this;
			}
			else this.right.insertNode(x);
		}
	}
	
	public void print() {
		if(this.left != null) {
			System.out.println(this + " left -> "+this.left+ " par -> "+par);
			this.left.print();
		}
		else {
			System.out.println(this + " left -> null"+ " par -> "+par);
		}
		if(this.right != null) {
			System.out.println(this + " right -> "+this.right+ " par -> "+par);
			this.right.print();
		}
		else {
			System.out.println(this + " right -> null"+ " par -> "+par);
		}
	}
	
	public void preorder() {
		System.out.println(this);
		if(this.left != null) {
			this.left.preorder();
		}
		if(this.right != null) {
			this.right.preorder();
		}
	}
	
	
	
	
	
	@Override
	public String toString() {
		return String.valueOf(val);
	}
	public static void main(String[] args) {
		BSTNode root = new BSTNode(1);
		System.out.println(BSTNode.min);
		root.insertNode(new BSTNode (2));
		root.insertNode(new BSTNode (0));
		root.insertNode(new BSTNode (-1));
		root.insertNode(new BSTNode (-3));
		root.insertNode(new BSTNode (5));
		root.insertNode(new BSTNode (6));
		root.insertNode(new BSTNode (5));
		root.insertNode(new BSTNode (7));
		root.insertNode(new BSTNode (-4));
		root.insertNode(new BSTNode (-2));
		root.print();
		root.preorder();
		System.out.println(BSTNode.min);
	}
	
	
}
