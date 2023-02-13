package openTheLock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Node {
	int[] comb;
	int level;
	public Node(int[] comb, int level) {
		super();
		this.comb = comb;
		this.level = level;
	}
	@Override
	public String toString() {
		return "[" + Solution.makeString(comb) + ", " + level + "]";
	}
	
	
}
public class Solution {

	public int openLock(String[] deadends, String target) {
        Set<String> deadEndSet = new HashSet<>(Arrays.asList(deadends));
        System.out.println(deadEndSet);
        Queue<Node> q = new LinkedList<>();
        int[] init = new int[4];
        q.offer(new Node(init, 0));
        
        Set<String> visited = new HashSet<>(deadends.length);
        visited.add(makeString(init));
        Node n;
        int[] comb;
        while(!q.isEmpty()) {
        	n = q.poll();
        	System.out.println("polled "+n);
        	comb = n.comb;
        	
        	/*
        	 * generate neighbours
        	 */
        	int[] copy;
        	String s;
        	for(int i = 0; i < 4; i++) {
        		copy = Arrays.copyOf(comb, comb.length);
        		if(comb[i] == 0) {
        			copy[i] = 9;
        		}
        		else {
        			copy[i] = comb[i] - 1;
        		}
        		s = makeString(copy);
        		if(target.equals(s)) {
        			return n.level + 1;
        		}
        		if(!deadEndSet.contains(s) && !visited.contains(s)) {
        			if(s.equals("0201")) System.out.println("hi");
        			System.out.println("offering "+s);
        			q.offer(new Node(Arrays.copyOf(copy, copy.length), n.level + 1));
        			visited.add(s);
        		}
        		
        		
        		copy[i] = (comb[i] + 1) % 10;
        		s = makeString(copy);
        		if(target.equals(s)) {
        			return n.level + 1;
        		}
        		if(!deadEndSet.contains(s) && !visited.contains(s)) {
        			if(s.equals("0201")) System.out.println("hi");
        			System.out.println("offering "+s);
        			q.offer(new Node(Arrays.copyOf(copy, copy.length), n.level + 1));
        			visited.add(s);
        		}
        		
        		
        	}
        }
        return 0;
        
    }

	public static String makeString(int[] copy) {
		StringBuilder sb = new StringBuilder();
		for(int x : copy)
			sb.append(x);
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(-1%10);
		int[] p = {4, 3, 5, 1};
		System.out.println(String.valueOf(Arrays.stream(p).mapToObj(String::valueOf)));
		Solution s = new Solution();
		String[] deadends = {"0201","0101","0102","1212","2002"};
		System.out.println(s.openLock(deadends, "0202"));

	}

}
