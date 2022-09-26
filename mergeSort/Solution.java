package mergeSort;

import java.util.Arrays;

public class Solution {
	
	void merge(int[] arr, int l, int mid, int r){
	    //console.log("merge "+l+" "+mid+" "+r);
	    int[] n1 = new int[(mid - l + 1) + 1];
	    int[] n2 = new int [(r - (mid + 1) + 1 + 1)];
	    // create n1 of length (mid - l + 1) + 1 for pivot
	    // similarly, create n2 of length (r - (mid + 1) + 1 + 1) for pivot
	    int n1Len = n1.length;
	    int n2Len = n2.length;
	    for(int i = l, c1 = 0; i <= mid; i++, c1++){
	        n1[c1] = arr[i];
	    }
	    for(int i = mid + 1, c1 = 0; i <= r; i++, c1++){
	        n2[c1] = arr[i];
	    }
	    n1[n1Len - 1] = Integer.MAX_VALUE;
	    n2[n2Len - 1] = Integer.MAX_VALUE;
	    //console.log(n1);
	    //console.log(n2);
	    int k = l;
	    int i = 0, j = 0;
	    while(k <= r){
	        if(n1[i] < n2[j]){
	            // the number in n1 is smaller than n2
	            arr[k] = n1[i];
	            i++;
	        }
	        else {
	            arr[k] = n2[j];
	            j++;
	        }
	        k++;
	    }
	    //console.log(arr);
	}
	
	void mergesort(int[] arr, int l, int r) {
		if(l < r) {
	        
	        int mid = ((l + r)/2);
	        mergesort(arr, l, mid);
	        mergesort(arr, mid + 1, r);
	        merge(arr, l, mid, r);
	    }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = {3, -1, -2, 0, 5, 9, 4};
		s.mergesort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}

}
