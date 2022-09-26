package middleQueue;

class LLNode {
	int value;
	LLNode next;
	LLNode prev;
	public LLNode(int value) {
		super();
		this.value = value;
	}
	
	
}
class FrontMiddleBackQueue {
	LLNode start, middle, end;
	int noOfElems;
	
    public FrontMiddleBackQueue() {
        
    }
    
    public void pushFront(int val) {
        if(start == null) {
        	start = new LLNode(val);
        	middle = start;
        	end = start;
        	noOfElems = 1;
        	return;
        }
        
        // start is not null, noOfElems > 0
        LLNode newNode = new LLNode(val);
        start.prev = newNode;
        newNode.next = start;
        start = newNode;
        noOfElems++;
        
        if(noOfElems % 2 == 0) {
        	// if we have even number of elements now,
        	// move the middle backwards
        	middle = middle.prev;
        }
    }
    
    public void pushMiddle(int val) {
    	if(start == null) {
        	pushFront(val);
        	return;
        }
    	if(noOfElems == 1) {
    		pushFront(val);
    		return;
    	}
    	LLNode newNode = new LLNode(val);
    	
    	// insert before the middle in case of odd
    	// insert after the middle in case of even
    	LLNode temp;
    	if(noOfElems % 2 == 0) {
    		temp = middle.next;
    		middle.next = newNode;
    		newNode.next = temp;
    		newNode.prev = middle;
    		if(temp != null) temp.prev = newNode;
    		
    	}
    	else {
    		temp = middle.prev;
    		middle.prev = newNode;
    		newNode.prev = temp;
    		newNode.next = middle;
    		if(temp != null) temp.next = newNode;
    	}
    	noOfElems++;
    	middle = newNode;
    }
    
    public void pushBack(int val) {
    	if(start == null) {
        	pushFront(val);
        	return;
        }
        
        // start is not null, noOfElems > 0
        LLNode newNode = new LLNode(val);
        end.next = newNode;
        newNode.prev = end;
        end = newNode;
        noOfElems++;
        
        if(noOfElems % 2 == 1) {
        	// now we have odd no of elems
        	// earlier we had even
        	middle = middle.next;
        }
    }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		LLNode temp = start;
		while(temp != null) {
			sb.append(temp.value+",");
			temp = temp.next;
		}
		sb.append("start = "+((start == null) ? "NaN" : start.value)+", middle = "+((middle == null) ? "NaN" : middle.value)+", end = "+((end == null) ? "NaN" : end.value)+" noOfElems = "+noOfElems);
		return sb.toString();
	}
    
    
    public int popFront() {
    	if(noOfElems == 0) return -1;
    	int ret = start.value;
        if(noOfElems == 1) {
        	start = null;
        	middle = null;
        	end = null;
        	noOfElems = 0;
        	return ret;
        }
        
        start = start.next;
        if(start != null) start.prev = null;
        noOfElems--;
        if(noOfElems % 2 == 1) {
        	// if we had even number of elems
        	// now we have odd
        	// mid will shift rightwards
        	middle = middle.next;
        }
        return ret;
       
    }
    
    public int popMiddle() {
        if(noOfElems <= 1) return popFront();
        
        int ret = middle.value;
        LLNode midPrev = middle.prev;
        LLNode midNext = middle.next;
        
        
        if(midPrev != null) midPrev.next = midNext;
        if(midNext != null) midNext.prev = midPrev;
        if(middle == start) start = start.next;
        if(noOfElems % 2 == 0) {
        	// even
        	// shift the mid right
        	middle = midNext;
        }
        else {
        	// odd
        	// shift the mid left
        	middle = midPrev;
        }
        noOfElems--;
        return ret;
    }
    
    public int popBack() {
    	if(noOfElems <= 1) return popFront();
    	
    	int ret = end.value;
    	
    	end = end.prev;
    	if(end != null) end.next = null;
    	noOfElems--;
    	
    	// middle will remain as it is if we had
    	// even number of elements
    	if(noOfElems % 2 == 0) {
    		// now if we have even
    		// shift the middle left
    		middle = middle.prev;
    	}
    	return ret;
    }   
    
    
}

public class Solution {

	public static void main(String[] args) {
		/*
		 * ["FrontMiddleBackQueue","pushFront","pushBack","pushMiddle","pushMiddle",
		 * "popFront","popMiddle","popMiddle","popBack","popFront"]
			[[],[1],[2],[3],[4],[],[],[],[],[]]
		 */
		FrontMiddleBackQueue queue = new FrontMiddleBackQueue();
		queue.pushFront(1);
		queue.pushBack(2);
		queue.pushMiddle(3);
		queue.pushMiddle(4);
		
		queue.popFront();
		queue.popMiddle();
		System.out.println(queue);
		queue.popMiddle();
		System.out.println(queue);
		System.out.println("*************************");
		
		/*
		 * ["FrontMiddleBackQueue","popMiddle","popMiddle","pushMiddle","popBack","popFront","popMiddle"]
			[[],[],[],[8],[],[],[]]
		 */
		queue = new FrontMiddleBackQueue();
		queue.popMiddle();
		System.out.println(queue);
		queue.popMiddle();
		System.out.println(queue);
		queue.pushMiddle(8);
		System.out.println(queue);
		queue.popBack();
		System.out.println(queue);
		
		
		System.out.println("*******************************************");
		
		queue = new FrontMiddleBackQueue();
		
		/*
		String[] calls = {"FrontMiddleBackQueue","pushFront","pushMiddle","pushMiddle","pushFront","pushFront","pushMiddle",
		 "popMiddle","popMiddle","pushMiddle","pushMiddle","popFront"};
		 
		 
			[[],[8],[7],[3],[4],[6],[5],[],[],[1],[2],[]]
		*/
		
		queue = new FrontMiddleBackQueue();
		queue.pushFront(8);
		System.out.println(queue);
		queue.pushMiddle(7);
		System.out.println(queue);
		queue.pushMiddle(3);
		queue.pushFront(4);
		System.out.println(queue);
		
		
	}

}
