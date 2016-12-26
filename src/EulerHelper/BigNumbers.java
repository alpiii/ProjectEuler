package EulerHelper;

public class BigNumbers {

	public static String bigSum(String a, String b) {
		int len = a.length() > b.length() ? a.length() - 1 : b.length() - 1;
		int diff = Math.abs(a.length() - b.length());
		int x, y, carry = 0;
		StringBuilder result = new StringBuilder("");
		while (len >= 0) {

			if (a.length() < (a.length() >= b.length() ? len : len - diff)) {
				x = 0;
			} else {
				if (a.length() >= b.length()) {
					x = Integer.parseInt(a.substring(len, len + 1));
				} else {
					if (len - diff >= 0)
						x = Integer.parseInt(a.substring(len - diff, len - diff + 1));
					else
						x = 0;
				}
			}
			if (b.length() < (b.length() >= a.length() ? len : len - diff)) {
				y = 0;
			} else {
				if (b.length() >= a.length()) {
					y = Integer.parseInt(b.substring(len, len + 1));
				} else {
					if (len - diff >= 0)
						y = Integer.parseInt(b.substring(len - diff, len - diff + 1));
					else
						y = 0;
				}
			}
			carry = (x + y + carry);
			if (carry >= 10) {
				result.insert(0, String.valueOf(carry % 10));
				carry = carry / 10;
			} else {
				result.insert(0, String.valueOf(carry));
				carry = 0;
			}

			len--;
		}
		if (carry != 0) {
			result.insert(0, String.valueOf(carry));
		}

		return result.toString();
	}

	public static String bigMul(String a, String b) {

		String big = a.length() >= b.length() ? a : b;
		String small = a.length() >= b.length() ? b : a;
		StringBuilder[] results = new StringBuilder[small.length()];
		int mul, carry = 0;
		for (int j = small.length() - 1; j >= 0; j--) {
			results[j] = new StringBuilder("");
			if (small.length() - 1 > j) {
				for (int z = 0; z < small.length() - 1 - j; z++) {
					results[j].append("0");
				}
			}
			for (int i = big.length() - 1; i >= 0; i--) {
				mul = Integer.parseInt(big.substring(i, i + 1)) * Integer.parseInt(small.substring(j, j + 1)) + carry;
				if (mul >= 10) {
					results[j].insert(0, String.valueOf(mul % 10));
					carry = mul / 10;
				} else {
					results[j].insert(0, String.valueOf(mul));
					carry = 0;
				}
			}
			if (carry != 0) {
				results[j].insert(0, String.valueOf(carry));
				carry = 0;
			}
		}

		String finalResult = "";
		finalResult = results[0].toString();
		for (int i = 1; i < results.length; i++) {
			finalResult = bigSum(finalResult, results[i].toString());
		}

		return finalResult;
	}

	// valid for exponents greater than or equal to 0.
	public static String bigPow(String num, int exponent) {
		String result = "1";
		for (int i = 0; i < exponent; i++) {
			result = bigMul(result, num);
		}
		return result;
	}

	public static String bigFactorial(int num) {
		String result = "1";
		while (num > 1) {
			result = bigMul(result, String.valueOf(num));
			num--;
		}
		return result;
	}
}
