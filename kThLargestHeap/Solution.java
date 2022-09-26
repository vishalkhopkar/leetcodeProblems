package kThLargestHeap;

import java.util.Arrays;

class Heap {
	
	int[] elems;
	int heapSize;
	int parent(int i) { return i/2 - 1;}
	int left(int i) { return i*2 + 1;}
	int right(int i) { return i*2 + 2;}
	
	boolean hasLeftChild(int i) { return left(i) < heapSize;}
	boolean hasRightChild(int i) { return right(i) < heapSize;}
	
	private void swap(int i, int largest) {
		int x = elems[i];
		elems[i] = elems[largest];
		elems[largest] = x;		
	}
	
	public Heap(int[] elems) {
		super();
		this.elems = elems;
		buildMaxHeap();
	}
	
	private void buildMaxHeap() {
		heapSize = elems.length;
		for(int i = heapSize/2; i >= 0; i--) {
			maxHeapify(i);
		}
		
	}
	private void maxHeapify(int i) {
		int rightVal = Integer.MIN_VALUE;
		int leftVal = Integer.MIN_VALUE;
		int largest;
		if(hasRightChild(i)) rightVal = elems[right(i)];
		if(hasLeftChild(i)) leftVal = elems[left(i)];
		
		if(elems[i] < rightVal || elems[i] < leftVal) {
			// does not satisfy heap property, so necessary to max heapify
			largest = (rightVal > leftVal) ? right(i) : left(i);
			
			// swap elems[i] with elems[largest]
			swap(i, largest);
			maxHeapify(largest);
		}
		
		
	}
	
	public int extractMaximum() {
		int ret = elems[0];
		elems[0] = elems[--heapSize];
		maxHeapify(0);
		return ret;
	}
	
	public int kthLargest(int k) {
		int ret = -1;
		for(int i = 0; i < k; i++) {
			ret = extractMaximum();
		}
		return ret;
	}
	
	
	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(elems, 0, heapSize)) + ", heapSize=" + heapSize;
	}	

}

public class Solution {
	public int findKthLargest(int[] nums, int k) {
		Heap h = new Heap(nums);
		return h.kthLargest(k);
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] elems = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		System.out.println(s.findKthLargest(elems, 10));

	}

}
