package threadMartA;

import java.util.LinkedList;
import java.util.Queue;

public class Shop implements Runnable{
	
	static Queue<Customer> customerQ; 
	static boolean isShopOpen;  //starts as true. Set to false when all customers served
	static int maxCustomer; //Maximum number of customers created
	static int customersServed; //Incremented after serving each customer
	static int processingTime;	//Time for SalesCounter to process one sale-item
	static long totalQueueTime; //Incremented  after serving each customer
	
	SalesCounter salesCounters; //instances of SalesCounter
	Thread salesCounterThreads; //threads to run the salesCounters 
	int customerGapTime;	//interval between customer arrivals
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";
	/** setupCounters() takes user inputs, creates SalesCounter object, 
	 * assigns it to salesCounterThread, and starts it 
	 **/
	void setupCounters() {
		processingTime = 20;
		maxCustomer = 5;
		customerGapTime = 10;
		salesCounters = new SalesCounter();
		salesCounterThreads = new Thread(salesCounters);
		isShopOpen = true;
		customerQ = new LinkedList<>();
		salesCounterThreads.start();
		
	}

	/** joinQueue() adds customer c to customeQ, 
	 * Prints the message "SalesCounter0: CustomerX joined with Y items. Q length:Z". 
	 * Initialize c’s enqueueTime to current time
	 */
	public void joinQueue(Customer c) {
		c.enqueueTime = System.currentTimeMillis();
		synchronized(customerQ) {
			customerQ.offer(c);
			System.out.printf("SalesCounter0: Customer%d joined with %d items. Q length:%d\n",
					c.id, c.itemsBought, customerQ.size());
		}
	}

	/** run() invokes setupCounters(), and runs the following 
	 * as long as CustomersServed < maxCustomer 
	 * - 	If Customer.count < maxCustomer, create new customer and pass it to joinQueue() 
	 * -	Sleep for customerGapTime 
 * -	Set isShopOpen to false 
 * -	Wait for salesCounterThread to join 
	 * */
	@Override
	public void run() {
		setupCounters();
		Customer c;
		while(customersServed < maxCustomer) {
			if(Customer.count < maxCustomer) {
				c = new Customer();
				joinQueue(c);
				
			}
			try {
				Thread.sleep(customerGapTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		System.out.println("**** setting is shop open to false *****");
		isShopOpen = false;
		try {
			salesCounterThreads.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
