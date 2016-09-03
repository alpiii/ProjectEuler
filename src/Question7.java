
/*
 * 10001st prime
Problem 7
By listing the first six prime numbers: 2, 3, 5, 7, 11, 
and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
 * 
 */

import EulerHelper.PrimeNumbers;

public class Question7 {

	public static void main(String[] args) {

		System.out.println("Result : " + findPrime(10001));
	}

	public static int findPrime(int whichPrime) {
		int count = 0;
		int result = 1;
		while (count != whichPrime) {
			result++;
			if (PrimeNumbers.isPrime(result)) {
				count++;
			}
		}
		return result;
	}
}
