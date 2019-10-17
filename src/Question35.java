
/*
 * Circular primes
Problem 35
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
How many circular primes are there below one million?
 *
 */

import EulerHelper.PrimeNumbers;

public class Question35 {

    public static void main(String[] args) {

        final long start = System.nanoTime();

        Integer result = 0;

        boolean[] primeNumberList = PrimeNumbers.primeNumberList(1000000);
        int digit = 1; // digit length of the number
        boolean skip = false;
        int num = 0;

        for(int i=2; i<1000000; i++) {

            // digit length is increased if the number is bigger than new power of 10
            if(i > (int) Math.pow(10, digit))
                digit++;

            if(primeNumberList[i]) {
                skip = false;
                num = i;
                for(int j=0; j<digit; j++) {
                    /*
                    lets assume that the number to be checked is 1234
                    below code is calculating the circular possibilities and checking if each of them are prime or not.

                    1234
                    2341
                    3412
                    4123

                    1234 / 1000 = 1
                    1234 % 1000 = 234
                    234 * 10 + 1 = 2341

                    2341 / 1000 = 2
                    2341 % 1000 = 341
                    341 * 10 + 2 = 3412

                    3412 / 1000 = 3
                    3412 % 1000 = 412
                    412 * 10 + 3 = 4123

                    4123 / 1000 = 4
                    4123 % 1000 = 123
                    123 * 10 + 4 = 1234
                    ...
                     */
                    num = (int) ((num % Math.pow(10, (digit-1))) * 10 + (num / Math.pow(10, (digit-1))));
                    if(!primeNumberList[num]) {
                        skip = true; // a circular number is not prime
                        break;
                    }
                }

                if(!skip) {
                    // i is circular prime
                    result++;
                }
            }
        }

        final long end = System.nanoTime();

        System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
    }
}
