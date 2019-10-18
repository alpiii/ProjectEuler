package Questions1To50;
/*
 * Amicable numbers
Problem 21
Let d(n) be defined as the sum of proper divisors 
of n (numbers less than n which divide evenly into n).
If d(a) = b and d(b) = a, where a ≠ b, then a and b 
are an amicable pair and each of a and b are called amicable numbers.

For example, the proper divisors of 220 are 1, 2, 4, 5, 
10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. 
The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.

Evaluate the sum of all the amicable numbers under 10000.
 * 
 */

import java.util.ArrayList;
import java.util.List;

import EulerHelper.MultipliersDivisors;

public class Question21 {

	public static void main(String[] args) {

		final long start = System.nanoTime();
		final int maxNum = 10000;
		List<Integer> amicableNumbers = new ArrayList<Integer>();
		int divisorSum = 0;
		int otherDivisorSum = 0;
		List<Integer> divisors = null;
		List<Integer> otherDivisors = null;
		for (int i = 2; i < maxNum; i++) {

			// finding the divisors except itself
			divisors = MultipliersDivisors.divisorList(i);
			divisors.remove(divisors.indexOf(i));

			// calculating sum of divisors
			divisorSum = sumOfDivisors(divisors);

			// finding the divisors of sum of divisor except itself
			otherDivisors = MultipliersDivisors.divisorList(divisorSum);
			otherDivisors.remove(otherDivisors.indexOf(divisorSum));

			// calculating sum of divisors
			otherDivisorSum = sumOfDivisors(otherDivisors);

			if (i == otherDivisorSum && i != divisorSum) {
				if (i < maxNum && divisorSum < maxNum) {
					if (!amicableNumbers.contains(i))
						amicableNumbers.add(i);
					if (!amicableNumbers.contains(divisorSum))
						amicableNumbers.add(divisorSum);
				}
			}
		}
		int result = sumOfDivisors(amicableNumbers);
		final long end = System.nanoTime();
		System.out.println(amicableNumbers);
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}

	private static int sumOfDivisors(List<Integer> divisors) {
		int sum = 0;
		for (int i = 0; i < divisors.size(); i++) {
			sum += divisors.get(i);
		}
		return sum;
	}

}
