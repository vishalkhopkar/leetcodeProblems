package removeNthNode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;
        while(temp != null) {
        	temp = temp.next;
        	len++;
        }
        
        // nth node from the end and (len - n + 1) from the start
        int nodeToBeDel = len - n + 1;
        temp = head;
        ListNode q = null;
        len = 1;
        while(len < nodeToBeDel) {
        	q = temp;
        	temp = temp.next;
        	len++;
        }
        
        /*
         * 3 cases:
         * 1. node to be deleted is a start (head) node
         * 2. node to be deleted is a middle node
         * 3. node to be deleted is the end node
         */
        if(temp == head) {
        	// delete the head node
        	head = head.next;
        	return head;
        }
        
        // last node
        q.next = temp.next;
        return head;
    }

	public static void main(String[] args) {
		

	}

}
