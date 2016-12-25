
/*
 * Lexicographic permutations
Problem 24
A permutation is an ordered arrangement of objects. 
For example, 3124 is one possible permutation of the 
digits 1, 2, 3 and 4. If all of the permutations are listed 
numerically or alphabetically, we call it lexicographic order. 
The lexicographic permutations of 0, 1 and 2 are:

012   021   102   120   201   210

What is the millionth lexicographic permutation 
of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * 
 */

import java.util.Arrays;
import EulerHelper.MultipliersDivisors;

public class Question24 {

	public static void main(String[] args) {

		int whichSeq = 1000000;
		char[] chArr = ("9876512340").toCharArray();
		// sorting the numbers
		Arrays.sort(chArr);
		String chars = new String(chArr);
		System.out.println("Result : " + lexicographicPermutation(chars, whichSeq));
	}

	private static String lexicographicPermutation(String chars, int whichSeq) {
		int low = 0;
		int index = 0;
		int count = 0;
		int charCount = chars.length();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < charCount; i++) {
			index = 0;
			// finding the count of the numbers can be written with remaining
			// chars
			count = MultipliersDivisors.factorial(chars.length() - 1);
			// checking the segments if the numbers we are looking in there
			// iterating until our number is in the section
			while (count < whichSeq - low) {
				index++;
				low += count;
			}
			sb.append(chars.charAt(index));

			// removing the used char
			chars = chars.substring(0, index) + chars.substring(index + 1, chars.length());
		}
		return sb.toString();
	}
}
