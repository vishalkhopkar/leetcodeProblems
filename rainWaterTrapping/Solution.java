package rainWaterTrapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	List<Integer> maximas = new ArrayList<Integer>();
	int[][] dpMatrix;
	public static void main(String[] args) {
		//int[] arr = {2, 3, 2, 1, 1, 2, 3, 1, 0};
		//int[] arr = {4, 2, 1, 0, 1, 2, 5, 2, 1, 0, 1, 2, 4};
		int[] arr = {6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
		
		Solution s = new Solution();
		System.out.println(s.trap(arr));
	}

	public int trap(int[] arr) {
		// Find the maximas
		findMaximas2(arr, 0, arr.length - 1);
		int ret = 0;
		System.out.println(maximas);
		int noOfMaximas = maximas.size();
		int minHeight = 0, area1, area2, start, end;
		dpMatrix = new int[noOfMaximas][noOfMaximas];
		
		for(int i = 0; i < noOfMaximas - 1; i++) {
			dpMatrix[i][i + 1] = maxAreaInternal(arr, maximas.get(i), maximas.get(i + 1));
			System.out.println(dpMatrix[i][i + 1]);
		}
		
		// now fill the other elems in the dpMatrix
		int initIncrease = 2;
		int i = 0, j = (i + initIncrease);
		int maxCtr = (noOfMaximas - 2)*(noOfMaximas - 2 + 1)/2;
		int tallestMaxima = -1, k = -1;
		for(int c = 0; c < maxCtr; c++) {
			start = maximas.get(i);
			end = maximas.get(j);
			System.out.printf("start %d end %d\n", start, end);
			minHeight = Math.min(arr[start], arr[end]);
			// how to partition the start, end
			/*
			 * If there are multiple maximas between start, end
			 * say start, max1, max2,... end
			 * partition on the tallest maxi indexed by k
			 */
			
			tallestMaxima = Integer.MIN_VALUE;
			k = -1;
			for(int y = i + 1; y < j; y++) {
				if(arr[maximas.get(y)] > tallestMaxima) {					
					tallestMaxima = arr[maximas.get(y)];
					k = y;
				}
			}
			
			// split on tallestMaxima
			System.out.println("tallestMaxima "+tallestMaxima+ " k = "+k+" maxima to be partitioned = "+maximas.get(k));
			area1 = dpMatrix[i][k];
			area2 = dpMatrix[k][j];
			if(arr[maximas.get(k)] >= minHeight) {
				dpMatrix[i][j] = area1 + area2;
			}
			else {
				dpMatrix[i][j] = maxAreaInternal(arr, start, end);
			}
			
			// try to partition on every maxima
			/*
			int tempArea, maxArea = 0;
			for(int y = i + 1; y < j; y++) {
				// partition on y
				area1 = dpMatrix[i][y];
				area2 = dpMatrix[y][j];
				if(arr[maximas.get(y)] >= minHeight) {
					tempArea = area1 + area2;
				}
				else {
					tempArea = area1 + area2 + (end - start - 1)*(minHeight - arr[maximas.get(y)]);
				}
				if(tempArea > maxArea) maxArea = tempArea;
			}
			dpMatrix[i][j] = maxArea;
			*/
			if(j == noOfMaximas - 1) {
				i = 0;
				initIncrease++;
				j = (i + initIncrease);
			}
			else {
				i++;
				j++;
			}
		}
		/*
		for(int i = 0; i < dpMatrix.length - 2; i++) {
			for(int j = i + 2; j < dpMatrix.length; j++) {
				
			}
		}
		*/
		for(int i1 = 0; i1 < dpMatrix.length; i1++)
			System.out.println(Arrays.toString(dpMatrix[i1]));
		return dpMatrix[0][dpMatrix.length - 1];
	}
	
	private int maxAreaInternal(int[] arr, Integer s, Integer e) {
		int minHeight = Math.min(arr[s], arr[e]);
		int maxArea = (e - s - 1)* minHeight;
		for(int i = s + 1; i < e ; i++) {
			maxArea -= Math.min(minHeight, arr[i]);
		}
		return maxArea;
	}

	private void findMaximas2(int[] arr, int s, int e) {
		if(s > e) return;
		int c = s;
		while(c < e && arr[c] < arr[c + 1]) {
			c++;
		}
		System.out.println("maxima "+c);
		maximas.add(c);
		findMinimas2(arr, c + 1, e);
	}
	private void findMinimas2(int[] arr, int s, int e) {
		if(s > e) return;
		int c = s;
		while(c < e && arr[c] > arr[c + 1]) c++;
		System.out.println("minima "+c);
		findMaximas2(arr, c + 1, e);
	}

}
