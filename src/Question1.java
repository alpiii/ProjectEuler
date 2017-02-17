
/*
 * Multiples of 3 and 5
Problem 1
If we list all the natural numbers below 10 that are multiples of 3 or 5, 
we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
 */

public class Question1 {

	public static void main(String[] args) {
		
		final long start = System.nanoTime();
		int result = multiples(3, 5, 1000);
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}

	public static int multiples(int a, int b, int maxNum) {

		int sum = 0;
		for (int i = 1; i < maxNum; i++) {
			if (i % a == 0 || i % b == 0)
				sum += i;
		}
		return sum;
	}
}
