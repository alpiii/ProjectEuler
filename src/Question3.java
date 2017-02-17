
/*
 * Largest prime factor
Problem 3
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
 * 
 */

public class Question3 {

	public static void main(String[] args) {
		
		final long start = System.nanoTime();
		long result = largestPrimeFactor(600851475143L);
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}

	public static long largestPrimeFactor(long num) {

		long largest = -1;
		long i = 2;
		while (num > 1) {
			if (num % i == 0) {
				num /= i;
				if (largest < i)
					largest = i;
			} else {
				i++;
			}
		}
		return largest;
	}

}
