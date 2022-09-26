package heapSample;

import java.util.Arrays;

public class Heap {
	
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
	
	
	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOfRange(elems, 0, heapSize)) + ", heapSize=" + heapSize;
	}
	public static void main(String[] args) {
		int[] elems = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
		Heap h = new Heap(elems);
		System.out.println(h);
		int max = h.extractMaximum();
		System.out.println(h);
	}

}
