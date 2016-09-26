import EulerHelper.BigNumbers;

/*
 * Sum square difference
Problem 6
The sum of the squares of the first ten natural numbers is,

12 + 22 + ... + 102 = 385
The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)2 = 552 = 3025
Hence the difference between the sum of the squares of 
the first ten natural numbers and the square of the 
sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares 
of the first one hundred natural numbers and the 
square of the sum.
 * 
 */

public class Question6 {

	public static void main(String[] args) {

		int squareOfSum = (int) Math.pow(sumOfNumbers(1, 100), 2);
		int sumOfSquares = sumOfSquares(1, 100);
		System.out.println("Result : " + (squareOfSum - sumOfSquares));
	}

	public static int sumOfNumbers(int start, int end) {

		int n = end - start + 1;
		return n * (start + end) / 2;
	}

	public static int sumOfSquares(int start, int end) {
		if (start > 1) {
			return sumOfSquares(1, end) - sumOfSquares(1, 10);
		} else {
			return end * (end + 1) * (2 * end + 1) / 6;
		}
	}
}
