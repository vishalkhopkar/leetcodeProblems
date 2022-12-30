package swapPairs;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode temp = this;
		while(temp != null) {
			sb.append(temp.val+"->");
			temp = temp.next;
		}
		return sb.toString();	
	}
	
	
}

public class Solution {

	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) return head;
        ListNode back = head;
        ListNode front = head.next;
        ListNode q = null;
        ListNode temp;
        
        while(front != null) {
        	temp = front.next;
        	front.next = back;
        	back.next = temp;
        	
        	if(q != null) {
        		q.next = front;
        	}
        	else {
        		head = front;
        	}
        	
        	q = back;
        	back = temp;
        	if(temp != null)
        		front = temp.next;
        	else
        		front = null;
        	
        	
        	
        }
        return head;
    }
	
	
	
	public static void main(String[] args) {		
		Solution s = new Solution();
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(2);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		System.out.println(s.swapPairs(n1));
	}

}
