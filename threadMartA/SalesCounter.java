package threadMartA;

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
		while(Shop.isShopOpen) {
			synchronized(Shop.customerQ) {
				c = Shop.customerQ.poll();
			}
			if(c != null) {
				System.out.printf("		Salescounter0: Customer%d served. Q length: %d\n", c.id, Shop.customerQ.size());
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

