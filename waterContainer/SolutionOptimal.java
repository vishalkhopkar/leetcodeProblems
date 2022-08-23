package waterContainer;

public class SolutionOptimal {

	public static void main(String[] args) {
		int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
		SolutionOptimal sop = new SolutionOptimal();
		System.out.println(sop.maxArea(heights));
	}

	private int maxArea(int[] heights) {
		/*
		 * Start from the edges, whoever is the minimum,
		 * move that pointer to the left
		 * until we get left + 1 == right
		 */
		int maxArea = 0, area = 0;
		int n = heights.length;
		int left = 0, right = n - 1;
		while(left != right) {
			area = Math.min(heights[left], heights[right]) * (right - left);
			if(area > maxArea) maxArea = area;
			if(heights[left] < heights[right]) left++;
			else right--;
		}
		return maxArea;
	}

}
