package partitionIntoKEqualSumSubsets;

public class Solution {

	
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int x : nums) sum += x;
        if(sum % k != 0) return false;
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
