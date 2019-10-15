
/*
 * Digit factorials
Problem 34
145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
Find the sum of all numbers which are equal to the sum of the factorial of their digits.
Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 *
 */

import java.util.HashMap;

import EulerHelper.BigNumbers;

public class Question34 {

	public static void main(String[] args) {
		
		final long start = System.nanoTime();
		
		Integer result = 0;
		
		// pre calculation of the necessary factorials
		HashMap<Integer, Integer> factorials = new HashMap<Integer, Integer>();
		for(int i=0; i<10; i++) {
			factorials.put(i, Integer.valueOf(BigNumbers.bigFactorial(i)));
		}
		
		Integer upperLimit = factorials.get(9) * 7;
		Integer temp = 0;
		Integer digit = 0;
		for(int i=10; i<upperLimit; i++) {
			temp = 0;
			digit = i;
			while(digit > 0) {
				temp += factorials.get(digit % 10);
				digit /= 10;
			}
			if(temp == i) {
				result += i;
			}
		}
		
		final long end = System.nanoTime();

		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}
}
