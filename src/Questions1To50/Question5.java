package Questions1To50;
/*
 * Smallest multiple
Problem 5
2520 is the smallest number that can be divided by 
each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly 
divisible by all of the numbers from 1 to 20?
 * 
 * 
 */

import EulerHelper.MultipliersDivisors;

public class Question5 {

	public static void main(String[] args) {
		
		final long start = System.nanoTime();
		int result = smallestMultiple(1, 20);
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + result);
	}

	public static int smallestMultiple(int start, int end) {
		int[] nums = new int[end - start + 1];
		int ind = 0;
		for (int i = start; i <= end; i++) {
			nums[ind] = i;
			ind++;
		}
		return MultipliersDivisors.leastCommonMultiplier(nums);
	}

}
