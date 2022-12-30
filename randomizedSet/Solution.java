package randomizedSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

	Map<Integer, Integer> table = new HashMap<>();
	int noOfElems = 0;
	List<Integer> pointers = new ArrayList<>();
	Random rand;
	
    public RandomizedSet() {
        rand = new Random();
    }
    
    public boolean insert(int val) {
    	Integer u = table.get(val);
    	if(u != null) return false;
        table.put(val, noOfElems++);
        pointers.add(val);
        return true;
    }
    
    public boolean remove(int val) {
    	Integer u = table.get(val);
    	if(u == null) return false;
    	int loc = u;
    	pointers.set(loc, pointers.get(noOfElems - 1));
    	table.put(pointers.get(noOfElems - 1), loc);
    	pointers.remove(noOfElems - 1);
    	table.remove(val);
    	noOfElems--;
    	//System.out.println("no of elems now "+ noOfElems);
    	return true;
    }
    
    public int getRandom() {
        int randInt = rand.nextInt(noOfElems);
        return pointers.get(randInt);
    }

	@Override
	public String toString() {
		return pointers.toString();
	}
    
    
}


public class Solution {

	public static void main(String[] args) {
		RandomizedSet s = new RandomizedSet();
		s.insert(5);
		s.insert(13);
		System.out.println(s);
		s.remove(5);
		System.out.println(s);
		s.remove(13);
		System.out.println(s);

	}

}
