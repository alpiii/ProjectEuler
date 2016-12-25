package EulerHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultipliersDivisors {

	private static int lcm(int a, int b) {
		int m = b;
		while (b % a != 0) {
			b += m;
		}
		return b;
	}

	public static int leastCommonMultiplier(int[] nums) {
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			result = lcm(nums[i], result);
		}
		return result;
	}

	public static List<Integer> divisorList(int num) {
		List<Integer> divisors = new ArrayList<Integer>();
		if (num <= 0)
			return divisors;
		else {
			divisors.add(1);
			if (num != 1)
				divisors.add(num);
			int div = 2;
			while (div <= (num / 2)) {
				if (num % div == 0) {
					if (!divisors.contains(div))
						divisors.add(div);
					if (!divisors.contains(num / div))
						divisors.add(num / div);
					div++;
				} else
					div++;
			}
			Collections.sort(divisors);
			return divisors;
		}
	}

	public static int factorial(int num) {
		if (num <= 1)
			return 1;
		else
			return num * factorial(num - 1);
	}
}