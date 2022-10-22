package quicksort;

import java.util.Arrays;

public class Main {

	private static int partition(int[] arr, int start, int end) {
		int x = arr[end];
		int i = start - 1;
		for(int j = start; j < end; j++) {
			if(arr[j] < x){
				i++;
				
				// exchange A[i] with A[j]
				swap(arr, i, j);
				
			}
		}
		swap(arr, i + 1, end);
		return i + 1;
	}
	
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;		
	}

	private static void quicksort(int[] arr, int start, int end) {
		if(start < end) {
			int partition = partition(arr, start, end);
			System.out.println("partitioned elem "+arr[partition]);
			// the elem at partition is now sorted
			quicksort(arr, start, partition - 1);
			quicksort(arr, partition + 1, end);
		}
	}
	public static void main(String[] args) {
		int[] arr = {1, 5, 7, 8, 4, 0, -2, -5};
		quicksort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

}
