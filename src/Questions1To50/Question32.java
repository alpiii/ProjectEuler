package Questions1To50;
/*
 * Pandigital products
Problem 32
We shall say that an n-digit number is pandigital if it makes use of all
the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 × 186 = 7254,
containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product
identity can be written as a 1 through 9 pandigital.

HINT: Some products can be obtained in more than one way so be
sure to only include it once in your sum.
 *
 */

import EulerHelper.PandigitalNumbers;

public class Question32 {

	public static void main(String[] args) {
		
		final long start = System.nanoTime();

		long result = 0;
		for(int i = 1; i < 10000; i++) {
			if(PandigitalNumbers.hasPandigitalProduct(i)) {
				result += i;
			}
		}

		final long end = System.nanoTime();

		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}
}
