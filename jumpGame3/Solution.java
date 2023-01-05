package jumpGame3;

public class Solution {
	
	Boolean[] dpTable;
	boolean[] visited;
	private boolean canReachHere(int pos, int[] arr, int start) {
		if(pos == start) {
			return true;
		}
		if(visited[pos]) return false;
		visited[pos] = true;
		System.out.println("can reach("+pos+")");
		
		if(dpTable[pos] != null) {
			System.out.println("here");
			return dpTable[pos];
		}
		boolean ret = false;
		boolean y;
		for(int i = 0; i < arr.length; i++) {
			if(i != pos && (i + arr[i] == pos || i - arr[i] == pos)) {
				y = canReachHere(i, arr, start);
				ret |= y;
				if(ret == true) break;
			}
		}
		//System.out.println("here");
		dpTable[pos] = ret;
		return ret;
		
	}
	
	public boolean canReach(int[] arr, int start) {
        dpTable = new Boolean[arr.length];
        visited = new boolean[arr.length];
        dpTable[start] = true;
        visited[start] = true;
        boolean ret = false;
        for(int i = 0; i < arr.length; i++) {
        	if(arr[i] == 0) {
        		ret |= canReachHere(i, arr, start);
        		if(ret == true) return ret;
        	}
        }
        return ret;
    }

	public static void main(String[] args) {
		
		Solution s = new Solution();
		int[] nums = {4,2,3,0,3,1,2};
		//int[] nums = {312,267,59,7,236,124,240,318,148,194,179,132,279,106,273,31,272,63,52,286,274,62,23,41,90,148,208,31,42,58,98,308,74,231,4,94,100,110,109,83,1,185,257,12,119,23,319,72,85,58,121,209,74,106,177,26,36,191,145,156,24,110,241,14,41,266,23,44,255,109,58,58,9,16,208,227,58,23,8,280,0,305,131,51,128,156,82,190,27,51,275,174,172,77,260,283,211,46,278,142,274,312,44,224,50,60,26,25,36,19,72,102,212,155,272,286,112,145,41,269,36,316,135,262,157,230,253,314,139,220,216,126,15,187,54,87,316,77,257,77,232,85,318,3,309,6,212,193,167,263,243,308,295,145,8,6,0,43,67,126,248,102,53,43,140,51,98,66,154,69,172,74,274,65,53,300,202,244,115,26,232,112,281,281,258,243,294,111,153,106,188,148,14,317,247,270,87,201,291,143,72,138,226,192,87,302,319,14,228,152,219,208,291,214,220,199,88,274,313,193,98,97,38,238,268,293,165,119,198,39,145,52,63,198,11,107,313,207,284,232,201,128,40,121,202,50,261,146,230,147,129,223,271,236,122,177,165,119,177,10,128,258,61,246,164,153,27,19,136,277,200,207,91,293,41,171,135,0,162,152,116,262,55,196,230,257,188,169,137,245,110,257,180,26,206,209,276,163,243,14,61,169,309,231,235,320,270,54,132,70,110,0,227,277,2,36,64,13,285,24,2};
		System.out.println(s.canReach(nums, 5));
		
	}

}
