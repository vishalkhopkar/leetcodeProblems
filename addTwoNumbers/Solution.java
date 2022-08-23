package addTwoNumbers;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, res;
        int list1Len = 0, list2Len = 0;
        ListNode ret = new ListNode(), x = ret, y;
        ListNode temp1 = l1, q1 = null;
        while(temp1 != null) {
        	q1 = temp1;
        	temp1 = temp1.next;
        	list1Len++;
        }
        ListNode temp2 = l2, q2 = null;
        while(temp2 != null) {
        	q2 = temp2;
        	temp2 = temp2.next;
        	list2Len++;
        }
        if(list1Len < list2Len) {
        	// 2nd list is longer, append a few zeroes to the first list
        	addZeroes(q1, list2Len - list1Len);
        }
        else if(list2Len < list1Len) {
        	addZeroes(q2, list1Len - list2Len);
        }
        ListNode v1 = l2;
        while(v1 != null) {
			System.out.print(v1.val+ " ");
			v1 = v1.next;
		}
        System.out.println();
        temp1 = l1;
        temp2 = l2;
        while(temp1 != null) {
        	// doesn't matter as both the linked lists are of the same length now
        	res = temp1.val + temp2.val + carry;
        	x.val = (res) % 10;
        	carry = (res) / 10;
        	if(temp1.next != null || carry == 1) {
        		if(temp1.next == null)
        			x.next = new ListNode(carry);
        		else
        			x.next = new ListNode();
        	}        		        	
        	x = x.next;
        	temp1 = temp1.next;
        	temp2 = temp2.next;
        }
        
        return ret;
    }
	private void addZeroes(ListNode q, int numZeroes) {
		for(int i = 0; i < numZeroes; i++) {
			q.next = new ListNode(0);
			q = q.next;
		}
		
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] num1 = {9,9,9,9,9,9,9};
		int[] num2 = {9,9,9,9};
		ListNode[] l1 = new ListNode[num1.length];
		ListNode[] l2 = new ListNode[num2.length];
		for(int i = 0; i < num1.length; i++) {
			l1[i] = new ListNode(num1[i]);
		}
		for(int i = 0; i < num2.length; i++) {
			l2[i] = new ListNode(num2[i]);
		}
		for(int i = 0; i < num1.length - 1; i++) {
			l1[i].next = l1[i + 1];
		}
		for(int i = 0; i < num2.length - 1; i++) {
			l2[i].next = l2[i + 1];
		}
		
		ListNode ret = s.addTwoNumbers(l1[0], l2[0]);
		while(ret != null) {
			System.out.print(ret.val+ " ");
			ret = ret.next;
		}
	}

}
