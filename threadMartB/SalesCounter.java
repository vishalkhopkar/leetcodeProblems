package threadMartB;

import java.util.Queue;

public class SalesCounter implements Runnable {
	int id; 			//Unique sequential identifier for each sales counter
	static int count;	//Counts SalesCounter objects created so far

	
	/**SalesCounter() increments count, initializes id  */
	SalesCounter() {
		id = count++;
	}
	
	/** run() runs while isShopOpen is true. It does the following: 
	 * -	Poll next customer 
	 * -	Print the message: "Salescounter0: CustomerX served. Q length: Y " 
	 * -	Sleep for (processingTime x itemsBought) by Customer 
	 * -	Assign current time to Customer’s dequeueTime 
	 * -	Shop.totalQueueTime += dequeueTime – enqueueTime 
	 * -	Increment Shop.customersServed 
	 * */
	@Override
	public void run() {
		Customer c;
		Queue<Customer> q;
		while(Shop.isShopOpen) {
			q = Shop.customerQ.get(id);
			synchronized(q) {
				c = q.poll();
				
				if(c != null)
					System.out.printf(ThreadMart.spacer(id)+"Salescounter%d: Customer%d served. Q length: %d\n", id, c.id, q.size());
			}
			if(c != null) {
				try {
					Thread.sleep(c.itemsBought * Shop.processingTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				c.dequeueTime = System.currentTimeMillis();
				Shop.totalQueueTime += (c.dequeueTime - c.enqueueTime);
				Shop.customersServed++;
			}
		}
	}
}

