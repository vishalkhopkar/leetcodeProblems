package threadMartB;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Shop implements Runnable{
	
	static List<Queue<Customer>> customerQ; 
	static boolean isShopOpen;  //starts as true. Set to false when all customers served
	static int maxCustomer; //Maximum number of customers created
	static int customersServed; //Incremented after serving each customer
	static int processingTime;	//Time for SalesCounter to process one sale-item
	static long totalQueueTime; //Incremented  after serving each customer
	static int noOfSalesCounters;
	
	List<SalesCounter> salesCounters; //instances of SalesCounter
	Thread[] salesCounterThreads; //threads to run the salesCounters 
	int customerGapTime;	//interval between customer arrivals
	/** setupCounters() takes user inputs, creates SalesCounter object, 
	 * assigns it to salesCounterThread, and starts it 
	 **/
	void setupCounters() {
		processingTime = 20;
		maxCustomer = 10;
		customerGapTime = 20;
		noOfSalesCounters = 3;
		salesCounters = new ArrayList<>(noOfSalesCounters);
		salesCounterThreads = new Thread[noOfSalesCounters];
		isShopOpen = true;
		customerQ = new ArrayList<>();
		for(int i = 0; i < noOfSalesCounters; i++) {
			salesCounters.add(new SalesCounter());
			salesCounterThreads[i] = new Thread(salesCounters.get(i));
			customerQ.add(new LinkedList<>());
			salesCounterThreads[i].start();
		}		
	}

	/** joinQueue() adds customer c to customeQ, 
	 * Prints the message "SalesCounter0: CustomerX joined with Y items. Q length:Z". 
	 * Initialize c’s enqueueTime to current time
	 */
	public void joinQueue(Customer c) {
		c.enqueueTime = System.currentTimeMillis();
		// find the shortest queue
		int minLength = Integer.MAX_VALUE, qLen;
		Queue<Customer> minQ = null;
		Queue<Customer> q;
		int minQId = -1;
		for(int i = 0; i < customerQ.size(); i++) {
			q = customerQ.get(i);
			qLen = q.size();
			if(qLen < minLength) {
				minLength = qLen;
				minQ = q;
				minQId = i;
			}
		}
		
		synchronized(minQ) {
			minQ.offer(c);
			System.out.printf(ThreadMart.spacer(minQId)+"SalesCounter%d: Customer%d joined with %d items. Q length:%d\n",
					minQId, c.id, c.itemsBought, minQ.size());
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
			//System.out.println("");
			if(Customer.count < maxCustomer) {
				c = new Customer();
				joinQueue(c);
				try {
					Thread.sleep(customerGapTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			else {
				System.out.println("**** setting is shop open to false *****");
				isShopOpen = false;
				break;
			}			
			
		}
		
		try {
			for(Thread t : salesCounterThreads)
				t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
