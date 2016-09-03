
/*
 * Largest palindrome product
Problem 4
A palindromic number reads the same both ways. 
The largest palindrome made from the product of 
two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of 
two 3-digit numbers.
 * 
 */

import EulerHelper.PalindromeNumbers;

public class Question4 {

	public static void main(String[] args) {
		System.out.println("Result : " + largestPalindrome(3));
	}

	public static int largestPalindrome(int digit) {
		int largest = -1;
		int mul = -1;
		for (int i = (int) (Math.pow(10, digit) - 1); i >= Math.pow(10, digit - 1); i--) {
			for (int j = (int) (Math.pow(10, digit) - 1); j >= Math.pow(10, digit - 1); j--) {
				mul = i * j;
				if (largest >= mul)
					break;
				else {
					largest = PalindromeNumbers.isPalindrome(mul) ? mul : largest;
					if (PalindromeNumbers.isPalindrome(mul)) {
					}
				}
			}
		}
		return largest;
	}

}
