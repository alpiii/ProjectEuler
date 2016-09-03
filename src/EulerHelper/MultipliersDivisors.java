package EulerHelper;

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
}
