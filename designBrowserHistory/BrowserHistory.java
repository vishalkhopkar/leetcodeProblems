package designBrowserHistory;

class LLNode {
	String val;
	LLNode next, prev;
	LLNode(String val){
		this.val = val;
	}
}
class DoublyLinkedList {
	LLNode head;
	void insertFront(String val) {
		LLNode toBeInserted = new LLNode(val);
		if(head == null) {
			head = toBeInserted;
			return;
		}
		head.prev = toBeInserted;
		toBeInserted.next = head;
		head = toBeInserted;
	}
}
public class BrowserHistory {
	
	DoublyLinkedList dll;
	public BrowserHistory(String homepage) {
        dll = new DoublyLinkedList();
        dll.insertFront(homepage);
    }
    
    public void visit(String url) {
        dll.insertFront(url);
    }
    
    public String back(int steps) {
        
        int x = 0;
        while(dll.head.next != null && x < steps) {
        	dll.head = dll.head.next;
        	x++;
        }
        return dll.head.val;
    }
    
    public String forward(int steps) {
    	int x = 0;
        while(dll.head.prev != null && x < steps) {
        	dll.head = dll.head.prev;
        	x++;
        }
        return dll.head.val;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
