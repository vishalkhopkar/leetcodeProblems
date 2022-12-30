package rectangleArea;

public class Solution {
	
	public int computeArea(int ax1, int ay1, int ax2, int ay2,
			int bx1, int by1, int bx2, int by2) {
        /*
         * There are several scenarios over here
         * 1. The rectangles are distinct
         */
		int totalArea = totalArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
		if(bx1 >= ax2 || by1 >= ay2 || ay1 >= by2 || ax1 >= bx2) {
			return totalArea;
		}
		//System.out.println("justin");
		// 4 corner intersecting cases
		if(ax1 <= bx1 && bx1 <= ax2 && ax2 <= bx2 && ay1 <= by1 && by1 <= ay2 && ay2 <= by2) {
			return totalArea - (ax2 - bx1)*(ay2 - by1);
		}
		if(bx1 <= ax1 && ax1 <= bx2 && bx2 <= ax2 && ay1 <= by1 && by1 <= ay2 && ay2 <= by2) {
			return totalArea - (bx2 - ax1)*(ay2 - by1);
		}
		if(bx1 <= ax1 && ax1 <= bx2 && bx2 <= ax2 && by1 <= ay1 && ay1 <= by2 && by2 <= ay2) {
			return totalArea - (bx2 - ax1)*(by2 - ay1);
		}
		if(ax1 <= bx1 && bx1 <= ax2 && ax2 <= bx2 && by1 <= ay1 && ay1 <= by2 && by2 <= ay2) {
			return totalArea - (ax2 - bx1)*(by2 - ay1);
		}
		
		
		// 8 edge intersecting cases
		if(ay1 <= by1 && by2 <= ay2 && bx1 >= ax1 && bx2 >= ax2) {
			return totalArea - (by2 - by1)*(ax2 - bx1);
		}
		if(ax1 <= bx1 && bx2 <= ax2 && by1 >= ay1 && by2 >= ay2) {
			
			return totalArea - (bx2 - bx1)*(ay2 - by1);
		}
		if(ay1 <= by1 && by2 <= ay2 && bx1 <= ax1 && bx2 <= ax2) {
			
			return totalArea - (by2 - by1)*(bx2 - ax1);
		}
		if(ax1 <= bx1 && bx2 <= ax2 && by1 <= ay1 && by2 <= ay2) {			
			return totalArea - (bx2 - bx1)*(by2 - ay1);
		}
		
		// other 4 among these 8
		if(by1 <= ay1 && ay2 <= by2 && ax2 >= bx2 && ax1 >= bx1) {
			//System.out.println("timur");
			return totalArea - (ay2 - ay1)*(bx2 - ax1);
		}
		
		if(bx1 <= ax1 && ax2 <= bx2 && ay2 >= by2 && ay1 >= by1) {			
			return totalArea - (ax2 - ax1)*(by2 - ay1);
		}
		if(by1 <= ay1 && ay2 <= by2 && ax1 <= bx1 && ax2 <= bx2) {
			//System.out.println("trudeau");
			return totalArea - (ay2 - ay1)*(ax2 - bx1);
		}
		if(bx1 <= ax1 && ax2 <= bx2 && ay1 <= by1 && ay2 <= by2) {
			return totalArea - (ax2 - ax1)*(ay2 - by1);
		}
		
		//System.out.println("here");
		// one inside the other
		if(bx1 <= ax1 && ax2 <= bx2 && by1 <= ay1 && ay2 <= by2) {
			/*
			 * return B's area 
			 */
			return (bx2 - bx1)*(by2 - by1);
			
		}
		if(ax1 <= bx1 && bx2 <= ax2 && ay1 <= by1 && by2 <= ay2) {
			/*
			 * return A's area
			 */
			return (ax2 - ax1)*(ay2 - ay1);
		}
		
		// plus intersecting 2 cases
		if(ax1 <= bx1 && bx2 <= ax2 && by1 <= ay1 && ay2 <= by2) {
			return totalArea - (ay2 - ay1)*(bx2 - bx1);
		}
		
		return totalArea - (by2 - by1)*(ax2 - ax1);
		
		
    }

	private int totalArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
		return (ax2 - ax1)*(ay2 - ay1) + (bx2 - bx1)*(by2 - by1);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.computeArea(-5, -2, 3, 1, -3, -3, 3, 3));

	}

}
