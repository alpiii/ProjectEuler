
/*
 * Longest Collatz sequence
Problem 14
The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:

13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
It can be seen that this sequence (starting at 13 and finishing at 1) 
contains 10 terms. Although it has not been proved yet (Collatz Problem), 
it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 */

public class Question14 {

	public static void main(String[] args) {

		final long start = System.nanoTime();
		int maxLength = 0;
		int currentLength;
		long startNum = 999999;
		int maxLengthNumber = (int) startNum;
		while (startNum >= 1) {
			currentLength = collatzSequenceLength(startNum);
			if (currentLength > maxLength) {
				maxLength = currentLength;
				maxLengthNumber = (int) startNum;
			}
			startNum--;
		}
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + maxLengthNumber);
	}

	private static int collatzSequenceLength(long startNum) {
		int count = 1;
		while (startNum != 1) {
			if (startNum % 2 == 0) {
				startNum /= 2;
			} else {
				startNum = 3 * startNum + 1;
			}
			count++;
		}
		return count;
	}
}
