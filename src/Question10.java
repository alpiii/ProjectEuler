
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

		System.out.println("Result : " + sumOfPrimes(2000000));
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
