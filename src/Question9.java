
/*
 * Special Pythagorean triplet
Problem 9
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a2 + b2 = c2
For example, 32 + 42 = 9 + 16 = 25 = 52.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 * 
 */

public class Question9 {

	public static void main(String[] args) {

		final long start = System.nanoTime();
		int[] triple = PythagoreanTriples(1000);
		if (triple != null) {
			System.out.println("Triple : " + triple[0] + ", " + triple[1] + ", " + triple[2]);
			System.out.println("Result (a*b*c) : " + triple[0] * triple[1] * triple[2]);
			final long end = System.nanoTime();
			System.out.println("Took: " + ((end - start) / 1000000) + "ms.");
		} else {
			final long end = System.nanoTime();
			System.out.println("Took: " + ((end - start) / 1000000) + "ms. No triple found!");
		}
	}

	private static int[] PythagoreanTriples(int sum) {
		// Quadratic Equations Method to generate Pythagorean Triples
		int a = 0, b = 0, c = 0, m = 2;

		while (m <= sum) {
			for (int n = 1; n < m; n++) {
				a = m * m - n * n;
				b = 2 * m * n;
				c = m * m + n * n;
				// we know that sum of the triple numbers
				// are value of sum variable
				if (a + b + c == sum) {
					return new int[] { a, b, c };
				}
			}
			m++;
		}
		return null;
	}
}
