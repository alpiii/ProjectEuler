package Questions1To50;
/*
 * Digit cancelling fractions
Problem 33
The fraction 49/98 is a curious fraction, as an inexperienced mathematician 
in attempting to simplify it may incorrectly believe that 49/98 = 4/8, 
which is correct, is obtained by cancelling the 9s.

We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

There are exactly four non-trivial examples of this type of fraction, 
less than one in value, and containing two digits in the numerator and denominator.

If the product of these four fractions is given in its lowest common terms, 
find the value of the denominator.
 *
 */

import EulerHelper.MultipliersDivisors;

public class Question33 {

	public static void main(String[] args) {
		// i denominator
		// j nominator
		
		final long start = System.nanoTime();
		
		int resultNominator = 1;
		int resultDenominator = 1;
		
		for(int i=11; i<=99; i++) {
			for(int j=10; j<i; j++) {
				
				if(i%10 == 0 || j%10 == 0)
					continue;
				
				if(
						(i/10 == j/10 && (double)j/i == (double)(j%10)/(i%10)) ||
						(i%10 == j/10 && (double)j/i == (double)(j%10)/(i/10)) ||
						(i/10 == j%10 && (double)j/i == (double)(j/10)/(i%10)) ||
						(i%10 == j%10 && (double)j/i == (double)(j/10)/(i/10))
					) {
					resultNominator *= j;
					resultDenominator *= i;
				}
			}
		}
		
		int result = resultDenominator / MultipliersDivisors.gcd(resultNominator, resultDenominator);
		
		final long end = System.nanoTime();

		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}
}
