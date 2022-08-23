package vishal;

public class PrimeNumbers {
	/*
	 * Prints the first 100 prime numbers
	 */
	
	public static boolean isPrime(int x) {
		System.out.println("checking isprime for "+x);
		for(int i = 2; i*i <= x; i++) {
			if(x % i == 0) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		boolean[] sieve = new boolean[1000];
		int cnt = 0, no = 2;
		while(cnt < 100) {
			if(!sieve[no]) {
				System.out.println(no);
				sieve[no] = false;
				cnt++;
				// mark the multiples for this number as non prime
				for(int j = 2; j*no < 1000; j++) {
					sieve[j*no] = true;
				}
				
			}
			no++;
		}
	}
}
