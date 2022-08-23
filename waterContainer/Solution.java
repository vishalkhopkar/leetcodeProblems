package waterContainer;

import java.util.Arrays;

public class Solution {
	private static int maxArea = Integer.MIN_VALUE;
	private static int maxAreaLeft = -1, maxAreaRight = -1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		maxArea(heights);
		System.out.println(maxArea);
			
	}
	public static int maxArea(int[] height) {
		/*
		 * Start from the two edges
		 * Find maxLeft and maxRight arrays
		 */
		int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = -1;
        maxRight[n - 1] = -1;
        /*
         * Find the max elem in the array
         */
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
        	if(height[i] >= max) {
        		max = height[i];
        	}
        }
        for(int i = 0; i < n; i++) {
        	if(height[i] == max) {
        		maxLeft[i] = -1;
        		maxRight[i] = -1;
        	}
        }
        // finding the maxLeft array
        for(int i = 1; i < n; i++) {
        	int j = i;
        	if(maxLeft[i] != -1) {
        		while(j >= 0 && height[j] <= height[i]) j--;
            	maxLeft[i] = j;
        	}        	
        }
        // finding the maxRight array
        for(int i = n - 1; i >= 0; i--) {
        	
        	int j = i;
        	if(maxRight[i] != -1) {
        		
        		while(j < n && height[j] <= height[i]) j++;
        		maxRight[i] = j;
        	}
        }
       
        maxAreaRecursive(0, n - 1, height, maxLeft, maxRight);
        return maxArea;
    }
	private static void maxAreaRecursive(int left, int right, int[] height, int[] maxLeft, int[] maxRight) {
		
		int area = min(height[left], height[right]) * (right - left);
		if(area > maxArea) {
			maxArea = area;
			maxAreaLeft = left;
			maxAreaRight = right;
		}
		if(maxRight[left] != -1) maxAreaRecursive(maxRight[left], right, height, maxLeft, maxRight);
		if(maxLeft[right] != -1) maxAreaRecursive(left, maxLeft[right], height, maxLeft, maxRight);
	}
	private static int min(int i, int j) {
		return (i < j) ? i : j;
	}
}
