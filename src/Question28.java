
/*
 * Number spiral diagonals
Problem 28
Starting with the number 1 and moving to the right 
in a clockwise direction a 5 by 5 spiral is formed as follows:

21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13

It can be verified that the sum of the numbers 
on the diagonals is 101.

What is the sum of the numbers on the diagonals 
in a 1001 by 1001 spiral formed in the same way?
 * 
 */

public class Question28 {

	public static void main(String[] args) {

		final long start = System.nanoTime();
		int result = 1 + numberSpiralDiagonals(1001, 3, 2, 1);
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}

	private static int numberSpiralDiagonals(int n, int nOrder, int inc, int num) {
		if (nOrder > n)
			return 0;
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			num += inc;
			sum += num;
		}
		return sum + numberSpiralDiagonals(n, nOrder + 2, inc + 2, num);
	}
}
