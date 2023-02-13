package palindromePartitioning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class Partition {
	int start, end;

	public Partition(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	@Override
	public int hashCode() {
		return Objects.hash(end, start);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partition other = (Partition) obj;
		return end == other.end && start == other.start;
	}

	@Override
	public String toString() {
		return "[" + start + ", " + end + "]";
	}
	
	
	
}
public class Solution {

	Set<Partition> globalSet = new HashSet<>();
	
	public List<List<String>> partition(String s) {
		List<List<String>> ret = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
        	ret.add(new ArrayList<>());
        	partition(s, i);
        }
        int length;
        for(Partition p : globalSet) {
        	length = p.end - p.start + 1;
        	ret.get(length - 1).add(s.substring(p.start, p.end + 1));
        }
        
        return ret;
    }

	private void partition(String s, int y){
		
		if(y == 0) {
			globalSet.add(new Partition(0, 0));
			return;
		}
		globalSet.add(new Partition(y, y));
		
		if(s.charAt(y - 1) == s.charAt(y)) globalSet.add(new Partition(y - 1, y));
		
		for(int x = y - 2; x >= 0; x--) {
			if(s.charAt(x) == s.charAt(y) && globalSet.contains(new Partition(x + 1, y - 1))) {
				globalSet.add(new Partition(x, y));
			}
		}
		
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.partition("ababaab"));

	}

}
