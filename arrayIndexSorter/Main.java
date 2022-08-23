package arrayIndexSorter;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	int arr[] = {3, 4, 1, 2, 3, 0, 5};
	class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			
			return arr[o1] - arr[o2];
		}
		
	}
	
	Integer[] indexSort() {
		Integer[] indexArr = new Integer[arr.length];
		for(int i = 0; i < arr.length; i++) indexArr[i] = i;
		Arrays.sort(indexArr, new MyComparator());
		return indexArr;
	}
	public static void main(String[] args) {
		// make an index arr
		Main m = new Main();
		System.out.println(Arrays.toString(m.indexSort()));
		

	}

}
