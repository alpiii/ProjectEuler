package Questions1To50;
/*
 * 1000-digit Fibonacci number
Problem 25
The Fibonacci sequence is defined by the recurrence relation:

Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
Hence the first 12 terms will be:

F1 = 1
F2 = 1
F3 = 2
F4 = 3
F5 = 5
F6 = 8
F7 = 13
F8 = 21
F9 = 34
F10 = 55
F11 = 89
F12 = 144
The 12th term, F12, is the first term to contain three digits.

What is the index of the first term in the 
Fibonacci sequence to contain 1000 digits?
 * 
 */

import EulerHelper.BigNumbers;

public class Question25 {

	public static void main(String[] args) {

		final long start = System.nanoTime();
		int result = fibonacciIndex(1000);
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}

	public static int fibonacciIndex(int digit) {
		if (digit <= 1)
			return 1;
		int index = 2;
		String num1 = "1";
		String num2 = "1";
		String temp = "";
		while (num2.length() != digit) {
			temp = BigNumbers.bigSum(num1, num2);
			num1 = num2;
			num2 = temp;
			index++;
		}
		return index;
	}
}
