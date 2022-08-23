package vishal;

import java.util.Arrays;
import java.util.Scanner;

public class SortingIntegers {
	private static final int N = 10;
	
	private static void merge(int[] arr, int start, int mid, int end) {
		//arrays from start to mid and mid + 1 to end are already sorted
		int leftLen = mid - start + 1;
		int rightLen = end - (mid + 1) + 1;
		// move arr[start...mid] and arr[mid + 1...end] into two new arrays
		int[] leftCopy = new int[leftLen + 1];
		int[] rightCopy = new int[rightLen + 1];
		for(int i1 = 0, i = start; i1 < leftLen && i <= mid; i1++, i++) {
			leftCopy[i1] = arr[i];
		}
		for(int i2 = 0, j = mid + 1; i2 < rightLen && j <= end; i2++, j++) {
			rightCopy[i2] = arr[j];
		}
		leftCopy[leftLen] = Integer.MAX_VALUE;
		rightCopy[rightLen] = Integer.MAX_VALUE;
		int k = 0, k1 = 0, k2 = 0;
		while(k < leftLen + rightLen) {
			if(leftCopy[k1] < rightCopy[k2]) {
				arr[start + k] = leftCopy[k1];
				k1++;
			}
			else {
				arr[start + k] = rightCopy[k2];
				k2++;
			}
			k++;
		}
	}
	
	private static void mergesort(int[] arr, int start, int end) {
		if(start < end) {
			int mid = (start + end)/2;
			mergesort(arr, start, mid);
			mergesort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}
	}
	public static void main(String[] args) {
		//int[] input = {2, -3, 6, 0, -9, 1 , 7, 8, -2, 4};
		
		int[] input = new int[N];
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 10; i++) {
			System.out.println("Enter the "+(i + 1)+"th integer.");
			input[i] = sc.nextInt();
		}
		
		mergesort(input, 0, N - 1);
		System.out.println(Arrays.toString(input));
		
	}
}
