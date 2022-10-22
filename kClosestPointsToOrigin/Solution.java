package kClosestPointsToOrigin;


public class Solution {
	
	public int[][] kClosest(int[][] points, int k) {
        double[] distances = new double[points.length];
        for(int i = 0; i < points.length; i++) {
        	distances[i] = Math.sqrt(points[i][0]*points[i][0] + 
        			points[i][1]*points[i][1]);        	
        }
        int[][] pointsRet = new int[k][2];
        for(int i = 0; i < k; i++) {
        	quicksort(distances, 0, distances.length - 1, pointsRet, 0, points);
        }
        return pointsRet;
    }
	
	private void quicksort(double[] arr, int start, int end, int[][] points, int c, int[][] orgPoints) {
		if(start < end) {
			int partition = partition(arr, start, end);
			System.out.println("partitioned elem "+arr[partition]);
			points[c][0] = orgPoints[partition][0];
			points[c][1] = orgPoints[partition][1];
			// the elem at partition is now sorted
			quicksort(arr, start, partition - 1, points, c + 1, orgPoints);
			quicksort(arr, partition + 1, end, points, c + 1, orgPoints);
		}
	}
	
	private static int partition(double[] arr, int start, int end) {
		double x = arr[end];
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
	
	private static void swap(double[] arr, int i, int j) {
		double temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;		
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		double[] distances = {3, 2, 4, 1, 0, 5, 7, 9};
		

	}

}
