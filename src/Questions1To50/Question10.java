package Questions1To50;
/*
 * Summation of primes
Problem 10
The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.
 * 
 */

import EulerHelper.PrimeNumbers;

public class Question10 {

	public static void main(String[] args) {

		final long start = System.nanoTime();
		long result = sumOfPrimes(2000000);
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}

	private static long sumOfPrimes(int num) {

		boolean[] primes = PrimeNumbers.primeNumberList(num);
		long result = 0L;
		for (int i = 0; i <= num; i++) {
			if (primes[i])
				result += i;
		}
		return result;
	}
}
