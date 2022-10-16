package calendar_i;

import java.util.ArrayList;
import java.util.List;

class Event {
	int start, end;

	public Event(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}
	
}
class MyCalendar {
	
	List<Event> events = new ArrayList<>();
	public MyCalendar() {
        
    }
	
    
    public MyCalendar(List<Event> events) {
		super();
		this.events = events;
	}


	public boolean book(int start, int end) {
        // find the event with a start time just lower than
    	// this start
    	int lowerClosest = findFirstSmallest(start);
    	if(lowerClosest == start) return false;
    	
    	return true;
    }
    
	int findFirstSmallest(int val) {
		int start = 0, end = events.size() - 1;
		if(val < events.get(start).start) return -1;
		if(val > events.get(end).start) return end;
		int mid = 0;
		while(end - start > 1) {
			
			mid = (start + end)/2;
			System.out.println("start = "+start+", mid = "+mid+", end = "+end);
			if(events.get(mid).start == val) return mid;
			else if(events.get(mid).start > val) end = mid - 1;
			else start = mid;
		}
		System.out.println("start = "+start+", mid = "+mid);
		return start;
	}
}

public class Solution {	
	
	public static void main(String[] args) {
		List<Event> events = new ArrayList<>();
		events.add(new Event(0, 3));
		events.add(new Event(3, 5));
		events.add(new Event(7, 9));
		events.add(new Event(13, 16));
		MyCalendar myCal = new MyCalendar(events);
		myCal.book(-8,  7);

	}

}
