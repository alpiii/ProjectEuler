package Questions1To50;
/*
 * Factorial digit sum
Problem 20
n! means n x (n - 1) x ... x 3 x 2 x 1

For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800,
and the sum of the digits in the 
number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.

Find the sum of the digits in the number 100!
 * 
 */

import EulerHelper.BigNumbers;

public class Question20 {

	public static void main(String[] args) {

		final long start = System.nanoTime();
		int i = 100;
		String result = BigNumbers.bigFactorial(i);
		int count = 0;
		for (int j = 0; j < result.length(); j++) {
			count += Integer.valueOf(result.substring(j, j + 1));
		}
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + count);
	}

}
