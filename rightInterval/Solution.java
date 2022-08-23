package rightInterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Interval implements Comparable<Interval>{
	int start, end, index;

	public Interval(int start, int end, int index) {
		super();
		this.start = start;
		this.end = end;
		this.index = index;
	}

	@Override
	public int compareTo(Interval o) {		
		return this.start - o.start;
	}

	@Override
	public String toString() {
		return "[" + start + ", " + end + ", index=" + index + "]";
	}
	
	
}

public class Solution {
	public int[] findRightInterval(int[][] intervals) {
		List<Interval> intervalList = new ArrayList<>(intervals.length);
		for(int i = 0; i < intervals.length; i++) {
			intervalList.add(new Interval(intervals[i][0], intervals[i][1], i));
		}
		Collections.sort(intervalList);
		System.out.println(intervalList);
		int[] ret = new int[intervals.length];
		int ctr = 0;
		for(Interval interval : intervalList) {
			if(ctr == intervals.length - 1) {
				ret[interval.index] = -1;
			}
			else {
				Interval firstRight = binarySearch(interval.end, ctr, intervalList);
				System.out.println("BS res "+firstRight);
				ret[interval.index] = (firstRight.start >= interval.end) ? firstRight.index : -1;
				ctr++;
			}
			
		}
		return ret;
	}
	private Interval binarySearch(int val, int start, List<Interval> intervalList) {
		System.out.println("BS "+val);
		// remember that intervalList is sorted
		int end = intervalList.size() - 1;
		int mid;
		while(start != end) {			
			mid = (start + end)/2;
			System.out.println("start = "+start+", mid = "+mid+", end = "+end);
			if(intervalList.get(mid).start == val) {
				return intervalList.get(mid);
			}
			else if(intervalList.get(mid).start > val) {
				end = mid;
			}
			else start = mid + 1;
		}
		return intervalList.get(start);
	}
	public static void main(String[] args) {
		int[][] intervals = {{3,4}, {2, 3}, {1, 2}};
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.findRightInterval(intervals)));

	}

}
