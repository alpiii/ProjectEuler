package Questions1To50;
/*
 * Non-abundant sums
Problem 23
A perfect number is a number for which the sum of its proper 
divisors is exactly equal to the number. For example, the sum 
of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, 
which means that 28 is a perfect number.

A number n is called deficient if the sum of its proper divisors 
is less than n and it is called abundant if this sum exceeds n.

As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, 
the smallest number that can be written as the sum of two 
abundant numbers is 24. By mathematical analysis, it can be 
shown that all integers greater than 28123 can be written as 
the sum of two abundant numbers. However, this upper limit 
cannot be reduced any further by analysis even though it is 
known that the greatest number that cannot be expressed as the 
sum of two abundant numbers is less than this limit.

Find the sum of all the positive integers which cannot be 
written as the sum of two abundant numbers.
 * 
 */

import java.util.List;
import EulerHelper.AbundantNumbers;

public class Question23 {

	public static void main(String[] args) {

		final long start = System.nanoTime();
		int result = nonAbundantNumbers();
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}

	private static int nonAbundantNumbers() {
		int sum = 0;
		int temp = 0;
		int max = 28123;
		int[] sumOfAbundants = new int[max];
		List<Integer> abundantNumbers = AbundantNumbers.abundantNumberList(12, max);
		for (int i = 0; i < abundantNumbers.size(); i++) {
			for (int j = i; j < abundantNumbers.size(); j++) {
				temp = abundantNumbers.get(i) + abundantNumbers.get(j);
				if (temp < max) {
					sumOfAbundants[temp] = -1;
				}
			}
		}
		for (int i = 1; i < sumOfAbundants.length; i++) {
			if (sumOfAbundants[i] != -1)
				sum += (i);
		}
		return sum;
	}
}
