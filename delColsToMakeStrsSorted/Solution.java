package delColsToMakeStrsSorted;

public class Solution {

	public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int ret = 0;
        for(int i = 0; i < n; i++){
            for(int j = 1; j < strs.length; j++){
                if(strs[j].charAt(i) < strs[j - 1].charAt(i)){
                    ret++;
                    break;
                }
            }
        }
        return ret;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] strs = {"cba","daf","ghi"};
		System.out.println(s.minDeletionSize(strs));
	}

}
