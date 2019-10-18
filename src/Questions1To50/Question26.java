package Questions1To50;
/*
 * Reciprocal cycles
Problem 26
A unit fraction contains 1 in the numerator. 
The decimal representation of the unit fractions 
with denominators 2 to 10 are given:

1/2	= 	0.5
1/3	= 	0.(3)
1/4	= 	0.25
1/5	= 	0.2
1/6	= 	0.1(6)
1/7	= 	0.(142857)
1/8	= 	0.125
1/9	= 	0.(1)
1/10	= 	0.1
Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. 
It can be seen that 1/7 has a 6-digit recurring cycle.

Find the value of d < 1000 for which 1/d contains the longest 
recurring cycle in its decimal fraction part.
 * 
 */

public class Question26 {

	public static void main(String[] args) {

		final long start = System.nanoTime();
		int result = longestCycle(1000);
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}

	private static int longestCycle(int num) {
		int maxScale = 0;
		int maxNumber = 0;
		int value;
		int scale;
		int z;
		for (int i = 1; i < num; i++) {
			z = num;
			scale = 0;
			value = 10 % i;
			while (value != 1 && z > 0) {
				value = (value * 10) % i;
				scale++;
				z--;
			}
			if (maxScale < scale && z > 1) {
				maxScale = scale;
				maxNumber = i;
			}
		}

		return maxNumber;
	}
}
