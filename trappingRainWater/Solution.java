package trappingRainWater;

import java.util.Arrays;

public class Solution {

	public int trap(int[] arr) {
		/*
		 * Find maxLeft, maxRight
		 */
		int[] maxLeft = new int[arr.length];
		int[] maxRight = new int[arr.length];
		int max = arr[0];
		maxLeft[0] = arr[0];
		maxRight[arr.length - 1] = arr[arr.length - 1];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > max) max = arr[i];
			maxLeft[i] = max;
		}
		max = arr[arr.length - 1];
		for(int i = arr.length - 2; i >= 0; i--) {
			if(arr[i] > max) max = arr[i];
			maxRight[i] = max;
		}
		System.out.println(Arrays.toString(maxLeft));
		System.out.println(Arrays.toString(maxRight));
		int water = 0;
		for(int i = 0; i < arr.length; i++) {
			water += Math.min(maxLeft[i], maxRight[i]) - arr[i];
		}
		return water;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
