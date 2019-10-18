package Questions1To50;
/*
 * Digit fifth powers
Problem 30
Surprisingly there are only three numbers that 
can be written as the sum of fourth powers of their digits:

1634 = 14 + 64 + 34 + 44
8208 = 84 + 24 + 04 + 84
9474 = 94 + 44 + 74 + 44
As 1 = 14 is not a sum it is not included.

The sum of these numbers is 1634 + 8208 + 9474 = 19316.

Find the sum of all the numbers that can be written 
as the sum of fifth powers of their digits.
 * 
 */

public class Question30 {

	public static void main(String[] args) {

		final long start = System.nanoTime();
		int k;
		int b;
		int sumTemp;
		int sumResult = 0;
		// looping from 2 to 354294.
		// 6 digits, 999999 -> power: 5 = 354294
		for (int i = 2; i < 354294; i++) {
			sumTemp = 0;
			b = i;
			while (b != 0) {
				k = b % 10;
				sumTemp += Math.pow(k, 5);
				b /= 10;
			}
			if (sumTemp == i) {
				sumResult += sumTemp;
			}
		}
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + sumResult);
	}
}
