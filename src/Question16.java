
/*
 * Power digit sum
Problem 16
2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

What is the sum of the digits of the number 2^1000?
 * 
 */

import EulerHelper.BigNumbers;

public class Question16 {

	public static void main(String[] args) {

		final long start = System.nanoTime();
		String pow = BigNumbers.bigPow("2", 1000);
		int sum = 0;
		for (int i = 0; i < pow.length(); i++) {
			sum += Integer.valueOf(pow.substring(i, i + 1));
		}
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + sum);
	}
}
