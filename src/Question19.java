
/*
 * Counting Sundays
Problem 19
You are given the following information, but you may prefer 
to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, 
but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during 
the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 * 
 */

public class Question19 {

	public static void main(String[] args) {

		final long start = System.nanoTime();
		int count = 0;
		for (int y = 1901; y <= 2000; y++) {
			for (int m = 1; m <= 12; m++) {
				if (dayOfWeek(y, m, 1) == 0)
					count++;
			}
		}
		final long end = System.nanoTime();
		System.out.println("Took: " + ((end - start) / 1000000) + "ms. Result : " + count);
	}

	// Zeller's congruence algorithm
	// https://en.wikipedia.org/wiki/Zeller's_congruence
	private static int dayOfWeek(int year, int month, int day) {
		long m = mod((long) month - 3, 4800);
		long y = mod(year + m / 12, 400);
		m %= 12;
		return (int) ((y + y / 4 - y / 100 + (13 * m + 2) / 5 + day + 2) % 7);
	}

	private static long mod(long x, long y) {
		x %= y;
		if (y > 0 && x < 0 || y < 0 && x > 0)
			x += y;
		return x;
	}

}
