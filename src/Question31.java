
/*
 * Coin sums
Problem 31
In England the currency is made up of pound, £, and pence, p, 
and there are eight coins in general circulation:

1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:

1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
 * 
 */

public class Question31 {

	private static final int[] coins = new int[] { 1, 2, 5, 10, 20, 50, 100, 200 };
	private static int result = 0;

	public static void main(String[] args) {

		for (int i = coins.length - 1; i >= 0; i--)
			coinSum(200, i);
		System.out.println("Result : " + result);
	}

	private static void coinSum(int sum, int index) {

		if (sum - coins[index] == 0) {
			result += 1;
		} else if (sum - coins[index] > 0) {
			for (int i = index; i >= 0; i--) {
				coinSum(sum - coins[index], i);
			}
		}
	}
}
