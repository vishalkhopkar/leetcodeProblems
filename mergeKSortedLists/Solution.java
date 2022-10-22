package mergeKSortedLists;

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
	
	public ListNode mergeKLists(ListNode[] lists) {
		
		int k = lists.length;
		if(k == 0) return null;
        ListNode[] curr = new ListNode[k];
        for(int i = 0; i < k; i++)
        	curr[i] = lists[i];
        ListNode sorted = null;
        ListNode temp = null;
        boolean allListsCovered = false;
        int minIndex;
        while(!allListsCovered) {
        	minIndex = findMinimum(curr);
        	if(minIndex == -1) {
        		allListsCovered = true;
        		break;
        	}
        	if(sorted == null) {
        		sorted = curr[minIndex];
        		temp = sorted;
        	}
        	else {
        		temp.next = curr[minIndex];
        		temp = temp.next;
        	}
        	curr[minIndex] = curr[minIndex].next;
        }
        return sorted;
    }
	
	private int findMinimum(ListNode[] curr) {
		int min = Integer.MAX_VALUE;
		int ret = -1;
		ListNode x;
		for(int i = 0; i < curr.length; i++) {
			x = curr[i];
			if(x != null) {
				if(x.val < min) {
					min = x.val;
					ret = i;
				}
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		int[][] nums = {
				{2, 3, 5},
				{1, 7, 11},
				{}
		};
		ListNode[] lists = new ListNode[nums.length];
		ListNode[] temp = new ListNode[nums.length];
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++) {
				if(lists[i] == null) {
					lists[i] = new ListNode(nums[i][j]);
					temp[i] = lists[i];
				}
				else {
					ListNode nl = new ListNode(nums[i][j]);
					temp[i].next = nl;
					temp[i] = temp[i].next;
				}
			}
			
		}
		System.out.println();
		for(int i = 0; i < nums.length; i++) {
			ListNode temp1 = lists[i];
			while(temp1 != null) {
				System.out.print(temp1.val+"->");
				temp1 = temp1.next;
			}
			System.out.println();
		}
		
		Solution s = new Solution();
		System.out.println(s.mergeKLists(lists));
	}

}
