package lruCache;

import java.util.HashMap;
import java.util.Map;

class LLNode {
	int key;
	int val;
	LLNode prev, next;
	public LLNode(int key, int val) {
		super();
		this.key = key;
		this.val = val;
	}
	@Override
	public String toString() {
		return String.valueOf(val);
	}
}

class DLL {
	LLNode start;
	LLNode end;
	int noOfNodes;
	
	LLNode insertEnd(int key, int x) {
		noOfNodes++;
		LLNode toBeIns = new LLNode(key, x);
		if(end == null) {
			start = toBeIns;
			end = toBeIns;
			return toBeIns;
		}
		
		/*
		 * start is not null
		 */
		end.next = toBeIns;
		toBeIns.prev = end;
		end = toBeIns;
		return toBeIns;
	}
	
	void deleteNode(LLNode toBeDel) {
		noOfNodes--;
		if(start == toBeDel && end == toBeDel) {
			start = null;
			end = null;
			return;
		}
		
		if(start == toBeDel) {
			start = toBeDel.next;
			start.prev = null;
			toBeDel.next = null;
			return;
		}
		
		if(end == toBeDel) {
			end = toBeDel.prev;
			end.next = null;
			toBeDel.prev = null;
			return;
		}
		
		/*
		 * middle node
		 */
		LLNode x = toBeDel.prev;
		LLNode y = toBeDel.next;
		x.next = y;
		y.prev = x;
		toBeDel.prev = null;
		toBeDel.next = null;
		
		return;
	}
	
	int deleteStart() {
		int u = start.key;
		deleteNode(start);
		return u;
	}
}

public class LRUCache {
	
	int capacity;
	DLL linkedList;
	Map<Integer, LLNode> map = new HashMap<>();
	
	public LRUCache(int capacity) {
        this.capacity = capacity;
        linkedList = new DLL();
    }
    
    public int get(int key) {
    	LLNode r = map.get(key);
    	if(r == null) return -1;
    	
    	linkedList.deleteNode(r);
		LLNode newNode = linkedList.insertEnd(key, r.val);
		map.put(key, newNode);
        return r.val;
    }
    
    public void put(int key, int value) {
    	
        /*
         * check if key exists
         */
    	LLNode r = map.get(key);
    	LLNode newNode;
    	if(r != null) {
    		linkedList.deleteNode(r);
    		newNode = linkedList.insertEnd(key, value);
    		map.put(key, newNode);
    		return;
    	}
    	
    	/*
    	 * map does not contain the key
    	 */
    	if(linkedList.noOfNodes == capacity) {
    		int u = linkedList.deleteStart();
    		map.remove(u);
    	}
    	newNode = linkedList.insertEnd(key, value);
    	map.put(key, newNode);
    }
    
    public static void main(String[] args) {
    	LRUCache lruCache = new LRUCache(5);
    	lruCache.put(9, 5);
    	lruCache.put(8, 6);
    	lruCache.put(7, 9);
    	lruCache.put(9, 10);
    	lruCache.put(1, 3);
    	lruCache.put(3, 6);
    	lruCache.put(8, 0);
    	lruCache.put(5, 16);
    	
    	System.out.println(lruCache.get(9));
    	System.out.println(lruCache.map);
    	System.out.println(lruCache.get(7));
    }
}
