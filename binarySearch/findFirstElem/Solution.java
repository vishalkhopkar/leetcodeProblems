package binarySearch.findFirstElem;

public class Solution {

	public int findFirstPos(int[] arr, int key) {
		int start = 0, end = arr.length - 1;
		int mid = (start + end)/2;
		while(start != mid) {
			System.out.println("start = "+start+", mid = "+mid+", end = "+end);
			if(key <= arr[mid]) {
				end = mid;
			}
			else {
				start = mid + 1;
			}
			mid = (start + end)/2;
		}
		if(arr[start] == key) {
			return start;
		}
		else if(arr[end] == key) {
			return end;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {5, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 10};
		Solution s = new Solution();
		System.out.println(s.findFirstPos(arr, 7));

	}

}
