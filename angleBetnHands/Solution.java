package angleBetnHands;

public class Solution {

	public double angleClock(int hour, int minutes) {
        if(hour == 12) hour = 0;
        double minAngle = 360 * ((double) minutes / 60);
        double hourAngle = 360* ((double) hour / 12) + 30* ((double) minutes/60);
        double ret = Math.abs(minAngle - hourAngle);
        if(ret > 180) return 360 - ret;
        return ret;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
