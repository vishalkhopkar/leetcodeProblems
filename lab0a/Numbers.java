package lab0a;

public class Numbers {
	public static void main(String[] args) {
		Numbers n =  new Numbers();
		System.out.println(n.sayWhat(5));
	}
	//fix this method
	public String sayWhat(int number) {
		return (number % 2 == 0) ? "even" : "odd";
	}
	//fix this method
	public boolean isPrime(int number) {
		for (int i  =  2;   i*i  <= number; i++) {   
			//can you improve this loop??
			if   (number %  i  ==   0) 
				return false;
		}
		return true;
	}
	
	public int nthPrime(int n) {
		/*
		 *  return the nth prime number
		 *  for ex: if n == 1, return 2
		 *  		if n == 2, return 3
		 */
		final int MAX = 100000;
		boolean[] sieve = new boolean[MAX];
		int c = 0;
		for(int i = 2; ; i++) {
			if(!sieve[i]) {
				c++;
				if(c == n) return i;
				for(int j = 1; j*i < MAX; j++) {
					sieve[j*i] = true;
				}
			}
		}
	}
}
