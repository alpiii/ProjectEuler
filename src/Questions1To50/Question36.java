package Questions1To50;
/*
 * Double-base palindromes
Problem 36
The decimal number, 585 = (1001001001)2 (binary), is palindromic in both bases.
Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
(Please note that the palindromic number, in either base, may not include leading zeros.)
 *
 */

import EulerHelper.PalindromeNumbers;

public class Question36 {

    public static void main(String[] args) {

        final long start = System.nanoTime();

        Integer result = 0;

        String binary = "";
        for(int i=1; i<=1000000;i++) {
            if(PalindromeNumbers.isPalindrome(i)) {
                binary = Integer.toString(i, 2);
                if(PalindromeNumbers.isPalindromeBigNumber(binary))
                    result += i;
            }
        }

        final long end = System.nanoTime();

        System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
    }
}
