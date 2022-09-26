package circularQueue;

class MyCircularQueue {
	
	int maxCapacity;
	int currentCapacity;
	int[] arr;
	int front, back;
	
    public MyCircularQueue(int k) {
        currentCapacity = 0;
        maxCapacity = k;
        arr = new int[k];
        front = -1;
        back = -1;
    }
    
    public boolean enQueue(int value) {
        // add an element to the back of the queue
    	if(currentCapacity == 0) {
    		// queue is empty
    		arr[currentCapacity++] = value;
    		front = 0;
    		back = 0;
    		return true;
    	}
    	if(currentCapacity == maxCapacity) {
    		// cannot add anymore elements
    		return false;
    	}
    	
		/*
		 * the queue has not yet become circular
		 * if front <= back
		 * the queue has become circular
		 * if front > back
		 * either way, same code will do
		 */
		arr[(back + 1) % arr.length] = value;
		back++;
		back %= arr.length;
		currentCapacity++;
		return true;
    	
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        if(currentCapacity == 1) {
        	// only 1 element
        	front = -1;
        	back = -1;
        	currentCapacity = 0;
        	return true;
        }
        
        front++;
        front %= arr.length;
        currentCapacity--;
        return true;
    }
    
    public int Front() {
    	if(isEmpty()) return -1;
        return arr[front];
    }
    
    public int Rear() {
    	if(isEmpty()) return -1;
        return arr[back];
    }
    
    public boolean isEmpty() {
        return currentCapacity == 0;
    }
    
    public boolean isFull() {
        return currentCapacity == maxCapacity;
    }

	@Override
	public String toString() {
		if(currentCapacity == 1) {
			return String.valueOf(arr[front]);
		}
		StringBuilder sb = new StringBuilder();
		int c = front;
		while(c != back) {
			sb.append(arr[c]+",");
			c++;
			c %= arr.length;
		}
		sb.append(arr[c]);
		return sb.toString();
	}
    
    
}


public class Solution {

	public static void main(String[] args) {
		MyCircularQueue queue = new MyCircularQueue(7);
		queue.enQueue(12);
		queue.enQueue(0);
		queue.enQueue(7);
		queue.enQueue(1);
		queue.enQueue(4);
		queue.enQueue(3);
		queue.enQueue(5);
		queue.deQueue();
		queue.enQueue(65);
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.enQueue(78);
		System.out.println(queue);
		System.out.println(-1%7);
	}

}
