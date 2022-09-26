package circularDequeue;

class MyCircularDeque {

	int maxCapacity;
	int currentCapacity;
	int[] arr;
	int front, back;
	
    public MyCircularDeque(int k) {
    	currentCapacity = 0;
        maxCapacity = k;
        arr = new int[k];
        front = -1;
        back = -1;
    }
    
    public boolean insertFront(int value) {
        if(currentCapacity == 0) {
        	return insertLast(value);
        }
        if(currentCapacity == maxCapacity) {
    		// cannot add anymore elements
    		return false;
    	}
        
        if(front == 0) {
        	arr[arr.length - 1] = value;
        	front = arr.length - 1;
        	currentCapacity++;
        	return true;
        }
        
        arr[--front] = value;
        currentCapacity++;
        return true;
    }
    
    public boolean insertLast(int value) {
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
    
    public boolean deleteFront() {
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
    
    public boolean deleteLast() {
    	if(isEmpty()) return false;
        if(currentCapacity == 1) {
        	return deleteFront();
        }
        
        if(back == 0) {
        	back = arr.length - 1;
        	currentCapacity--;
        	return true;
        }
        
        back--;
        currentCapacity--;
        return true;
    }
    
    public int getFront() {
    	if(isEmpty()) return -1;
        return arr[front];
    }
    
    public int getRear() {
    	if(isEmpty()) return -1;
    	return arr[back];
    }
    
    public boolean isEmpty() {
    	return currentCapacity == 0;
    }
    
    public boolean isFull() {
    	return currentCapacity == maxCapacity;
    }
}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
