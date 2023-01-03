package minIncrementToMakeArrUnique.try2;



public class Solution {

	public int minIncrementForUnique(int[] nums) {
		final int LENGTH = 100000;
        int[] treeMap = new int[LENGTH + 1];
        for(int i = 0; i < nums.length; i++) {
        	inc(treeMap, nums[i]);
        }
        
        System.out.println(treeMap);
        
        
        int ret = 0, count;
        for(int key = 0; key <= LENGTH; key++) {
        	count = treeMap[key];
        	if(count > 1) {
        		for(int i = 1; i <= count - 1; i++) {
        			System.out.println("key "+key);
        			inc(treeMap, key + i);
        			System.out.println(treeMap);
        			ret += i;
        		}
        	}
        }
        
        return ret;
    }

	private void inc(int[] treeMap, int key) {
		treeMap[key]++;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {3,2,1,2,1,7};
		System.out.println(s.minIncrementForUnique(nums));

	}

}
