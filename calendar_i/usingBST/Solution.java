package calendar_i.usingBST;

class BSTNode {
	int start, end;
	BSTNode left, right, par;
	ChildType childType;
	public BSTNode(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	
	BSTNode insertNode(BSTNode newNode) {
		if(newNode.start == this.start) return null;
		if(newNode.start < this.start) {
			// add in the left subtree
			if(this.left == null) {
				
				// can insert
				
				return this;
			}
			else {
				return this.left.insertNode(newNode);
			}
		}
		else {
			// add in the right subtree
			if(this.right == null) {
				
				// can insert
				return this;
			}
			else {
				return this.right.insertNode(newNode);
			}
		}
	}

	@Override
	public String toString() {
		return "[" + start + ", "+end +", left=" + ((left == null) ? " null" : left.start) +
				", right=" + ((right == null) ? " null" : right.start) + ", par=" + 
				((par == null) ? " null" : par.start) + ", childType="
				+ childType + "]";
	}
	
	
	
}
enum ChildType {
	LEFT, RIGHT;
	
}

class BST {
	BSTNode root;
	BSTNode min, max;
	public BST(BSTNode root) {
		super();
		this.root = root;
		this.min = root;
		this.max = root;
	}
	BSTNode insertNode(BSTNode x) {
		return root.insertNode(x);
		
	}
	
	BSTNode inOrderSuccessor(BSTNode t) {
		if(t == max) return null;
		if(t.right != null) {
			BSTNode curr = t.right;
			while(curr.left != null) {
				curr = curr.left;
			}
			return curr;
		}
		if(t.childType == ChildType.LEFT) {
			/*
			 * t's right child is null
			 * but t is somebody's left child
			 * in this case, the IOS is
			 * t's parent
			 */
			return t.par;
		}
		else {
			/*
			 * t's right child is null
			 * and t is somebody's right child
			 * in this case, the IOS is
			 * an ancestor who id just larger than t
			 * i.e. some ancestor in which left subtree
			 * you fall
			 * 
			 * Note: there cannot be a case that here t does
			 * not have a parent, because if that is the case then
			 * t is the root node, but that is also the maximum
			 * hence we would never come here
			 * 
			 * That is also the reason we don't need to check for
			 * curr != null in the while loop below
			 */
			BSTNode curr = t.par;
			while(curr.start < t.start) {
				curr = curr.par;
			}
			return curr;
		}
	}
	
	BSTNode inOrderPredecessor(BSTNode t) {
		if(t == min) return null;
		if(t.left != null) {
			BSTNode curr = t.left;
			while(curr.right != null) {
				curr = curr.right;
			}
			return curr;
		}
		if(t.childType == ChildType.RIGHT) {
			
			return t.par;
		}
		else {
			BSTNode curr = t.par;
			while(curr.start > t.start) {
				curr = curr.par;
			}
			return curr;
		}
	}
	
}

class MyCalendar {
	BST tree;	
	boolean isEmpty;
	public MyCalendar() {
		super();
		isEmpty = true;
	}

	public boolean book(int start, int end) {
		
		BSTNode booking = new BSTNode(start, end);
    	if(isEmpty) {
    		// can insert
    		this.tree = new BST(booking);
    		isEmpty = false;
    		return true;
    	}
    	else {
    		// calendar is not empty
    		BSTNode x = tree.insertNode(booking);
    		if(x == null) return false;
    		//System.out.println(x);
    		BSTNode y;
    		if(booking.start > x.start) {
    			// to be right child
    			if(booking.start >= x.end) {
    				y = tree.inOrderSuccessor(x);
    				if(y == null) {
    					insertBooking(tree, booking, x, ChildType.RIGHT);    					
        				return true;
    				}
        			if(booking.end <= y.start) {
        				// insert now
        				insertBooking(tree, booking, x, ChildType.RIGHT);   
        				return true;
        			}
        			return false;
    			}
    			return false;
    			
    		}
    		else {
    			// to be left child
    			if(booking.end <= x.start) {
    				y = tree.inOrderPredecessor(x);
    				if(y == null) {
    					insertBooking(tree, booking, x, ChildType.LEFT);
    					return true;
    				}
    				if(booking.start >= y.end) {
    					insertBooking(tree, booking, x, ChildType.LEFT);
    					return true;
    				}
    				return false;
    			}
    			return false;
    			
    		}
    	}
    	
    }

	private void insertBooking(BST tree, BSTNode booking, BSTNode x, ChildType ct) {
		if(ct == ChildType.RIGHT)
			x.right = booking;
		else
			x.left = booking;
		booking.par = x;
		booking.childType = ct;
		if(booking.start > tree.max.start) tree.max = booking;
		if(booking.start < tree.min.start) tree.min = booking;
	}
	
}
public class Solution {	

	public static void main(String[] args) {
		MyCalendar cal = new MyCalendar();
		System.out.println(cal.book(1, 5));
		System.out.println(cal.book(1, 7));
		System.out.println(cal.book(2, 3));
		System.out.println(cal.book(5, 7));
		System.out.println(cal.book(16, 20));
		System.out.println(cal.book(7, 16));

	}

}
