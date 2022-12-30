package thePerfectTeam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Result {
	
	public static int perfectTeam(String skills) {
		Map<Character, Integer> noOfStudents = new HashMap<>();
		char x;
		Integer noOfStudentsWithSkill;
		for(int i = 0; i < skills.length(); i++) {
			x = skills.charAt(i);
			noOfStudentsWithSkill = noOfStudents.get(x);
			if(noOfStudentsWithSkill == null) {
				noOfStudents.put(x, 1);
			}
			else {
				noOfStudents.put(x, noOfStudentsWithSkill + 1);
			}
		}
		
		// check the map now
		int minStudents = Integer.MAX_VALUE;
		if(noOfStudents.size() < 5) {
			return 0;
		}
		Iterator<Map.Entry<Character, Integer>> it = noOfStudents.entrySet().iterator();
		Map.Entry<Character, Integer> entry;
		while(it.hasNext()) {
			entry = it.next();
			minStudents = Math.min(minStudents, entry.getValue());
		}
		
		return minStudents;

	}
	
	public static void main(String[] args) {
		System.out.println(perfectTeam("pcmpcmbbbzz"));
	}
}
