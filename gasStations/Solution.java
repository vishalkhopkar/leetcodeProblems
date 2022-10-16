package gasStations;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	
	int[] arr;
	class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			
			return (arr[o2] - arr[o1]);
		}
		
	}
	
	Integer[] indexSort() {
		Integer[] indexArr = new Integer[arr.length];
		for(int i = 0; i < arr.length; i++) indexArr[i] = i;
		Arrays.sort(indexArr, new MyComparator());
		return indexArr;
	}
	
	private boolean canCompleteCircuit(int[] gas, int[] cost, int maxGasIndex) {
		int currInd = maxGasIndex;
		int tankCapacity = 0;
		boolean cycleComplete = false;
		while(!cycleComplete) {
			tankCapacity += gas[currInd];
			tankCapacity -= cost[currInd];
			if(tankCapacity < 0) return false;
			currInd += 1;
			currInd %= gas.length;
			if(currInd == maxGasIndex) {
				// cycle complete
				cycleComplete = true;
				
			}
		}
		return true;
	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
        // start from the station with the maximum gas
		arr = new int[gas.length];
		double maxGasCostRatio = ((double)gas[0])/cost[0];
		int maxDifference = gas[0] - cost[0], diff;
		double ratio;
		int maxGasIndex = 0;
		for(int i = 1; i < gas.length; i++) {
			/*
			ratio = ((double)gas[i])/cost[i];
			if(ratio > maxGasCostRatio) {
				maxGasCostRatio = ratio;
				maxGasIndex = i;
			}
			*/
			diff = gas[i] - cost[i];
			arr[i] = diff;
			if(diff > maxDifference) {
				maxDifference = diff;
				maxGasIndex = i;
			}
			
		}
		Integer[] sortedIndices = indexSort();
		System.out.println("max ratio index "+maxGasIndex);
		System.out.println(Arrays.toString(sortedIndices));
		boolean canComplete;
		for(int i = 0; i < gas.length; i++) {
			if(arr[sortedIndices[i]] >= 0) {
				canComplete = canCompleteCircuit(gas, cost, sortedIndices[i]);
				if(canComplete) return sortedIndices[i];
			}
		}
		return -1;
		// try to start the circuit from maxGasIndex
		// travel clockwise to (maxGasIndex + 1)%gas.length
		
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] gas = {2,3,4};
		int[] cost = {3,4,3};
		System.out.println(s.canCompleteCircuit(gas, cost));

	}

}
