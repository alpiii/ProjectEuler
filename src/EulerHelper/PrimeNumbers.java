package EulerHelper;

import java.math.BigInteger;

public class PrimeNumbers {

	/**
	 * Checks if a number is prime or not.
	 * 
	 * @param num
	 *            Number that is going to be checked.
	 * @return Returns true if the number is prime.
	 */
	public static boolean isPrime(long num) {
		for (long i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * Finds all prime numbers smaller than or equal to a number. Uses Sieve of
	 * Eratosthenes method. https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
	 * 
	 * @param num
	 *            Indicates the maximum number to check if it is prime or not.
	 * @return Boolean array shows each index value is prime number or not.
	 */
	public static boolean[] primeNumberList(int num) {
		boolean[] primes = new boolean[num + 1];
		for (int i = 0; i < num + 1; i++)
			primes[i] = true;

		for (int i = 2; i <= 2147483647 ? (i * i <= num)
				: (((new BigInteger(String.valueOf(i))
						.multiply(new BigInteger(String.valueOf(i))))
						.compareTo(new BigInteger(String.valueOf(num)))) < 1); i++) {
			if (primes[i]) {
				for (int j = i * 2; j <= num; j += i) {
					primes[j] = false;
				}
			}
		}
		primes[0] = false;
		primes[1] = false;
		return primes;
	}
}
