package lab0a;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
public class TestNumbers {
	Numbers n  =  new Numbers();

	@Test
	public void testSayWhat() {
		//write an   assertEquals statement here to test sayWhat() method 
		//passing '5' as its parameter and checking if it returns odd
		
		//write an assertEquals statement here to test sayWhat() method passing'4' as 
		//its parameter and checking if it returns even
		assertEquals("odd", n.sayWhat(5));
	}
	@Test
	public void testPrime() {
		//write an assertEquals statement here to test isPrime() method passing'5' as 
		//its parameter and checking if it returns true
		assertEquals(true, n.isPrime(5));
		
	}
	
	@Test
	public void testNthPrime() {
		assertEquals(2, n.nthPrime(1));
		assertEquals(3, n.nthPrime(2));
		assertEquals(5, n.nthPrime(3));
		assertEquals(7, n.nthPrime(4));
		assertEquals(11, n.nthPrime(5));
		assertEquals(13, n.nthPrime(6));
		assertEquals(17, n.nthPrime(7));
	}
}
