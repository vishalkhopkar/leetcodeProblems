package maxPointsOnALine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


class Line {
	double slope, yIntercept, xIntercept;

	public Line(double slope, double yIntercept, double xIntercept) {
		super();
		this.slope = slope;
		this.yIntercept = yIntercept;
		this.xIntercept = xIntercept;
	}

	@Override
	public String toString() {
		return "Line [slope=" + slope + ", yIntercept=" + yIntercept + ", xIntercept=" + xIntercept + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(slope, xIntercept, yIntercept);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		if(this.slope == 0 && other.slope == 0) {
			return Double.doubleToLongBits(yIntercept) == Double.doubleToLongBits(other.yIntercept);
		}
		return Double.doubleToLongBits(slope) == Double.doubleToLongBits(other.slope)
				&& Double.doubleToLongBits(xIntercept) == Double.doubleToLongBits(other.xIntercept)
				&& Double.doubleToLongBits(yIntercept) == Double.doubleToLongBits(other.yIntercept);
	}

	
	
	
}
public class Solution {

	public int maxPoints(int[][] points) {
		if(points.length <= 2) return points.length;
        Map<Line, Set<Integer>> slopeList = new HashMap<>();	
        
        double slope, yIntercept, xIntercept;
        Line line;
        Set<Integer> pointList;
        int maxPoints = 0;
        for(int i = 0; i < points.length; i++) {
        	/*
        	 * check points[i] with all points encountered earlier
        	 */
        	
        	for(int j = 0; j < i; j++) {
        		if(points[i][0] - points[j][0] != 0) {
        			slope = (double)(points[i][1] - points[j][1])/(double)(points[i][0] - points[j][0]);
        			yIntercept = points[j][1] - slope*points[j][0];
        			if(slope == 0) {
        				xIntercept = Double.MAX_VALUE;
        			}
        			else {
        				xIntercept = (slope*points[j][0] - points[j][1])/slope;
        			}
        		}
        			
        		else {
        			slope = Double.MAX_VALUE;
        			yIntercept = Double.MAX_VALUE;
        			xIntercept = points[j][0];
        		}
        		if(slope == -0.0) slope = 0;
        		line = new Line(slope, yIntercept, xIntercept);
        		pointList = slopeList.get(line);
        		if(pointList == null) {
        			pointList = new HashSet<>();
        			pointList.add(i);
        			pointList.add(j);
        			slopeList.put(line, pointList);
        			
        		}
        		else {
        			slopeList.get(line).add(i);
        		}
        		if(pointList.size() > maxPoints) maxPoints = pointList.size();
        	}
        }
        
        for(Line l : slopeList.keySet()) {
        	System.out.println(l+" : "+slopeList.get(l));
        }
        Iterator<Map.Entry<Line, Set<Integer>>> it = slopeList.entrySet().iterator();
        Line l1 = it.next().getKey();
        Line l2 = it.next().getKey();
        System.out.println(l1.equals(l2));
        System.out.println(l1.slope == 0);
        System.out.println(l2.slope == 0);
        return maxPoints;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] points = {{2,3},{3,3},{-5,3}};
		System.out.println(s.maxPoints(points));

	}

}
