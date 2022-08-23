package synchronization;

public class Seat implements Runnable {

	
	@Override
	public void run() {
		for(int count = 0; count < 5; count++) {
			
			System.out.println("Occupied by "+Thread.currentThread().getName()+" Count "+count);
		
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println("Released by "+Thread.currentThread().getName()+" Count "+count);
			
		}
		
		
		
	}
	
	void sit() {
		
	}
		
	

}

