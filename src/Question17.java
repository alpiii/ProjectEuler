
/*
 * Number letter counts
Problem 17
If the numbers 1 to 5 are written out in words: one, two, three, four, 
five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

If all the numbers from 1 to 1000 (one thousand) inclusive 
were written out in words, how many letters would be used?


NOTE: Do not count spaces or hyphens. 
For example, 342 (three hundred and forty-two) contains 23 letters 
and 115 (one hundred and fifteen) contains 20 letters. 
The use of "and" when writing out numbers is in compliance with British usage.
 * 
 */

import EulerHelper.NumberLetterCounts;

public class Question17 {

	public static void main(String[] args) {

		final long start = System.nanoTime();
		int result = lettersOneToThousand();
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}

	private static int lettersOneToThousand() {
		int result = 0;
		NumberLetterCounts nlc = new NumberLetterCounts();
		for (int i = 1; i <= 1000; i++) {
			result += nlc.letterCount(i);
		}
		return result;
	}
}
