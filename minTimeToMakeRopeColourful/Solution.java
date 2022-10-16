package minTimeToMakeRopeColourful;

import java.util.ArrayList;
import java.util.List;

class Group {
	int startIndex;
	int endIndex;
	int totalCost;
	int maxTime;
	
	public Group(int startIndex) {
		super();
		this.startIndex = startIndex;
		endIndex = 0;
		totalCost = 0;
	}

	@Override
	public String toString() {
		return "[[" + startIndex + ", " + endIndex + "], totalCost=" + totalCost + ", maxTime = "+maxTime+"]";
	}
	
	
}

public class Solution {
	
	public int minCost(String colors, int[] neededTime) {
        List<Group> groups = new ArrayList<>();
        Group currGroup = null;
        for(int i = 1; i < colors.length(); i++) {
        	if(colors.charAt(i) == colors.charAt(i - 1)) {
        		if(currGroup == null) {
        			// new group of colors
            		currGroup = new Group(i - 1);
            		groups.add(currGroup);
            		currGroup.totalCost = neededTime[i - 1] + neededTime[i];
            		currGroup.maxTime = Math.max(neededTime[i - 1], neededTime[i]);
        		}
        		else {
        			// existing group
        			currGroup.totalCost += neededTime[i];
        			currGroup.maxTime = Math.max(currGroup.maxTime, neededTime[i]);
        		}
        		
        	}
        	else if(currGroup != null) {
        		currGroup.endIndex = i - 1;
        		currGroup = null;
        	}
        }
        if(currGroup != null) {
        	currGroup.endIndex = colors.length() - 1;
        }
        System.out.println(groups);
        /*
         * we need to keep just 1 element in these groups
         * and find keeping which element will cost us less time
         */
        int ret = 0;
        for(Group g : groups) {
        	/*
        	 * find the element with max time
        	 * in each of these groups
        	 */
        	ret += g.totalCost - g.maxTime;
        }
        return ret;
        
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] neededTime = {4,9,3,8,8,9};
		System.out.println(s.minCost("bbbaaa", neededTime));

	}

}
